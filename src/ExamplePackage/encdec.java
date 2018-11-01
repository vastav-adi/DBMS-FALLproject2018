package ExamplePackage;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class encdec {
	
	
	public static void encrypt(UserBean Bean) throws Exception
	{
		String encpass =null;
		String decpass = null;
		if(Bean.getEnct().equals("bf"))
		{
			 encpass= bfish(Bean);
		}
		else if(Bean.getEnct().equals("aes"))
		{
			 encpass= aes(Bean);
		}
		else if(Bean.getEnct().equals("tdes"))
		{
			 encpass= tdes(Bean);
			 
		}
		Bean.setencpassword(encpass);
		decpass= Bean.getdecpassword();
		System.out.println(" "+encpass+" "+decpass);
		
		
	}
		
	/* 				BLOWFISH    			*/
	
public static String bfish(UserBean B) throws Exception {    
KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");    
SecretKey secretkey = keygenerator.generateKey();    
Cipher cipher = Cipher.getInstance("Blowfish");    
cipher.init(Cipher.ENCRYPT_MODE, secretkey);
String inputText = B.getPassword();   

long start = System.currentTimeMillis( );
byte[] encrypted = cipher.doFinal(inputText.getBytes());
long end = System.currentTimeMillis( );
long diff = end - start;
System.out.println("  to encrypt : " + diff +" ms ");
byte[] decrypted = cipher.doFinal(encrypted);
String b = new String(decrypted);

B.settime(diff);
B.setdecpassword(b);

return(new String(encrypted));    
}

	
/* 				AES    			*/
private static SecretKeySpec secretKey;
public static String aes(UserBean B)throws Exception{
	String originalString = B.getPassword();
	final String secretKey = "khddmdcm";
	long start = System.currentTimeMillis( );
	String encryptedString = aesencrypt(originalString, secretKey);
	long end = System.currentTimeMillis( );
	long diff = end - start;
	B.settime(diff);
	System.out.println(encryptedString);
	String decryptedString = aesdecrypt(encryptedString,secretKey);
	
	B.setdecpassword(decryptedString);
	
	return(new String(encryptedString));
	}
	public static String aesencrypt(String strToEncrypt, String secret)
	{
		
	    try
	    {
	        setKey(secret);
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
    public static String aesdecrypt(String todecrypt, String secret)
    {
        try
        {
        	 long start = System.currentTimeMillis( );
            	setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            
            long end = System.currentTimeMillis( );
            long diff = end - start;
            System.out.println("Difference is : " + diff +"ms");
            return new String(cipher.doFinal(Base64.getDecoder().decode(todecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;	
    }
	public static void setKey(String myKey)
	{	
		byte[] key;
		//SecretKeySpec secretKey;
	    MessageDigest sha = null;
	    try {
	        key = myKey.getBytes(StandardCharsets.UTF_8);
	        sha = MessageDigest.getInstance("SHA-1");
	        key = sha.digest(key);
	        key = Arrays.copyOf(key, 16);
	        secretKey = new SecretKeySpec(key, "AES");
	    }
	    catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
		}

								/* 				TDES   			*/

public static String tdes(UserBean B) throws Exception {
String inputText = B.getPassword();
String text = inputText;
long start = System.currentTimeMillis( );
byte[] codedtext = tdesencrypt(text);
long end = System.currentTimeMillis( );
long diff = end-start;
B.settime(diff);
//System.out.println(codedtext); // this is a byte array, you'll just see a reference to an array
String decodedtext = tdesdecrypt(codedtext);
B.setdecpassword(decodedtext);
return(new String(codedtext));
}


public static byte[] tdesencrypt(String message) throws Exception {
final MessageDigest md = MessageDigest.getInstance("md5");
final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
for (int j = 0, k = 16; j < 8;) {
keyBytes[k++] = keyBytes[j++];
	}
final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
cipher.init(Cipher.ENCRYPT_MODE, key, iv);

final byte[] plainTextBytes = message.getBytes("utf-8");
final byte[] cipherText = cipher.doFinal(plainTextBytes);


return cipherText;
}

public static String tdesdecrypt(byte[] message) throws Exception {
    final MessageDigest md = MessageDigest.getInstance("md5");
    final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
            .getBytes("utf-8"));
    final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    for (int j = 0, k = 16; j < 8;) {
        keyBytes[k++] = keyBytes[j++];
    }

    final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
    final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    decipher.init(Cipher.DECRYPT_MODE, key, iv);

  
    final byte[] plainText = decipher.doFinal(message);

    return new String(plainText, "UTF-8");
}
}
	

