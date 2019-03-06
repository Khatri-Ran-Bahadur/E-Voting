/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.voting;

/**
 *
 * @author DELL
 */
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class MD5 {
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String encrypt(String source) {
   String md5 = null;
   try {
         MessageDigest mdEnc = MessageDigest.getInstance("MD5"); //Encryption algorithm
         mdEnc.update(source.getBytes(), 0, source.length());
         md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
        } 
    catch (Exception ex) {
         return null;
    }
    return md5;
}
 
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(getMD5("Ran"));
        System.out.println(encrypt("Ran"));
    }
}
