package com.hejia.demo;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class HejiaDemo1 {
    private CloseableHttpClient client = HttpClientBuilder.create().build();

    @Test
    public void test1() {
        LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfWeek().getValue());
    }

    @Test
    public void test2() {
        ArrayList<Student> list = new ArrayList<>();
        String str = JSON.toJSONString(list);
        System.out.println(JSON.parseArray(str, Student.class));
    }

    @Test
    public void test3() {
        double d1 = 1.13145;
        double d2 = 1.1314;
        System.out.println(Double.compare(d1, d2));
    }

    @Test
    public void test4() {
        System.out.println("   ".split(",").length);
    }

    @Test
    public void test5() {
        HttpPost httpPost = new HttpPost("http://localhost:8055/free/activate-management/project");
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("cityCode", "532900");
        resultMap.put("countyCode", "532901");
        resultMap.put("indicatorTypeId", "11");
        resultMap.put("projectId", "532901202001");
        resultMap.put("projectName", "??????????????????????????????");
        resultMap.put("approvalCode", "????????????-13???");
        resultMap.put("approvalOrgan", "?????????");
        resultMap.put("approvalDate", "2020-12-15");
        resultMap.put("agriculturalLand", "3.2357");
        resultMap.put("cultivatedLand", "3.3357");
        resultMap.put("unutilizedLand", "3.4357");
        resultMap.put("secondPaddyField", "3.5357");
        resultMap.put("threePaddyField", "3.6357");
        resultMap.put("fourPaddyField", "3.7357");
        resultMap.put("fivePaddyField", "3.8357");
        resultMap.put("sixPaddyField", "3.9357");
        resultMap.put("sevenPaddyField", "3.0357");
        resultMap.put("eightPaddyField", "3.1357");
        resultMap.put("ninePaddyField", "3.2357");
        resultMap.put("tenPaddyField", "3.3357");
        resultMap.put("elevenPaddyField", "3.4357");
        resultMap.put("twelvePaddyField", "3.5357");
        resultMap.put("thirteenPaddyField", "3.6357");
        resultMap.put("secondDryLand", "3.7357");
        resultMap.put("threeDryLand", "3.8357");
        resultMap.put("fourDryLand", "3.9357");
        resultMap.put("fiveDryLand", "3.0357");
        resultMap.put("sixDryLand", "3.1357");
        resultMap.put("sevenDryLand", "3.2357");
        resultMap.put("eightDryLand", "3.3357");
        resultMap.put("nineDryLand", "3.4357");
        resultMap.put("tenDryLand", "3.5357");
        resultMap.put("elevenDryLand", "3.6357");
        resultMap.put("twelveDryLand", "3.7357");
        resultMap.put("thirteenDryLand", "8.1357");
        String jsonStr = JSON.toJSONString(resultMap);
        StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setHeader("token", "1");
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ??????????????????(??????)Post??????
            response = client.execute(httpPost);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();

            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test6() {
        HttpPost httpPost = new HttpPost("http://localhost:8055/free/activate-use/expected");
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("cityCode", "530100");
        resultMap.put("countyCode", "530101");
        resultMap.put("projectId", "53010104");
        resultMap.put("projectName", "?????????????????????????????????");
        resultMap.put("agriculturalLand", "1.2134");
        resultMap.put("cultivatedLand", "1.3134");
        resultMap.put("unutilizedLand", "1.4134");
        resultMap.put("secondPaddyField", "1.5134");
        resultMap.put("threePaddyField", "1.6134");
        resultMap.put("fourPaddyField", "1.7134");
        resultMap.put("fivePaddyField", "1.8134");
        resultMap.put("sixPaddyField", "1.9134");
        resultMap.put("sevenPaddyField", "1.0134");
        resultMap.put("eightPaddyField", "1.1134");
        resultMap.put("ninePaddyField", "1.2134");
        resultMap.put("tenPaddyField", "1.3134");
        resultMap.put("elevenPaddyField", "1.4134");
        resultMap.put("twelvePaddyField", "1.5134");
        resultMap.put("thirteenPaddyField", "1.6134");
        resultMap.put("secondDryLand", "1.7134");
        resultMap.put("threeDryLand", "1.8134");
        resultMap.put("fourDryLand", "1.9134");
        resultMap.put("fiveDryLand", "1.0134");
        resultMap.put("sixDryLand", "1.1134");
        resultMap.put("sevenDryLand", "1.2134");
        resultMap.put("eightDryLand", "1.3134");
        resultMap.put("nineDryLand", "1.4134");
        resultMap.put("tenDryLand", "1.5134");
        resultMap.put("elevenDryLand", "1.6134");
        resultMap.put("twelveDryLand", "1.7134");
        resultMap.put("thirteenDryLand", "1.1357");
        String jsonStr = JSON.toJSONString(resultMap);
        StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setHeader("token", "10086");
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ??????????????????(??????)Post??????
            response = client.execute(httpPost);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();

            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test7() {
        HttpPut httpPut = new HttpPut("http://localhost:8055/free/activate-use/expected");
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("cityCode", "530100");
        resultMap.put("countyCode", "530101");
        resultMap.put("projectId", "53010101");
        resultMap.put("projectName", "??????????????????????????????????????????");
        resultMap.put("agriculturalLand", "1.3796");
        resultMap.put("cultivatedLand", "0.3357");
        resultMap.put("unutilizedLand", "1.4357");
        resultMap.put("secondPaddyField", "0.5357");
        resultMap.put("threePaddyField", "0.6357");
        resultMap.put("fourPaddyField", "0.7357");
        resultMap.put("fivePaddyField", "0.8357");
        resultMap.put("sixPaddyField", "0.3357");
        resultMap.put("sevenPaddyField", "0.0357");
        resultMap.put("eightPaddyField", "0.3357");
        resultMap.put("ninePaddyField", "0.2357");
        resultMap.put("tenPaddyField", "0.3357");
        resultMap.put("elevenPaddyField", "0.4357");
        resultMap.put("twelvePaddyField", "0.5357");
        resultMap.put("thirteenPaddyField", "0.6357");
        resultMap.put("secondDryLand", "0.7357");
        resultMap.put("threeDryLand", "0.8357");
        resultMap.put("fourDryLand", "0.9357");
        resultMap.put("fiveDryLand", "0.0357");
        resultMap.put("sixDryLand", "0.1357");
        resultMap.put("sevenDryLand", "0.2357");
        resultMap.put("eightDryLand", "0.4689");
        resultMap.put("nineDryLand", "0.4357");
        resultMap.put("tenDryLand", "0.6357");
        resultMap.put("elevenDryLand", "0.6357");
        resultMap.put("twelveDryLand", "0.7357");
        resultMap.put("thirteenDryLand", "0.1357");
        String jsonStr = JSON.toJSONString(resultMap);
        StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
        httpPut.setEntity(stringEntity);
        httpPut.setHeader("Content-Type", "application/json;charset=utf8");
        httpPut.setHeader("token", "10086");
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ??????????????????(??????)Post??????
            response = client.execute(httpPut);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();

            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test8() {
        HttpPost httpPost = new HttpPost("http://localhost:8055/free/activate-use/combine");
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("childIds", "53010101,53010102");
        resultMap.put("cityCode", "530100");
        resultMap.put("countyCode", "530101");
        resultMap.put("projectId", "53010103");
        resultMap.put("projectName", "???????????????????????????????????????");
//        resultMap.put("approvalCode", "ppp");
//        resultMap.put("approvalOrgan", "?????????");
//        resultMap.put("approvalDate", "2020-9-22");
        String jsonStr = JSON.toJSONString(resultMap);
        StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setHeader("token", "1");
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ??????????????????(??????)Post??????
            response = client.execute(httpPost);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();

            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test9() {
        HttpDelete httpDelete = new HttpDelete("http://localhost:8055/free/activate-use/project/53010104");
        httpDelete.setHeader("token", "1");
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ????????????
            RequestConfig requestConfig = RequestConfig.custom()
                    // ????????????????????????(????????????)
                    .setConnectTimeout(5000)
                    // ????????????????????????(????????????)
                    .setConnectionRequestTimeout(5000)
                    // socket??????????????????(????????????)
                    .setSocketTimeout(5000)
                    // ???????????????????????????(?????????true)
                    .setRedirectsEnabled(true).build();

            // ???????????????????????? ???????????????Get?????????
            httpDelete.setConfig(requestConfig);

            // ??????????????????(??????)Get??????
            response = client.execute(httpDelete);

            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();
            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test10() {
        LocalDate oneWeek = LocalDate.now().minusWeeks(1);
        int oneWeekValue = oneWeek.getDayOfWeek().getValue();
        Timestamp oneWeekStart = Timestamp.from(oneWeek.minusDays(oneWeekValue - 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Timestamp oneWeekEnd = Timestamp.from(oneWeek.plusDays(oneWeekValue + 1).atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        LocalDate twoWeek = LocalDate.now().minusWeeks(2);
        int twoWeekValue = oneWeek.getDayOfWeek().getValue();
        Timestamp twoWeekStart = Timestamp.from(twoWeek.minusDays(oneWeekValue - 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Timestamp twoWeekEnd = Timestamp.from(twoWeek.plusDays(oneWeekValue + 1).atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(oneWeekStart);
        System.out.println(oneWeekEnd);
        System.out.println(twoWeekStart);
        System.out.println(twoWeekEnd);
    }

    @Test
    public void test11() {
        HttpPut httpPut = new HttpPut("http://localhost:8055/free/activate-use/combine");
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("childIds", "53010101,53010102,53010104");
        resultMap.put("cityCode", "530100");
        resultMap.put("countyCode", "530101");
        resultMap.put("projectId", "53010103");
        resultMap.put("projectName", "???????????????????????????????????????");
//        resultMap.put("scale", "3.1587");
//        resultMap.put("approvalCode", "ppp");
//        resultMap.put("approvalOrgan", "?????????");
//        resultMap.put("approvalDate", "2020-9-22");
        String jsonStr = JSON.toJSONString(resultMap);
        StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
        httpPut.setEntity(stringEntity);
        httpPut.setHeader("Content-Type", "application/json;charset=utf8");
        httpPut.setHeader("token", "10086");
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ??????????????????(??????)Post??????
            response = client.execute(httpPut);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();

            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test12() {
        HttpPost httpPost = new HttpPost("http://localhost:8055/free/activate-use/actual");
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("projectId", "53010103");
        resultMap.put("approvalCode", "ppp");
        resultMap.put("approvalOrgan", "?????????");
        resultMap.put("approvalDate", "2020-12-22");
        String jsonStr = JSON.toJSONString(resultMap);
        StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setHeader("token", "1");
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ??????????????????(??????)Post??????
            response = client.execute(httpPost);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();

            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test13() {
        HttpDelete httpDelete = new HttpDelete("http://localhost:8055/free/activate-management/project/532901202001");
        httpDelete.setHeader("token", "1");
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ????????????
            RequestConfig requestConfig = RequestConfig.custom()
                    // ????????????????????????(????????????)
                    .setConnectTimeout(5000)
                    // ????????????????????????(????????????)
                    .setConnectionRequestTimeout(5000)
                    // socket??????????????????(????????????)
                    .setSocketTimeout(5000)
                    // ???????????????????????????(?????????true)
                    .setRedirectsEnabled(true).build();

            // ???????????????????????? ???????????????Get?????????
            httpDelete.setConfig(requestConfig);

            // ??????????????????(??????)Get??????
            response = client.execute(httpDelete);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();
            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test14() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\test\\test.txt"));
        System.out.println(br.lines().collect(Collectors.joining(",")));
//        System.out.println(br.lines().map(s -> "\"" + s + "\"").collect(Collectors.joining(",")));

        // 2931,2932,2938,2941,2942,2943,3029,2987,2962,2963,2988,2989,2990,2991,2992,3014,3015,3016,3017,3019,3020,3021,3022,3023,3024,3026,3027,3030,3031,38,118,119,120,121,122,123,124,125,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,159,160,162,163,165,168,169,170,171,172,173,174,198,199,210,211,212,213,217,218,219,220,221,222,223,224,227,230,231,232,233,234,235,236,237,240,241,242,244,245,246,247,248,249,250,251,252,253,2915,2917,2919,2920,2944,2945,2946,2947,2948,2986,2954,2994,2995,2967,2968,3112,3116,2973,2977,2981,2982,2984,2996,2997,2998,2999,3000,3001,3002,3004,3005,3006,3007,3008,3009,3010,3011,3012,3013,3018,3094,3067,3088,3089,3090,3110,3111,3106,3115,3144,3138,3139,3136,3140,3053,3142,238,3003,3025,3028,2980,2921,3145,3147

    }

    @Test
    public void test15() {
        int num = 5186;
        StringBuilder sb = new StringBuilder(",");
        List<Integer> codes = Arrays.asList(229,2916,2918,2925,2926,2927,2928,2929,2966,2930,2939,2969,2970,2971,3113,2972,2974,2975,2976,2978,2979,2983,2985,3114,3087,3085,3108,3084,2933,2934,2935,2936,2937,2940,2959,2964,2965,37,39,40,41,158,200,201,202,203,204,3143,3137,36,3086,3146);
        List<String> names = Arrays.asList("??????????????????","????????????????????????","*?????????????????????","???????????????????????????????????????","???????????????","*??????????????????","??????????????????","*???????????????????????????","????????????","*?????????????????????????????????","????????????","???????????????????????????","???????????????????????????","????????????????????????","??????????????????","*?????????????????????","??????????????????","???????????????","????????????","??????????????????","?????????????????????","??????????????????????????????","????????????????????????","??????????????????","??????????????????","?????????????????????","??????????????????","????????????","????????????","???????????????","?????????????????????","??????????????????","??????????????????","??????????????????","?????????????????????","????????????","????????????","????????????","????????????","??????????????????","????????????","??????????????????","????????????","???????????????","?????????","??????????????????","?????????","*???????????????","????????????","???(???)?????????","?????????????????????","????????????????????????");
        for (int i = 0; i < codes.size(); i++) {
            Integer code = codes.get(i);
            String name = names.get(i);
            sb.append("(");
            sb.append("'").append(++num).append("', ");
            sb.append("'").append(code).append("', ");
            sb.append("'").append(name).append("', ");
            sb.append(3).append(", ");
            sb.append("'").append(54).append("', ");
            sb.append("'").append(name).append("', ");
            sb.append(0).append(", ");;
            sb.append("null").append(", ");;
            sb.append("null").append(", ");;
            sb.append("null").append(", ");;
            sb.append("null");;
            sb.append("),");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test16() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1611690770000L)));
    }

    @Test
    public void test17() throws Exception {
        FileInputStream fis = new FileInputStream("D:\\test\\test.txt");
        FileChannel inChannel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        inChannel.read(byteBuffer);
        byteBuffer.flip();
        FileOutputStream fos = new FileOutputStream("D:\\test\\text.txt");
        FileChannel outChannel = fos.getChannel();
        outChannel.write(byteBuffer);
        fis.close();
        fos.close();
    }

    @Test
    public void test18() throws Exception {
        System.out.println(Selector.open());
        System.out.println(Selector.open());
        System.out.println(Selector.open());
    }

    @Test
    public void test19() {
        String str = "[{\"action\":\"Redirect\",\"processInstanceId\":\"d44c59b8-8142-11eb-91a3-ea8d59ba047b\",\"processDefinitionId\":\"CKXL:26:f423f2cc-5280-11eb-bcf2-f27b622aea6f\",\"node\":{\"id\":\"Activity_09des1y\",\"name\":\"??????????????????\",\"type\":\"Manual\",\"describe\":\"\",\"parentId\":\"z1602326245345\",\"timing\":{\"timeout\":{\"timingLimit\":\"PT48H\",\"timingMode\":\"WorkDay\"},\"warning\":{\"timingLimit\":\"PT24H\",\"timingMode\":\"WorkDay\"}},\"reference\":\"\",\"participantFilter\":\"County\",\"actions\":[{\"name\":\"??????\",\"alias\":\"??????\",\"type\":\"Redirect\",\"enable\":true,\"condition\":{\"field\":\"\",\"fieldType\":\"\",\"pageId\":\"\",\"version\":\"\",\"tableId\":\"\",\"text\":null,\"aggregationType\":null,\"operate\":null,\"value\":\"\",\"type\":\"Single\",\"expression\":null,\"grooryBinding\":[{\"fieldId\":\"\",\"pageId\":\"\",\"tableId\":\"\",\"version\":\"\",\"documentNo\":null}]}},{\"name\":\"??????\",\"alias\":\"??????\",\"type\":\"Return\",\"enable\":true,\"condition\":{\"field\":\"\",\"fieldType\":\"\",\"pageId\":\"\",\"version\":\"\",\"tableId\":\"\",\"text\":null,\"aggregationType\":null,\"operate\":null,\"value\":\"\",\"type\":\"Single\",\"expression\":null,\"grooryBinding\":[{\"fieldId\":\"\",\"pageId\":\"\",\"tableId\":\"\",\"version\":\"\",\"documentNo\":null}]}}],\"auditors\":[{\"type\":\"Duty\",\"dynamicType\":null,\"value\":\"00113\",\"text\":\"?????????????????????\",\"selected\":null}],\"completes\":[],\"timeouts\":[],\"commits\":[],\"precondition\":null,\"executions\":[],\"forms\":[{\"enable\":false,\"priority\":false,\"condition\":null,\"type\":\"Online\",\"value\":\"44c8eca0-7ceb-488b-9f63-a48b703788f7\",\"version\":\"20201111140203\",\"name\":\"???????????????-???????????????\"},{\"enable\":false,\"priority\":true,\"condition\":null,\"type\":\"Online\",\"value\":\"a3bb8a69-2a0d-4464-8c03-5328e4ec2588\",\"version\":\"20201223100616\",\"name\":\"?????????????????????????????????\"},{\"enable\":false,\"priority\":false,\"condition\":null,\"type\":\"Online\",\"value\":\"9d8500ca-aff6-43ec-b486-4064cfaae3e1\",\"version\":\"20201225103834\",\"name\":\"???????????????\"}],\"instance\":{\"assignType\":\"Choice\",\"type\":\"Single\"},\"notices\":[],\"datums\":[{\"categoryId\":\"220\",\"id\":\"e0248137-7363-40e4-b99b-43cc991a2ede\",\"name\":\"????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"397f5f53-9cfe-4c2b-bb6f-768bd9df6438\",\"name\":\"??????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"0c3af3b6-e82b-4b9b-a176-a0f866e4de61\",\"name\":\"???????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"1b263aea-1459-4569-92fb-3e7bfbde9d1c\",\"name\":\"??????????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"a3c1f6b3-cff9-4b8b-b918-49da56945fa9\",\"name\":\"??????????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"06df7376-1e39-4076-aa4e-1a722f06bb29\",\"name\":\"??????????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"dd8b6082-2a1c-45ce-86e8-a03cca0f97f0\",\"name\":\"?????????????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"3ba90aa2-fe86-453f-af47-265c138ad08f\",\"name\":\"????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"061ec553-0cc9-451c-9a03-db7e3932101a\",\"name\":\"?????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"73444733-5044-4aab-99f1-12203a03a206\",\"name\":\"??????????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"19c2059d-e1a7-47bb-8abd-f9c35febe651\",\"name\":\"??????????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"20a2aef8-4ef2-4ca1-9929-f2d68088ef94\",\"name\":\"????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"64a288aa-9ed2-45e8-beae-6237b95144c9\",\"name\":\"???????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"144b5e57-c372-4208-ab20-2c85354795e6\",\"name\":\"???????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"26310926-ddeb-4f2a-85b6-88a2d61ed290\",\"name\":\"?????????????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"e2934936-ba07-4cc7-a137-ef1ef56df649\",\"name\":\"??????????????????????????????\",\"enable\":false,\"condition\":null,\"valid\":true},{\"categoryId\":\"220\",\"id\":\"90ce0618-5537-4c16-8646-ea3aed47bd97\",\"name\":\"????????????\",\"enable\":false,\"condition\":null,\"valid\":true}],\"listeners\":[]},\"assignees\":[{\"type\":\"User\",\"data\":[{\"id\":\"MLS0001\",\"code\":\"MLS0001\",\"deviceNo\":null,\"name\":\"?????????\",\"sex\":\"Woman\",\"departmentId\":\"9018e0f2-b97a-466f-bfc5-24a31757520e\",\"positionType\":null,\"parentId\":null,\"birthday\":null,\"photo\":null,\"phone\":null,\"phonetic\":\"liyuanyuan lyy\",\"introduce\":null,\"creator\":\"admin\",\"modifier\":\"admin\",\"createTime\":\"2020-12-10 16:42:28\",\"modifyTime\":\"2020-12-25 17:35:12\",\"disabled\":false,\"longitude\":null,\"latitude\":null,\"identityNo\":null,\"status\":\"Work\",\"activeTime\":null,\"sign\":\"http://www.egova.top:30047/gateway/admin-server/files/images/base/2020122542271.png\",\"sort\":560,\"deputyPositions\":null,\"position\":\"?????????????????????,?????????????????????,??????????????????,??????????????????\",\"sexName\":\"??????\",\"departmentName\":\"?????????\",\"_positionType\":{\"text\":null,\"value\":null},\"parentName\":null,\"statusName\":\"??????\"}]}],\"choiceMode\":\"Single\"}]";
        System.out.println(JSON.parseArray(str).getJSONObject(0).getJSONObject("node").getJSONObject("instance").getString("assignType"));
    }

    @Test
    public void test20() {
        HttpPost httpPost = new HttpPost("http://localhost:8055/free/activate-use/actual");
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("projectId", "53010103");
        resultMap.put("approvalCode", "ppp");
        resultMap.put("approvalOrgan", "?????????");
        resultMap.put("approvalDate", "2020-12-22");
        String jsonStr = JSON.toJSONString(resultMap);
        StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setHeader("token", "1");
        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ??????????????????(??????)Post??????
            response = client.execute(httpPost);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();

            System.out.println("???????????????:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("?????????????????????:" + responseEntity.getContentLength());
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (client != null) {
                    client.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test21() {
        List<Integer> integers = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> integers1 = Arrays.asList(2, 4, 6, 8, 10);
        integers.forEach(i -> {
            integers1.forEach(j -> {
                if (j == 6) {
                    return;
                }
                System.out.println(j);
            });
            System.out.println(i);
        });
    }

    @Test
    public void test22() {
        String text = "??????java";
        System.out.println(text.getBytes(Charset.forName("gbk")).length);
        System.out.println(text.length());
    }

    @Test
    public void test23() throws Exception {
        String text = "??????????????????????????????";
        Base64.getEncoder().wrap(new FileOutputStream("D:\\test\\test.txt")).write(text.getBytes(StandardCharsets.UTF_8));
        InputStream inputStream = Base64.getDecoder().wrap(new FileInputStream("D:\\test\\test.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }
    }

    @Test
    public void test24() {
        Set<Student> set = new TreeSet<>();
        set.add(new Student(1));
        set.add(new Student(5));
        set.add(new Student(3));
        set.add(new Student(9));
        System.out.println(set);
    }

    @Test
    public void test25() {
        System.out.println(LocalDate.now().atTime(LocalTime.MAX));
    }

    @Test
    public void test26() {
        System.out.println("feature-20210309-test");
    }

    @Test
    public void test27() {
        System.out.println("release-1.0");
    }

    @Test
    public void test30() {
        System.out.println("hotfix-1.1-test");
    }
}


