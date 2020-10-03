import java.util.*;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
 
 class HillCi
 {
    int[] l_m;
    int[][] k_m;    
    int[] r_m;
    static int ch;
    int [][] nk;
    
    public void perf_Division(String t, int str)
    {
        while (t.length() > str)
        {
            String l = t.substring(0, str);
            t = t.substring(str, t.length());
            calLineMatrix(l);
            if(ch ==1){
                multiplyLineByKey(l.length());
            }else{
                multiplyLineByInvKey(l.length());
            }
            showResult(l.length());
        }
        if (t.length() == str){
            
            if(ch ==1){
            calLineMatrix(t);
            multiplyLineByKey(t.length());
            showResult(t.length());
            }
            else{
                calLineMatrix(t);
                this.multiplyLineByInvKey(t.length());
                showResult(t.length());
            }
        }
        else if (t.length() < str)
        {
            for (int i = t.length(); i < str; i++)
                t = t + 'x';
            if(ch ==1){
            calLineMatrix(t);
            multiplyLineByKey(t.length());
            showResult(t.length());
            }
            else{
                calLineMatrix(t);
                multiplyLineByInvKey(t.length());
                showResult(t.length());
            }
        }
    }
 
 
    public void calKeyMatrix(String key, int len)
    {
        k_m = new int[len][len];
        int k = 0;
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                k_m[i][j] = ((int) key.charAt(k)) - 97;
                k++;
            }
        }
    }
 
    public void calLineMatrix(String l)
    {
        l_m = new int[l.length()];
        for (int i = 0; i < l.length(); i++)
        {
            l_m[i] = ((int) l.charAt(i)) - 97;
        }
    }
 
    public void multiplyLineByKey(int len)
    {
        r_m = new int[len];
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                r_m[i] += k_m[i][j] * l_m[j];
            }
            r_m[i] %= 26;
        }
    }
    public void multiplyLineByInvKey(int len)
    {
        
        r_m = new int[len];
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                r_m[i] += nk[i][j] * l_m[j];
            }
            r_m[i] %= 26;
        }
    }
    
 
    public void showResult(int len)
    {
        String result = "";
        for (int i = 0; i < len; i++)
        {
            result += (char) (r_m[i] + 97);
        }
        System.out.print(result);
    }
 
   
 
    public int calDeter_minant(int A[][], int N)
    {
        int resultOfDet;
        switch (N) {
            case 1:
                resultOfDet = A[0][0];
                break;
            case 2:
                resultOfDet = A[0][0] * A[1][1] - A[1][0] * A[0][1];
                break;
            default:
                resultOfDet = 0;
                for (int j1 = 0; j1 < N; j1++)
                {
                    int m[][] = new int[N - 1][N - 1];
                    for (int i = 1; i < N; i++)
                    {
                        int j2 = 0;
                        for (int j = 0; j < N; j++)
                        {
                            if (j == j1)
                                continue;
                            m[i - 1][j2] = A[i][j];
                            j2++;
                        }
                    }
                    resultOfDet += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1]
                            * calDeter_minant(m, N - 1);
                }   break;
        }
        return resultOfDet;
    }
 
    public void cofact(int num[][], int f)
    {
        int b[][], fac[][];
        b = new int[f][f];
        fac = new int[f][f];
        int p, q, m, n, i, j;
        for (q = 0; q < f; q++)
        {
            for (p = 0; p < f; p++)
            {
                m = 0;
                n = 0;
                for (i = 0; i < f; i++)
                {
                    for (j = 0; j < f; j++)
                    {
                        b[i][j] = 0;
                        if (i != q && j != p)
                        {
                            b[m][n] = num[i][j];
                            if (n < (f - 2))
                                n++;
                            else
                            {
                                n = 0;
                                m++;
                            }
                        }
                    }
                }
                fac[q][p] = (int) Math.pow(-1, q + p) * calDeter_minant(b, f - 1);
            }
        }
        trans(fac, f);
    }
 
    void trans(int fac[][], int r)
    {
        int i, j;
        int b[][], inv[][];
        b = new int[r][r];
        inv = new int[r][r];
        int d = calDeter_minant(k_m, r);
        int mi = mi(d % 26);
        mi %= 26;
        if (mi < 0)
            mi += 26;
        for (i = 0; i < r; i++)
        {
            for (j = 0; j < r; j++)
            {
                b[i][j] = fac[j][i];
            }
        }
        for (i = 0; i < r; i++)
        {
            for (j = 0; j < r; j++)
            {
                inv[i][j] = b[i][j] % 26;
                if (inv[i][j] < 0)
                    inv[i][j] += 26;
                inv[i][j] *= mi;
                inv[i][j] %= 26;
            }
        }
        
        nk = inv;
    }
 
    public int mi(int d)
    {
        int q, r1, r2, r, t1, t2, t;
        r1 = 26;
        r2 = d;
        t1 = 0;
        t2 = 1;
        while (r1 != 1 && r2 != 0)
        {
            q = r1 / r2;
            r = r1 % r2;
            t = t1 - (t2 * q);
            r1 = r2;
            r2 = r;
            t1 = t2;
            t2 = t;
        }
        return (t1 + t2);
    }
 
    public void matrixtoinvkey(int inv[][], int n)
    {
        string invkey = "";
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                invkey += (char) (inv[i][j] + 97);
            }
        }
        System.out.print(invkey);
    }
     public boolean check(String key, int len)
    {
        calKeyMatrix(key, len);
        int d = calDeter_minant(k_m, len);
        d = d % 26;
        if (d == 0)
        {
            System.out.println("Key is not invertible");
            return false;
        }
        else if (d % 2 == 0 || d % 13 == 0)
        {
            System.out.println("Key is not invertible");
            return false;
        }
        else
        {
            return true;
        }
    }
 
    public static void main(String args[]) throws IOException
    {
        HillCi obj = new HillCi();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Menu:\n1: Encryption\n2: Decryption");
        ch = Integer.parseInt(in.readLine());
        System.out.println("Enter the line: ");
        String l = in.readLine();
        System.out.println("Enter the key: ");
        String key = in.readLine();
        double sq = Math.sqrt(key.length());
        if (sq != (long) sq)
            System.out.println("Cannot For_m a square matrix");
        else
        {
            int size = (int) sq;
            if (obj.check(key, size))
            {
                
                System.out.println("Result:");
                obj.cofact(obj.k_m, size);
                obj.perf_Division(l, size);
                
                
            }
        }
    }
}