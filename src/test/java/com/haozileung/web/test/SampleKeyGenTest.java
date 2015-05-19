package com.haozileung.web.test;

import org.apache.shiro.codec.Base64;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class SampleKeyGenTest {
    @Test
    public void test() {
        LoggerFactory.getLogger(SampleKeyGenTest.class).info("test...");
        KeyGenerator keygen = null;
        try {
            keygen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }
        SecretKey deskey = keygen.generateKey();
        System.out.println(Base64.encodeToString(deskey.getEncoded()));
    }
}
