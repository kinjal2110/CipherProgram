/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kinjal
 */
public class Veg {
	public static void main(String...s){
		char msg[] = {'T','H','E','J','A','V','A','P','R','O','G','R','A','M','M','E','R'};
		char key[] = {'N','E','E','R','A','J'};
		int msgLen = msg.length, i, j;
		
		char newKey[] = new char[msgLen];
		char encryptedMsg[] = new char[msgLen];
		char decryptedMsg[] = new char[msgLen];
		
		//generate new key in cyclic manner equal to the length of original message
		for(i = 0, j = 0; i < msgLen; ++i, ++j){
			if(j == key.length)
				j = 0;
			
			newKey[i] = key[j];
		}
		
		//encryption
		for(i = 0; i < msgLen; ++i)
			encryptedMsg[i] = (char)(((msg[i] + newKey[i]) % 26) + 'A');
	
		//decryption
		for(i = 0; i < msgLen; ++i)
			decryptedMsg[i] = (char)((((encryptedMsg[i] - newKey[i]) + 26) % 26) + 'A');
		
		System.out.println("Original Message: " + String.valueOf(msg));		//String.valueOf() converts character array to String
		System.out.println("Key: " + String.valueOf(key));
		System.out.println("Generated Key: " + String.valueOf(newKey));
		System.out.println("\nEncrypted Message: " + String.valueOf(encryptedMsg));
		System.out.println("\nDecrypted Message: " + String.valueOf(decryptedMsg));
	}
}
