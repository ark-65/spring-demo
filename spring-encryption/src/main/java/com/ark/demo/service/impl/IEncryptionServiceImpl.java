package com.ark.demo.service.impl;

import com.ark.demo.service.IEncryptionService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 18/6/25
 * Time: 上午11:12
 **/
@Service
public class IEncryptionServiceImpl implements IEncryptionService {

    private static final String SALT = "tamboo";

    @Override
    public String MD5Util(String password) {

        password = password + SALT;

        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];

        }
        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();
        StringBuffer key = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            System.out.print(val + ",");
            hexValue.append(Integer.toHexString(val));

        }

        return hexValue.toString();
    }
}
