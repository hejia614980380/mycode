package com.hejia.demo;

import org.junit.Test;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HejiaDeno4 {
    private static final String password = "Gdzm@2022";

    /**
     * 使用AES算法进行加密
     *
     * @param str
     * @return
     */
    public static String jdkAESEncode(String str) {
        try {
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            keyGenerator.init(128, secureRandom);
            //生成密钥
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytes = secretKey.getEncoded();
            long start = System.currentTimeMillis();
            //key转换
            Key key = new SecretKeySpec(bytes, "AES");
            System.out.println(new String(key.getEncoded()));
            //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(str.getBytes());
            String string = Base64Utils.encodeToString(result);

            System.out.println(System.currentTimeMillis() - start);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public  void test13() {


        System.out.println(jdkAESEncode("hahaha"));
    }

    @Test
    public  void test1() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            keyGenerator.init(128, secureRandom);
            //生成密钥
            SecretKey secretKey = keyGenerator.generateKey();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        // 按指定模式在字符串查找
        String line = "com.egova.wuneng.cgdb.service.impl";
        String pattern = "(com\\.egova\\.wuneng\\.)(\\w+)(\\.service\\.impl)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void test3() {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.get("haha"));

    }
}
