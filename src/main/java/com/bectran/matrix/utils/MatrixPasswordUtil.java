package com.bectran.matrix.utils;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

import com.Ostermiller.util.RandPass;
import com.bectran.matrix.framework.AppLogger;

/**
 * @author Louis Ifeguni Jun 22, 2007: 1:57:57 PM
 */
public class MatrixPasswordUtil {
    public static final int STANDARD_PASSWORD_LENGTH = 8;

    public static String generatePassword() {
        RandPass randPass = new RandPass(RandPass.NUMBERS_AND_LETTERS_ALPHABET);
        return randPass.getPass(STANDARD_PASSWORD_LENGTH);
    }

    public static String generate2LetterWord() {
        RandPass randPass = new RandPass(RandPass.UPPERCASE_LETTERS_ALPHABET);
        return randPass.getPass(2);
    }

    public static String encryptPassword(String clearText) {
        MessageDigest md = null;
        String encryptedPwd = null;
        String trimmedClearText = clearText.trim();
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] ba = trimmedClearText.getBytes("UTF8");
            md.update(ba);
            // based on commoncoder 1.6
            encryptedPwd = Base64.encodeBase64String(md.digest());
        }
        catch (Exception exp) {
            exp.printStackTrace();
            AppLogger.log(AppLogger.FATAL, "PASSWORD ENCRYPTION FAILED", exp);
        }
        return encryptedPwd;
    }

    public static String generatePassword(int length) {
        RandPass randPass = new RandPass(RandPass.NUMBERS_AND_LETTERS_ALPHABET);
        return randPass.getPass(length);
    }

    public static String generateID() {
        RandPass randPass = new RandPass(RandPass.NUMBERS_AND_LETTERS_ALPHABET);
        return randPass.getPass(20);
    }

    public static String encryptPasswordAPI(String clearText) {
        MessageDigest md = null;
        String encryptedPwd = null;
        String trimmedClearText = clearText.trim();
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] ba = trimmedClearText.getBytes("UTF8");
            md.update(ba);
            // String e1 = new String(e1byte);
            String e2 = new sun.misc.BASE64Encoder().encode(md.digest());
            String e3 = Base64.encodeBase64String(md.digest());
            //
            // System.out.println(e1);
            System.out.println(e2);
            System.out.println(e3);
        }
        catch (Exception exp) {
            exp.printStackTrace();
            AppLogger.log(AppLogger.FATAL, "PASSWORD ENCRYPTION FAILED", exp);
        }
        return encryptedPwd;
    }

    public static void main(String[] args) throws Exception {
        encryptPasswordAPI("louis");
        /*
         * String eca ="2C7OjVFKyn4k0/wR+7ja2lfylmw="; String qq=null;; String
         * clearText = "louis"; String ec1 = encryptPassword(clearText); String
         * ec2 = encryptPassword(clearText); System.out.println("ec1 : "
         * +ec1.length()); System.out.println("ec2 : "+ec2); System.out.println(
         * "Encrypted clearText works : "+(qq.equals(ec2)));
         */
        // for(int i=0; i<5;i++){
        // System.out.println("ans : "+generate2LetterWord());
        // }
    }
}
