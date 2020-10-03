/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kinjal
 */
import java.util.*;
public class Ceaser_cipher {
    public static final String letter = "abcdefghijklmnopqrstuvwxyz";
    public static String encrypt(String plain, int key)
    {
        plain = plain.toLowerCase();
        String cipher = "";
        
        for(int i = 0;i<plain.length();i++)
        {
            int mapping = letter.indexOf(plain.charAt(i));
            int eval = (key+mapping) % 26;
            char val = letter.charAt(eval);
            cipher = cipher + val;
            
        }
        return cipher;
    }
    public static String decode(String cipher, int key)
    {
        cipher = cipher.toLowerCase();
        String plain = "";
        
        for(int i =0;i< cipher.length();i++)
        {
            int mapping = letter.indexOf(cipher.charAt(i));
            int dval = (mapping - key) % 26;
            if(dval<0)
            {
                dval = letter.length()+dval;
            }
            char val = letter.charAt(dval);
            plain = plain +val;
        }
        return plain;
    }
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
    
        System.out.println("Enter String of message: ");
       Scanner k= new Scanner(System.in);
        String msg = new String();
        msg = sc.next();       
       System.out.println("Enter key of message: ");
//        String s=sc.nextLine();
 
       
        int key = k.nextInt();
       System.out.println("Encrypted text: "+encrypt(msg, key));
       System.out.print("Decrypted text: ");
       System.out.println(decode(encrypt(msg, key), key));
    }
}
