package com.hhx.common.utils;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class TextEncryptor {
    private static final byte[] DES_KEY = {19, 83, 0, 33, 0, 20, 10, -128, -65, 44, -2};

    public static String encrypt(String data) {
        String encryptedData = null;
        Cipher cipher = initCipher(Cipher.ENCRYPT_MODE);
        try {
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return encryptedData;
    }

    public static String decrypt(String cryptData) {
        String decryptedData = null;
        Cipher cipher = initCipher(Cipher.DECRYPT_MODE);
        try {
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
        } catch (IllegalBlockSizeException | BadPaddingException | IOException e) {
            e.printStackTrace();
        }
        return decryptedData;
    }

    private static Cipher initCipher(int mode) {
        Cipher cipher = null;
        try {
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(DES_KEY);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            cipher = Cipher.getInstance("DES");
            cipher.init(mode, key, sr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        return cipher;
    }
}
