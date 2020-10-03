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
class Vigenere {
  public static void main(String args[])
  {
      char msg[]={'S','E','C','U','R','I','T','Y'};
      char key[] = {'G','E','C'};
      int msglen = msg.length, i, j;
      char newkey[] = new char[msglen];
      char encmsg[] = new char[msglen];
      char decmsg[] = new char[msglen];
      
      for(i=0, j=0; i<msglen; i++,j++)
      {
            if(j == key.length)
            {
              j = 0;
            }
            newkey[i] = key[j];
          
      }
      //Encryptiom
      for(i=0 ; i<msglen; i++)
      {
          encmsg[i] = (char)(((msg[i] + newkey[i]) %26) + 'A');
      }
      //Decryption
      for(i=0; i<msglen; i++)
      {
          decmsg[i] = (char)((((encmsg[i] - newkey[i]) + 26)% 26) + 'A');
      }
      System.out.println("Original msg: "+String.valueOf(msg));
      System.out.println("Key: "+String.valueOf(key));
      System.out.println("Generated key: "+String.valueOf(newkey));
      System.out.println("Encrypted msg: "+String.valueOf(encmsg));
      System.out.println("Decrypted msg: "+String.valueOf(decmsg));
  }
}
