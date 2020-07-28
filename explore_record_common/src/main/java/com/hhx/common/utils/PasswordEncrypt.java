package com.hhx.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用户密码加密器
 */
public class PasswordEncrypt {

    /**
     * 加密用户密码，当前使用盐值加密的形式
     *
     * @param uuid     用户唯一编号，作为加密盐值
     * @param password 加密前的密码
     * @return 加密后的密码
     */
    public static String encrypt(String uuid, String password) {
        return get(uuid, password);
    }

    private static String get(String... args) {
        String srcString = "";
        for (String s : args) {
            if (null == s) {
                s = "";
            }
            srcString += s;
        }
        MessageDigest messageDigest;
        String encodestr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(srcString.getBytes(StandardCharsets.UTF_8));
            encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodestr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuffer = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}
