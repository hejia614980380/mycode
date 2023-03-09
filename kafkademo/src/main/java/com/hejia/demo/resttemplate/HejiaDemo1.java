package com.hejia.demo.resttemplate;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.security.Key;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: hj
 * @Date: 2021/6/10 9:49
 */
@Slf4j
public class HejiaDemo1 {
    private static RestTemplate restTemplate;

    static {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setConnectTimeout(5 * 1000);
//        factory.setReadTimeout(20 * 1000);
//        restTemplate = new RestTemplate(factory);
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        messageConverters.add(new StringHttpMessageConverter());
//        restTemplate = new RestTemplate(messageConverters);
        restTemplate = new RestTemplate();
    }

    @Test
    public void test_1() {
//        System.out.println(Collections.emptyList().contains(null));
//        List<Object> objects = Collections.emptyList().subList(0, 100);
        String tableName = "tc_video_cell";
        String outFields = "device_guid,location,coord_x,coord_y,device_name" ;
        String whereStr = " valid_flag = 1 and online_flag = 1 ";
        JSONObject object = new JSONObject();
        object.put("tableName", tableName);
        object.put("xFieldName", "coord_x");
        object.put("yFieldName", "coord_y");
        object.put("outFields", outFields);
        object.put("whereStr", whereStr);
        try {
            System.out.println(URLEncoder.encode(object.toString(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        String url = "http://localhost:8038/free/hejia/test/{id}";
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class, map);
        log.info("返回结果:{}", result.getBody());
    }

    @Test
    public void test2() {
        String url = "http://localhost:8038/free/hejia/test1?id=1";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        log.info("返回结果:{}", result.getBody());
    }

    @Test
    public void test7() {
        String url = "http://localhost:8038/free/hejia/test1?id={id}";
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class, map);
        log.info("返回结果:{}", result.getBody());
    }

    @Test
    public void test3() {
        /**
         * {
         *   "grant_type": "password",
         *   "client_id": "unity-client",
         *   "username": "test",
         *   "client_secret": "unity",
         *   "password": "123456"
         * }
         */
        String loginUrl = "http://localhost:8038/oauth/extras/token";
        String url = "http://localhost:8038/free/hejia/test1?id=1";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> map = new HashMap<>(8);
        map.put("grant_type", "password");
        map.put("client_id", "unity-client");
        map.put("username", "test");
        map.put("client_secret", "unity");
        map.put("password", "123456");
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(map, headers);
        ResponseEntity<String> result = restTemplate.exchange(loginUrl, HttpMethod.POST, httpEntity, String.class);
        HttpHeaders headers1 = result.getHeaders();
        log.info("返回结果:{}", result.getBody());
    }

    @Test
    public void test4() {
        String url = "http://localhost:8038/free/hejia/test2";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("csn", "csn");
        paramMap.add("key", "key");
        paramMap.add("msg", "这是一条消息");
        paramMap.add("csn", true);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(paramMap, headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        log.info("返回结果:{}", result.getBody());
    }

    @Test
    public void test5() {
        System.out.println("330502".regionMatches(2, "0000", 0, 2));
    }

    @Test
    public void test6() {
        String loginUrl = "http://120.221.95.146:10000/login/keylogin?appkey=191FD072A8F2B2DBD1838B82FE79489D";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(loginUrl, HttpMethod.POST, httpEntity, String.class);
        String content = result.getHeaders().get("Set-Cookie").get(0);
        headers.add(HttpHeaders.COOKIE, content);
        String url = "http://120.221.95.146:10000/overview/runningstat";
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void test8() {
        String text = "hejia";
        System.out.println(text.substring(text.indexOf("-") + 1));
    }

    @Test
    public void test9() {
        Map<String, Integer> map = new HashMap<>();
        int reportNum = 0;
        int confirmNum = 0;
        double rate;
        if (reportNum == 0) {
            rate = 100;
        } else {
            rate = BigDecimal.valueOf((confirmNum * 100.0 / reportNum)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        DecimalFormat df = new DecimalFormat("#.00");
        Double aDouble = Double.valueOf(df.format(rate));
        map.put("1", 1);
        map.put("5", 5);
        map.put("3", 3);
        map.put("10", 10);
        map.put("8", 8);
        map.put("7", 7);
        map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(me -> System.out.println(me.getValue()));
    }

    @Test
    public void test10() {
        String text = "70020428";
        System.out.println(text.substring(0, 3));
        System.out.println(text.substring(3));
    }

    @Test
    public void test11() {
        /**
         * {
         *   "grant_type": "password",
         *   "client_id": "unity-client",
         *   "username": "test",
         *   "client_secret": "unity",
         *   "password": "123456"
         * }
         */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before = now.minusDays(30);
        String nowStr = dtf.format(now) + " 23:59:59";
        String beforeStr = dtf.format(before) + " 00:00:00";
        String loginUrl = "http://localhost:8038/oauth/extras/token";
        String url = "http://localhost:8038/free/hejia/test1?id=1";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> map = new HashMap<>(8);
        map.put("grant_type", "password");
        map.put("client_id", "unity-client");
        map.put("username", "test");
        map.put("client_secret", "unity");
        map.put("password", "123456");
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(map, headers);
        ResponseEntity<String> result = restTemplate.exchange(loginUrl, HttpMethod.POST, httpEntity, String.class);
        HttpHeaders headers1 = result.getHeaders();
        log.info("返回结果:{}", result.getBody());
    }

    @Test
    public  void test12() {
        LocalDate now = LocalDate.now();
        System.out.println(LocalDate.of(now.getYear(), now.getMonthValue() + 1, 1).minusDays(1).getDayOfMonth());
    }

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
            //key转换
            Key key = new SecretKeySpec(bytes, "AES");
            //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(str.getBytes());
            String string = Base64Utils.encodeToString(result);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public  void test13() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.stream().limit(5).collect(Collectors.toList()));
        System.out.println(new Date(1657545351582L));
        System.out.println(jdkAESEncode("hahaha"));
        System.out.println(new Date());
    }

    @Test
    public void  test14() {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
//            System.out.println(new String(decoder.decodeBuffer("cmVjX2lkIDwgMCBhbmQgZXZlbnRfdHlwZV9pZCA8IDMgYW5kIGRpc3RyaWN0X2lkIGluICgnMTInLCcyNCcsJzI1JywnMjYnLCcyNycsJzI4JywnMjknLCczMCcsJzMxJywnMzInLCczMycsJzM0JywnMzUnLCczNicsJzM3JywnMzgnLCc0Micp"), "UTF-8"));
            // 主城
            System.out.println(new String(decoder.decodeBuffer("c3ViX3R5cGVfaWQgPiAwIGFuZCBib3VuY2VfcmVjX251bSA9IDE="), "UTF-8"));
            // 渝东南
            System.out.println(new String(decoder.decodeBuffer("cmVjX2lkIDwgMCBhbmQgZXZlbnRfdHlwZV9pZCA8IDMgYW5kIGRpc3RyaWN0X2lkIGluICgnMTInLCcyNCcsJzI1JywnMjYnLCcyNycsJzI4JywnMjknLCczMCcsJzMxJywnMzInLCczMycsJzM0JywnMzUnLCczNicsJzM3JywnMzgnLCc0Micp"), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  test15() {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        System.out.printf(base64Encoder.encodeBuffer("-1,500104001010008,500104001010007,500104001010006,500104001010003,500104001011011,500104001011010,500104001005007,500104001010010,500104001011009,500104001011008".getBytes()));
    }

    @Test
    public void  test16() {
        Class<? extends HejiaDemo1> aClass = getClass();
        try {
            Field declaredField = aClass.getDeclaredField("1");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDate.now().compareTo(LocalDate.now().minusDays(1)));
    }

    @Test
    public void  test17() {
        LocalDate localDate = LocalDate.parse("2022-10-09");
        System.out.println(LocalDate.parse("2022-10-09"));
    }

    @Test
    public void  test18() {
        String a = "鴐";
        System.out.println(a.charAt(1));
    }

}
