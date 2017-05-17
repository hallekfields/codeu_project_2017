import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class MessageSecurity {

    public MessageSecurity () {}


/*
    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IOException {

        messageSecurity mesSecure = new messageSecurity();
        String encryptText = mesSecure.encrypt("Hello");
        System.out.println("Encrypted Text: " + encryptText);
        String decryptText = mesSecure.decrypt(encryptText);
        System.out.println("Decrypted Text: " + decryptText);

    }
*/


    public String encrypt(String data) throws BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        //key , takes in a 16 character long key for AES algorithm
        byte[] keyArray = "1234567890123456".getBytes();
        Key key = new SecretKeySpec(keyArray, "AES");

        //Encrytion
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        c.init(Cipher.ENCRYPT_MODE, getKey());
        byte[] encryptionValue = c.doFinal(data.getBytes());
        String encryptedStringResult = new BASE64Encoder().encode(encryptionValue);
        return encryptedStringResult;

    }



    public String decrypt(String encryptedText) throws BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {

        //Encrytion
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        c.init(Cipher.DECRYPT_MODE, getKey());
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedText);
        byte[] decryptValue = c.doFinal(decodedValue);
        String decryptedFinalResult = new String(decryptValue);
        return decryptedFinalResult;

    }



    public Key getKey(){

        //key , takes in a 16 character long key for AES algorithm
        byte[] keyArray = "1234567890123456".getBytes();
        Key key = new SecretKeySpec(keyArray, "AES");
        return key;

    }



}
