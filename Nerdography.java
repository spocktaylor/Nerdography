//package com.your_company_name.app_name;

//Date Created	: 2013-01-01
//Developer	: Spocktaylor
//Description	: Encryption and Decryption Algorythm for large text contents in Android platforms,
//		  fully optimized for performance. minimum 8 key is required to generate encryption

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import android.util.Base64;


import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;

public class Nerdography {
	
	//Encryption method uses two parameters key = "Your Passcode", text = "Text content for Encryption"
	//Returns Encrypted text content as an output
	public static final String Encrypt(String key, String text) {
		try{
			DESKeySpec keySpec = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secKey = keyFactory.generateSecret(keySpec);
			
			byte[] plainText = text.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secKey);
			
			String encryptedText = Base64.encodeToString(cipher.doFinal(plainText), Base64.DEFAULT);
			return encryptedText;
		}
		catch(InvalidKeyException e){
			e.printStackTrace();
		}
		catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		catch(InvalidKeySpecException e){
			e.printStackTrace();
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		catch(BadPaddingException e){
			e.printStackTrace();
		}
		catch(NoSuchPaddingException e) {
			e.printStackTrace();
		}
		catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}
		return text;
	}
	

	//Decryption method uses two parameters key = "Your Passcode", text = "Text content for Encryption"
	//Returns Unencrypted text content as an output
	public static final String Decrypt(String key, String text){
		try{
			DESKeySpec keySpec = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secKey = keyFactory.generateSecret(keySpec);
			
			byte[] encryptedText = Base64.decode(text, Base64.DEFAULT);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, secKey);
			
			byte[] decryptedTextbyte = cipher.doFinal(encryptedText);
			
			String plainText = new String(decryptedTextbyte);
			return plainText;
		}
		catch(InvalidKeyException e){
			e.printStackTrace();
		}
		catch(InvalidKeySpecException e){
			e.printStackTrace();
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		catch(BadPaddingException e){
			e.printStackTrace();
		}
		catch(NoSuchPaddingException e) {
			e.printStackTrace();
		}
		catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}
		return text;
	}

}
