package gafetes.db;

import javax.crypto.*;
import java.security.*;
import java.security.spec.*; 
import javax.crypto.spec.*;
import java.io.UnsupportedEncodingException;
import gafetes.beans.Usuario;

public class DesEncrypter {
        Cipher ecipher;
        Cipher dcipher;
    
        // 8-byte Salt
        byte[] salt = {
            (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
            (byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03
        };
    
        // Iteration count
        int iterationCount = 19;
    
        public DesEncrypter(String passPhrase) {
            try {
                // Create the key
                KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
                SecretKey key = SecretKeyFactory.getInstance(
                    "PBEWithMD5AndDES").generateSecret(keySpec);
                ecipher = Cipher.getInstance(key.getAlgorithm());
                dcipher = Cipher.getInstance(key.getAlgorithm());
    
                // Prepare the parameter to the ciphers
                AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
    
                // Create the ciphers
                ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
                dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            } catch (java.security.InvalidAlgorithmParameterException e) {
            } catch (java.security.spec.InvalidKeySpecException e) {
            } catch (javax.crypto.NoSuchPaddingException e) {
            } catch (java.security.NoSuchAlgorithmException e) {
            } catch (java.security.InvalidKeyException e) {
            }
        }
    
        public String encrypt(String str) {
            try {
                // Encode the string into bytes using utf-8
                byte[] utf8 = str.getBytes("UTF8");
    
                // Encrypt
                byte[] enc = ecipher.doFinal(utf8);
    
                // Encode bytes to base64 to get a string
                return new sun.misc.BASE64Encoder().encode(enc);
            } catch (javax.crypto.BadPaddingException e) {
            } catch (IllegalBlockSizeException e) {
            } catch (UnsupportedEncodingException e) {
            } catch (java.io.IOException e) {
            }
            return null;
        }
    
        public String decrypt(String str) {
            try {
                // Decode base64 to get bytes
                byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
    
                // Decrypt
                byte[] utf8 = dcipher.doFinal(dec);
    
                // Decode using utf-8
                return new String(utf8, "UTF8");
            } catch (javax.crypto.BadPaddingException e) {
            } catch (IllegalBlockSizeException e) {
            } catch (UnsupportedEncodingException e) {
            } catch (java.io.IOException e) {
            }
            return null;
        }
    


    public static void main(String args[]) {
	    // Here is an example that uses the class
	   // try {
	        // Create encrypter/decrypter class
	        DesEncrypter cadena = new DesEncrypter("123456");
                
                String str = cadena.encrypt("rodeo");
                System.out.println(str);
                
                String ostr = cadena.decrypt(str);               
                System.out.println(ostr);
                return ;
                
                
	       /* SampleDigester xmlDigester = new SampleDigester();
	        
	        try
	    	{
	      		xmlDigester.xml2Object();
			}
		    catch(Exception e)
		    {
		      e.printStackTrace();
		    }
		    
		    DataSource ds = xmlDigester.getConfiguration();        
		    DataSource ds2 = new DataSource();
	        DesEncrypter encrypter = new DesEncrypter("12345");
	        
	        Usuario user = new Usuario();        
	        user.setNombre(encrypter.decrypt(ds.getUserName()));
	        user.setPassword(encrypter.decrypt(ds.getPassword()));
	        
	        
	       System.out.println("El usuario--->>"+user.getNombre());
	       System.out.println("La clave  --->>"+user.getPassword());
	       
			
		} catch (Exception e) {
		
		}*/
	}
	

}
