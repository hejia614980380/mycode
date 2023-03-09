package com.hejia.demo;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hj
 * @Date: 2021/3/2 14:17
 */
public class HejiaDemo3 {
    private CloseableHttpClient httpClient;

    @Before
    public void before() {
        httpClient = HttpClientBuilder.create().build();
    }

    @Test
    public void test1() {
        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:8038/free/emergency/emergency-unit/gain");
        // (需要导入com.alibaba.fastjson.JSON包)
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "测试组");
        map.put("parentId", "1");
        map.put("duty", "测试");
        map.put("headId", "1");
        map.put("headName", "张三");
        map.put("headPhone", "13111111111");
        map.put("headDuty", "测");
        map.put("headShortPhone", "1");
        list.add(map);
        String jsonString = JSON.toJSONString(list);

        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
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
    public void test2() {
        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:8038/free/emergency/emergency-team/gain");
        // (需要导入com.alibaba.fastjson.JSON包)
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("unitId", "1");
        map.put("address", "长沙");
        map.put("name", "测试队");
        map.put("latitude", 21.78);
        map.put("longitude", 31.26);
        map.put("humanNumber", 1);
        map.put("duty", "测试");
        list.add(map);
        String jsonString = JSON.toJSONString(list);

        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
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
    public void test3() {
        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:8038/free/emergency/emergency-human/gain");
        // (需要导入com.alibaba.fastjson.JSON包)
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "李四");
        map.put("teamId", "1");
        map.put("duty", "测试");
        map.put("shortPhone", 111);
        map.put("phone", "13122222222");
        map.put("picture", "1");
        list.add(map);
        String jsonString = JSON.toJSONString(list);

        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
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
    public void test4() {
        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:8038/free/emergency/emergency-vehicle/gain");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("simNo", "1");
        map.put("plateNo", "2");
        map.put("plateType", "蓝牌");
        map.put("departmentId", "111");
        map.put("color", "黑色");
        map.put("brand", "大众");
        map.put("type", "1");
        map.put("pic1", "1");
        map.put("pic2", "2");
        map.put("pic3", "3");
        map.put("supervisor", "张三");
        map.put("supervisorPhone", "13111111111");
        list.add(map);
        String jsonString = JSON.toJSONString(list);

        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
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
    public void test5() {
        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:8038/free/emergency/emergency-disaster/gain");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "台风");
        map.put("description", "台风");
        map.put("eventTypeId", "2");
        map.put("eventTypeName", "风暴");
        map.put("subTypeId", "3");
        map.put("subTypeName", "风暴");
        map.put("estimatedOccurDate", 1614843299000L);
        map.put("actualOccurDate", null);
        map.put("endDate", 1614843315000L);
        map.put("gradeId", "1");
        map.put("grade", "1");
        map.put("planId", "4");
        list.add(map);
        String jsonString = JSON.toJSONString(list);

        StringEntity entity = new StringEntity("[{\"subTypeName\":\"防台防汛\",\"gradeId\":4,\"estimatedOccurDate\":1614848000000,\"endDate\":null,\"actualOccurDate\":1614848005000,\"description\":\"超强台风\",\"subTypeId\":5,\"eventTypeId\":1,\"grade\":\"Ⅳ级\",\"name\":\"台风002\",\"eventTypeName\":\"自然灾害\",\"planId\":4,\"id\":18}] ", "UTF-8");

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
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
        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:8038/free/emergency/emergency-disaster-dispose/gain");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("disposeID", "5");
        map.put("disasterID", "1");
        map.put("regionID", "1");
        map.put("regionName", "越秀区");
        map.put("unitID", "3");
        map.put("unitName", "执法局");
        map.put("humanID", "2");
        map.put("humanName", "张三");
        map.put("createTime", 1614843439000L);
        map.put("inspectionNum", 3);
        map.put("inspectionHumanNum", 10);
        map.put("hidenDangerNum", 3);
        map.put("fixDangerNum", 10);
        map.put("processingDangerNum", 4);
        map.put("lowLyingNum", 5);
        map.put("underpassSectionNum", 6);
        map.put("pumpingStationNum", 8);
        map.put("cityRoadNum", 10);
        map.put("bridgeNum", 9);
        map.put("culvertNum", 15);
        map.put("streetLampNum", 10);
        map.put("waterSupplyNum", 22);
        map.put("gasSupplyNum", 12);
        map.put("humanTransferNum", 100);
        map.put("garbagePickerNum", 21);
        map.put("billboardNum", 12);
        map.put("shopRecruitmentNum", 78);
        map.put("publicToiletNum", 12);
        map.put("transferStationNum", 23);
        map.put("disposalSiteNum", 25);
        map.put("cleanGarbageNum", 21.64);
        map.put("parkNum", 25);
        map.put("borderTreeNum", 25);
        map.put("treeReinforceNum", 21);
        map.put("treeLodgingNum", 25);
        map.put("geologicDisasterNum", 5);
        map.put("parkHumanTransferNum", 18);
        list.add(map);
        String jsonString = JSON.toJSONString(list);

        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
             HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
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
        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:8038/free/emergency/emergency-disaster-damage/gain");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("damageID", "2");
        map.put("disasterID", "1");
        map.put("regionID", "1");
        map.put("regionName", "越秀区");
        map.put("unitID", "3");
        map.put("unitName", "执法局");
        map.put("humanID", "2");
        map.put("humanName", "张三");
        map.put("createTime", 1614839123000L);
        map.put("roadTotalLoss", 3.2);
        map.put("roadDamageNum", 10);
        map.put("roadDamageArea", 3.8);
        map.put("roadRepairNum", 10);
        map.put("gasTotalLoss", 4.3);
        map.put("pipelineDamageNum", 5);
        map.put("pipelineRepairNum", 6);
        map.put("bridgeTotalLoss", 8.6);
        map.put("bridgeDamageArea", 10.3);
        map.put("bridgeRepairNum", 9);
        map.put("lightingTotalLoss", 15.3);
        map.put("lightingDamageNum", 10);
        map.put("lightingRepairNum", 22);
        map.put("waterTotalLoss", 12.1);
        map.put("waterPipelineDamageLength", 100.2);
        map.put("pumpingStationDamageNum", 21);
        map.put("pumpingStationRepairNum", 12);
        map.put("waterLoggedTotalLoss", 78.2);
        map.put("pondingPointNum", 12);
        map.put("waterLoggedArea", 23.1);
        map.put("maxWaterDepth", 25.1);
        map.put("waterLoggedRepairNum", 21);
        map.put("outdoorTotalLoss", 25.2);
        map.put("largeAdvertisingNum", 25);
        map.put("shopRecruitmentNum", 21);
        map.put("outdoorRepairNum", 25);
        map.put("environmentTotalLoss", 5.1);
        map.put("environmentDamageNum", 18);
        map.put("garbageCleanNum", 18.2);
        map.put("environmentRepairNum", 35);
        map.put("landscapingTotalLoss", 26.8);
        map.put("floodedGrasslandArea", 25.3);
        map.put("affectedTreesNum", 6);
        map.put("landslideNum", 8);
        map.put("landscapingRepairNum", 21);
        map.put("humanNum", 28);
        map.put("vehicleNum", 5);
        map.put("totalLoss", 100.2);
        list.add(map);
        String jsonString = JSON.toJSONString(list);

        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
