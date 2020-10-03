/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kinjal
 */
import java.util.Scanner;
public class Monoalphabetic_cipher {
    public static void main(String args[])
    {
        final char plainalpha[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        final char cipheralpha[] = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
        Scanner s = new Scanner(System.in);
        String ptext;
        char ctext[] = new char[20];
        char dtext[] = new char[20];
        int i,j, store;
        System.out.println("Enter any text ");
        ptext = s.nextLine();
        ptext = ptext.toLowerCase();
        store =(ptext.length());
        for(i=0;i<store;i++)
        {
            for(j=0;i<26;j++)
            {
                if(plainalpha[j] == ptext.charAt(i))
                {
                    ctext[i] = cipheralpha[j];
                    break;
                }
            }
        }
        System.out.println("Cipher text: ");
        for(i=0;i<store;i++)
        {
            System.out.print(ctext[i]);
        }
        String b = new String(ctext);
        for(i=0;i<store;i++)
        {
            for(j=0;j<26;j++)
            {
                if(cipheralpha[j] == b.charAt(i))
                {
                    dtext[i] = plainalpha[j];
                    break;
                }
            }
        }
        System.out.print("\nPlain Text:  ");
        for(i=0;i<store;i++)
        {
            System.out.print(dtext[i]);
        }
    }
}
