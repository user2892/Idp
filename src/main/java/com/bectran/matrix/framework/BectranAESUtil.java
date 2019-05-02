package com.bectran.matrix.framework;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64;

public class BectranAESUtil {
    private static final String ALGORITHM = "AES";
    private static final int ITERATIONS = 2;
    private static final byte[] keyValue = new byte[] {'T', 'h', 'i', 's', 'I',
            's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

    private static String encrypt(String value, String salt) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        String valueToEnc = null;
        String eValue = value;
        for (int i = 0; i < ITERATIONS; i++) {
            valueToEnc = salt + eValue;
            byte[] encValue = c.doFinal(valueToEnc.getBytes(Charset.defaultCharset()));
            eValue = new String(Base64.encodeBase64(encValue),Charset.defaultCharset());
        }
        return eValue;
    }

    private static String decrypt(String value, String salt) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        String dValue = null;
        String valueToDecrypt = value;
        for (int i = 0; i < ITERATIONS; i++) {
            byte[] decordedValue = Base64
                    .decodeBase64(valueToDecrypt.getBytes(Charset.defaultCharset()));
            byte[] decValue = c.doFinal(decordedValue);
            dValue = new String(decValue,Charset.defaultCharset()).substring(salt.length());
            valueToDecrypt = dValue;
        }
        return dValue;
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        // SecretKeyFactory keyFactory =
        // SecretKeyFactory.getInstance(ALGORITHM);
        // key = keyFactory.generateSecret(new DESKeySpec(keyValue));
        return key;
    }

    private static String encodeString(String s) {
        String encodedString = s;
        try {
            encodedString = URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
        }
        return encodedString;
    }

    private static String decodeString(String s) {
        String decodedString = s;
        try {
            decodedString = URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
        }
        return decodedString;
    }

    public static String generateEncodedSsoKey(String value, String salt)
            throws Exception {
        String encryptedValue = encrypt(value, salt);
        String encodedValue = encodeString(encryptedValue);
        //
        return encodedValue;
    }

    public static String decryptEncodedSsoKey(String encodedValue, String salt)
            throws Exception {
        String decodedValue = decodeString(encodedValue);
        String decryptedValue = decrypt(decodedValue, salt);
        //
        return decryptedValue;
    }

    public static String encryptKey(String value, String salt)
            throws Exception {
        String encryptedValue = encrypt(value, salt);
        String encodedValue = encodeString(encryptedValue);
        //
        return encodedValue;
    }

    public static String decryptKey(String encodedValue, String salt)
            throws Exception {
        String decodedValue = decodeString(encodedValue);
        String decryptedValue = decrypt(decodedValue, salt);
        //
        return decryptedValue;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // String password = "mypassword";
        String password = "lousojusis.ifegeessjkjs@hotmail.com";
        // String salt = "this is a simple clear salt";
        String salt = "GFGFGFGFUIIU";
        String passwordEnc = BectranAESUtil.encrypt(password, salt);
        String passwordDec = BectranAESUtil.decrypt(passwordEnc, salt);
        System.out.println("Salt Text : " + salt);
        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted : " + passwordEnc);
        System.out.println(
                "Encrypted-passwordEnc.length(): " + passwordEnc.length());
        System.out.println("Decrypted : " + passwordDec);
        //
        String encoded = encodeString(passwordEnc);
        System.out.println("encoded) : " + encoded);
        System.out.println("decodeString(encoded) : " + decodeString(encoded));
    }
}
