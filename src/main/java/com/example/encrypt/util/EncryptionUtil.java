package com.example.encrypt.util;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {

    private static final String ALGORITHM = "AES";
    private static final String AES_CBC_PKCS_5_PADDING = "AES/CBC/PKCS5Padding";
    private static final String KEY = "your_strong_secret_key_here";
    private static final String IV = KEY.substring(0, 16);

    public static String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS_5_PADDING);
        SecretKeySpec secretKeySpec = new SecretKeySpec(IV.getBytes(), ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS_5_PADDING);
        SecretKeySpec secretKeySpec = new SecretKeySpec(IV.getBytes(), ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted);
    }
}
