package com.hejia.demo;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: hj
 * @Date: 2021/9/8 15:48
 */
public class DdcatDemo {

    /**
     * SELECT 'teamHeader' AS 'key',1 AS 'value'
     * UNION ALL (SELECT 'unit' AS 'key',8 AS 'value')
     * UNION ALL (SELECT 'streetHead' AS 'key',(SELECT COUNT(*) FROM sani_principal_human WHERE human_type = '街道负责人') AS 'value')
     * UNION ALL (SELECT 'centerHead' AS 'key',(SELECT COUNT(*) FROM sani_principal_human WHERE human_type = '环卫中心负责人') AS 'value')
     * UNION ALL (SELECT 'postHead' AS 'key',(SELECT COUNT(*) FROM sani_principal_human WHERE human_type = '驿站负责人') AS 'value')
     * UNION ALL (SELECT 'buildingHead' AS 'key',(SELECT COUNT(*) FROM sani_principal_human WHERE human_type = '垃圾楼负责人') AS 'value')
     * UNION ALL (SELECT 'watchstander' AS 'key',(SELECT COUNT(*) FROM sani_principal_human WHERE human_type = '桶站负责人') AS 'value')
     * UNION ALL (SELECT 'propertyHead' AS 'key',(SELECT COUNT(*) FROM sani_principal_human WHERE human_type = '物业负责人') AS 'value')
     */
    @Test
    public void test1() {
        List<Map<String, Object>> data = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> teamHeaderMap = new HashMap<>();
        teamHeaderMap.put("key", "teamHeader");
        teamHeaderMap.put("value", 1);
        Map<String, Object> unitMap = new HashMap<>();
        unitMap.put("key", "unit");
        unitMap.put("value", 2);
        Map<String, Object> streetHeadMap = new HashMap<>();
        streetHeadMap.put("key", "streetHead");
        streetHeadMap.put("value", 3);
        Map<String, Object> centerHeadMap = new HashMap<>();
        centerHeadMap.put("key", "centerHead");
        centerHeadMap.put("value", 4);
        Map<String, Object> postHeadMap = new HashMap<>();
        postHeadMap.put("key", "postHead");
        postHeadMap.put("value", 5);
        Map<String, Object> buildingHeadMap = new HashMap<>();
        buildingHeadMap.put("key", "buildingHead");
        buildingHeadMap.put("value", 6);
        Map<String, Object> watchstanderMap = new HashMap<>();
        watchstanderMap.put("key", "watchstander");
        watchstanderMap.put("value", 7);
        Map<String, Object> propertyHeadMap = new HashMap<>();
        propertyHeadMap.put("key", "propertyHead");
        propertyHeadMap.put("value", 8);
//        data.add(teamHeaderMap);
//        data.add(unitMap);
        data.add(streetHeadMap);
        data.add(centerHeadMap);
        data.add(postHeadMap);
        data.add(buildingHeadMap);
        data.add(watchstanderMap);
        data.add(propertyHeadMap);
        Map<String, Object> district = new HashMap<>();
        district.put("name", "区级");
        district.put("text", "区级");
        boolean flag = false;
        for (Map<String, Object> datum : data) {
            String key = String.valueOf(datum.get("key"));
            if (key.equals("teamHeader") || key.equals("unit")) {
                flag = true;
                break;
            }
        }
        if (flag) {
            List<Map<String, Object>> innerList = new ArrayList<>();
            for (Map<String, Object> datum : data) {
                String key = String.valueOf(datum.get("key"));
                if (key.equals("teamHeader")) {
                    Map<String, Object> innerMap = new HashMap<>();
                    innerMap.put("name", "组长");
                    innerMap.put("text", "组长");
                    int value = (int) datum.get("value");
                    innerMap.put("value", value);
                    innerList.add(innerMap);
                }
                if (key.equals("unit")) {
                    Map<String, Object> innerMap = new HashMap<>();
                    innerMap.put("name", "科室");
                    innerMap.put("text", "科室");
                    int value = (int) datum.get("value");
                    innerMap.put("value", value);
                    innerList.add(innerMap);
                }
            }
            district.put("value", innerList);
            list.add(district);
        }
        Map<String, Object> street = new HashMap<>();
        street.put("name", "街道");
        street.put("text", "街道");
        List<Map<String, Object>> streetList = new ArrayList<>();
        for (Map<String, Object> datum : data) {
            String key = String.valueOf(datum.get("key"));
            if (key.equals("streetHead")) {
                Map<String, Object> innerMap = new HashMap<>();
                innerMap.put("name", "街道负责人");
                innerMap.put("text", "街道负责人");
                int value = (int) datum.get("value");
                innerMap.put("value", value);
                streetList.add(innerMap);
            }
        }
        street.put("value", streetList);
        list.add(street);
        Map<String, Object> community = new HashMap<>();
        community.put("name", "社区");
        community.put("text", "社区");
        List<Map<String, Object>> communityList = new ArrayList<>();
        for (Map<String, Object> datum : data) {
            String key = String.valueOf(datum.get("key"));
            if (key.equals("centerHead")) {
                Map<String, Object> innerMap = new HashMap<>();
                innerMap.put("name", "环卫中心负责人");
                innerMap.put("text", "环卫中心负责人");
                int value = (int) datum.get("value");
                innerMap.put("value", value);
                communityList.add(innerMap);
            }
            if (key.equals("postHead")) {
                Map<String, Object> innerMap = new HashMap<>();
                innerMap.put("name", "驿站负责人");
                innerMap.put("text", "驿站负责人");
                int value = (int) datum.get("value");
                innerMap.put("value", value);
                communityList.add(innerMap);
            }
            if (key.equals("buildingHead")) {
                Map<String, Object> innerMap = new HashMap<>();
                innerMap.put("name", "垃圾楼负责人");
                innerMap.put("text", "垃圾楼负责人");
                int value = (int) datum.get("value");
                innerMap.put("value", value);
                communityList.add(innerMap);
            }
        }
        community.put("value", communityList);
        list.add(community);
        Map<String, Object> xq = new HashMap<>();
        xq.put("name", "小区");
        xq.put("text", "小区");
        List<Map<String, Object>> xqList = new ArrayList<>();
        for (Map<String, Object> datum : data) {
            String key = String.valueOf(datum.get("key"));
            if (key.equals("watchstander")) {
                Map<String, Object> innerMap = new HashMap<>();
                innerMap.put("name", "桶站值守人");
                innerMap.put("text", "桶站值守人");
                int value = (int) datum.get("value");
                innerMap.put("value", value);
                xqList.add(innerMap);
            }
            if (key.equals("propertyHead")) {
                Map<String, Object> innerMap = new HashMap<>();
                innerMap.put("name", "物业负责人");
                innerMap.put("text", "物业负责人");
                int value = (int) datum.get("value");
                innerMap.put("value", value);
                xqList.add(innerMap);
            }
        }
        xq.put("value", xqList);
        list.add(xq);
        System.out.println(list);
    }

    @Test
    public void test2() {
        List<Map<String, Object>> data = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> repeatMap1 = new HashMap<>();
        repeatMap1.put("value", 1);
        repeatMap1.put("date", "2021-08");
        data.add(repeatMap1);
        Map<String, Object> repeatMap2 = new HashMap<>();
        repeatMap2.put("value", 2);
        repeatMap2.put("date", "2021-08");
        data.add(repeatMap2);
        Map<String, Object> repeatMap3 = new HashMap<>();
        repeatMap3.put("value", 3);
        repeatMap3.put("date", "2021-08");
        data.add(repeatMap3);
        Map<String, Object> repeatMap4 = new HashMap<>();
        repeatMap4.put("value", 4);
        repeatMap4.put("date", "2021-08");
        data.add(repeatMap4);
        Map<String, Object> repeatMap5 = new HashMap<>();
        repeatMap5.put("value", 5);
        repeatMap5.put("date", "2021-07");
        data.add(repeatMap5);
        Map<String, Object> repeatMap6 = new HashMap<>();
        repeatMap6.put("value", 6);
        repeatMap6.put("date", "2021-07");
        data.add(repeatMap6);
        Map<String, Object> repeatMap7 = new HashMap<>();
        repeatMap7.put("value", 7);
        repeatMap7.put("date", "2021-07");
        data.add(repeatMap7);
        Map<String, Object> repeatMap8 = new HashMap<>();
        repeatMap8.put("value", 8);
        repeatMap8.put("date", "2021-07");
        data.add(repeatMap8);
        Map<String, Object> repeatMap9 = new HashMap<>();
        repeatMap9.put("value", 9);
        repeatMap9.put("date", "2021-06");
        data.add(repeatMap9);
        Map<String, Object> repeatMap10 = new HashMap<>();
        repeatMap10.put("value", 10);
        repeatMap10.put("date", "2021-06");
        data.add(repeatMap10);
        Map<String, Object> repeatMap11 = new HashMap<>();
        repeatMap11.put("value", 11);
        repeatMap11.put("date", "2021-06");
        data.add(repeatMap11);
        Map<String, Object> repeatMap12 = new HashMap<>();
        repeatMap12.put("value", 12);
        repeatMap12.put("date", "2021-06");
        data.add(repeatMap12);
        Map<String, Object> repeatMap13 = new HashMap<>();
        repeatMap13.put("value", 13);
        repeatMap13.put("date", "2021-05");
        data.add(repeatMap13);
        Map<String, Object> repeatMap14 = new HashMap<>();
        repeatMap14.put("value", 14);
        repeatMap14.put("date", "2021-05");
        data.add(repeatMap14);
        Map<String, Object> repeatMap15 = new HashMap<>();
        repeatMap15.put("value", 15);
        repeatMap15.put("date", "2021-05");
        data.add(repeatMap15);
        Map<String, Object> repeatMap16 = new HashMap<>();
        repeatMap16.put("value", 16);
        repeatMap16.put("date", "2021-05");
        data.add(repeatMap16);
        Map<String, Object> repeatMap17 = new HashMap<>();
        repeatMap17.put("value", 17);
        repeatMap17.put("date", "2021-04");
        data.add(repeatMap17);
        Map<String, Object> repeatMap18 = new HashMap<>();
        repeatMap18.put("value", 18);
        repeatMap18.put("date", "2021-04");
        data.add(repeatMap18);
        Map<String, Object> repeatMap19 = new HashMap<>();
        repeatMap19.put("value", 19);
        repeatMap19.put("date", "2021-04");
        data.add(repeatMap19);
        Map<String, Object> repeatMap20 = new HashMap<>();
        repeatMap20.put("value", 20);
        repeatMap20.put("date", "2021-04");
        data.add(repeatMap20);
        Map<String, Object> repeatMap21 = new HashMap<>();
        repeatMap21.put("value", 21);
        repeatMap21.put("date", "2021-03");
        data.add(repeatMap21);
        Map<String, Object> repeatMap22 = new HashMap<>();
        repeatMap22.put("value", 22);
        repeatMap22.put("date", "2021-03");
        data.add(repeatMap22);
        Map<String, Object> repeatMap23 = new HashMap<>();
        repeatMap23.put("value", 23);
        repeatMap23.put("date", "2021-03");
        data.add(repeatMap23);
        Map<String, Object> repeatMap24 = new HashMap<>();
        repeatMap24.put("value", 24);
        repeatMap24.put("date", "2021-03");
        data.add(repeatMap24);

        Map<String, Object> map0 = data.get(0);
        String date1 = String.valueOf(map0.get("date"));
        Map<String, Object> resultMap1 = new HashMap<>();
        resultMap1.put("name", date1);
        resultMap1.put("text", date1);
        List<Map<String, Object>> resultList1 = new ArrayList<>();
        Map<String, Object> innerMap0 = new HashMap<>();
        innerMap0.put("name", "family");
        innerMap0.put("text", "家庭厨余垃圾分出率");
        innerMap0.put("value", Double.parseDouble(String.valueOf(map0.get("value"))));
        resultList1.add(innerMap0);
        Map<String, Object> map1 = data.get(1);
        Map<String, Object> innerMap1 = new HashMap<>();
        innerMap1.put("name", "life");
        innerMap1.put("text", "生活垃圾分出率");
        innerMap1.put("value", Double.parseDouble(String.valueOf(map1.get("value"))));
        resultList1.add(innerMap1);
        Map<String, Object> map2 = data.get(2);
        Map<String, Object> innerMap2 = new HashMap<>();
        innerMap2.put("name", "standard");
        innerMap2.put("text", "分类设施达标率");
        innerMap2.put("value", Double.parseDouble(String.valueOf(map2.get("value"))));
        resultList1.add(innerMap2);
        Map<String, Object> map3 = data.get(3);
        Map<String, Object> innerMap3 = new HashMap<>();
        innerMap3.put("name", "standard");
        innerMap3.put("text", "分类设施达标率");
        innerMap3.put("value", Double.parseDouble(String.valueOf(map3.get("value"))));
        resultList1.add(innerMap3);
        resultMap1.put("value", resultList1);
        list.add(resultMap1);

        Map<String, Object> map4 = data.get(4);
        String date2 = String.valueOf(map4.get("date"));
        Map<String, Object> resultMap2 = new HashMap<>();
        resultMap2.put("name", date2);
        resultMap2.put("text", date2);
        List<Map<String, Object>> resultList2 = new ArrayList<>();
        Map<String, Object> innerMap4 = new HashMap<>();
        innerMap4.put("name", "family");
        innerMap4.put("text", "家庭厨余垃圾分出率");
        innerMap4.put("value", Double.parseDouble(String.valueOf(map4.get("value"))));
        resultList2.add(innerMap4);
        Map<String, Object> map5 = data.get(5);
        Map<String, Object> innerMap5 = new HashMap<>();
        innerMap5.put("name", "life");
        innerMap5.put("text", "生活垃圾分出率");
        innerMap5.put("value", Double.parseDouble(String.valueOf(map5.get("value"))));
        resultList2.add(innerMap5);
        Map<String, Object> map6 = data.get(6);
        Map<String, Object> innerMap6 = new HashMap<>();
        innerMap6.put("name", "standard");
        innerMap6.put("text", "分类设施达标率");
        innerMap6.put("value", Double.parseDouble(String.valueOf(map6.get("value"))));
        resultList2.add(innerMap6);
        Map<String, Object> map7 = data.get(7);
        Map<String, Object> innerMap7 = new HashMap<>();
        innerMap7.put("name", "standard");
        innerMap7.put("text", "分类设施达标率");
        innerMap7.put("value", Double.parseDouble(String.valueOf(map7.get("value"))));
        resultList2.add(innerMap7);
        resultMap2.put("value", resultList2);
        list.add(resultMap2);

        Map<String, Object> map8 = data.get(8);
        String date3 = String.valueOf(map8.get("date"));
        Map<String, Object> resultMap3 = new HashMap<>();
        resultMap3.put("name", date3);
        resultMap3.put("text", date3);
        List<Map<String, Object>> resultList3 = new ArrayList<>();
        Map<String, Object> innerMap8 = new HashMap<>();
        innerMap8.put("name", "family");
        innerMap8.put("text", "家庭厨余垃圾分出率");
        innerMap8.put("value", Double.parseDouble(String.valueOf(map8.get("value"))));
        resultList3.add(innerMap8);
        Map<String, Object> map9 = data.get(9);
        Map<String, Object> innerMap9 = new HashMap<>();
        innerMap9.put("name", "life");
        innerMap9.put("text", "生活垃圾分出率");
        innerMap9.put("value", Double.parseDouble(String.valueOf(map9.get("value"))));
        resultList3.add(innerMap9);
        Map<String, Object> map10 = data.get(10);
        Map<String, Object> innerMap10 = new HashMap<>();
        innerMap10.put("name", "standard");
        innerMap10.put("text", "分类设施达标率");
        innerMap10.put("value", Double.parseDouble(String.valueOf(map10.get("value"))));
        resultList3.add(innerMap10);
        Map<String, Object> map11 = data.get(11);
        Map<String, Object> innerMap11 = new HashMap<>();
        innerMap11.put("name", "standard");
        innerMap11.put("text", "分类设施达标率");
        innerMap11.put("value", Double.parseDouble(String.valueOf(map11.get("value"))));
        resultList3.add(innerMap11);
        resultMap3.put("value", resultList3);
        list.add(resultMap3);

        Map<String, Object> map12 = data.get(12);
        String date4 = String.valueOf(map12.get("date"));
        Map<String, Object> resultMap4 = new HashMap<>();
        resultMap4.put("name", date4);
        resultMap4.put("text", date4);
        List<Map<String, Object>> resultList4 = new ArrayList<>();
        Map<String, Object> innerMap12 = new HashMap<>();
        innerMap12.put("name", "family");
        innerMap12.put("text", "家庭厨余垃圾分出率");
        innerMap12.put("value", Double.parseDouble(String.valueOf(map12.get("value"))));
        resultList4.add(innerMap12);
        Map<String, Object> map13 = data.get(13);
        Map<String, Object> innerMap13 = new HashMap<>();
        innerMap13.put("name", "life");
        innerMap13.put("text", "生活垃圾分出率");
        innerMap13.put("value", Double.parseDouble(String.valueOf(map13.get("value"))));
        resultList4.add(innerMap13);
        Map<String, Object> map14 = data.get(14);
        Map<String, Object> innerMap14 = new HashMap<>();
        innerMap14.put("name", "standard");
        innerMap14.put("text", "分类设施达标率");
        innerMap14.put("value", Double.parseDouble(String.valueOf(map14.get("value"))));
        resultList4.add(innerMap14);
        Map<String, Object> map15 = data.get(15);
        Map<String, Object> innerMap15 = new HashMap<>();
        innerMap15.put("name", "standard");
        innerMap15.put("text", "分类设施达标率");
        innerMap15.put("value", Double.parseDouble(String.valueOf(map15.get("value"))));
        resultList4.add(innerMap15);
        resultMap4.put("value", resultList4);
        list.add(resultMap4);

        Map<String, Object> map16 = data.get(16);
        String date5 = String.valueOf(map16.get("date"));
        Map<String, Object> resultMap5 = new HashMap<>();
        resultMap5.put("name", date5);
        resultMap5.put("text", date5);
        List<Map<String, Object>> resultList5 = new ArrayList<>();
        Map<String, Object> innerMap16 = new HashMap<>();
        innerMap16.put("name", "family");
        innerMap16.put("text", "家庭厨余垃圾分出率");
        innerMap16.put("value", Double.parseDouble(String.valueOf(map16.get("value"))));
        resultList5.add(innerMap16);
        Map<String, Object> map17 = data.get(17);
        Map<String, Object> innerMap17 = new HashMap<>();
        innerMap17.put("name", "life");
        innerMap17.put("text", "生活垃圾分出率");
        innerMap17.put("value", Double.parseDouble(String.valueOf(map17.get("value"))));
        resultList5.add(innerMap17);
        Map<String, Object> map18 = data.get(18);
        Map<String, Object> innerMap18 = new HashMap<>();
        innerMap18.put("name", "standard");
        innerMap18.put("text", "分类设施达标率");
        innerMap18.put("value", Double.parseDouble(String.valueOf(map18.get("value"))));
        resultList5.add(innerMap18);
        Map<String, Object> map19 = data.get(19);
        Map<String, Object> innerMap19 = new HashMap<>();
        innerMap19.put("name", "standard");
        innerMap19.put("text", "分类设施达标率");
        innerMap19.put("value", Double.parseDouble(String.valueOf(map19.get("value"))));
        resultList5.add(innerMap19);
        resultMap5.put("value", resultList5);
        list.add(resultMap5);

        Map<String, Object> map20 = data.get(20);
        String date6 = String.valueOf(map20.get("date"));
        Map<String, Object> resultMap6 = new HashMap<>();
        resultMap6.put("name", date6);
        resultMap6.put("text", date6);
        List<Map<String, Object>> resultList6 = new ArrayList<>();
        Map<String, Object> innerMap20 = new HashMap<>();
        innerMap20.put("name", "family");
        innerMap20.put("text", "家庭厨余垃圾分出率");
        innerMap20.put("value", Double.parseDouble(String.valueOf(map20.get("value"))));
        resultList6.add(innerMap20);
        Map<String, Object> map21 = data.get(21);
        Map<String, Object> innerMap21 = new HashMap<>();
        innerMap21.put("name", "life");
        innerMap21.put("text", "生活垃圾分出率");
        innerMap21.put("value", Double.parseDouble(String.valueOf(map21.get("value"))));
        resultList6.add(innerMap21);
        Map<String, Object> map22 = data.get(22);
        Map<String, Object> innerMap22 = new HashMap<>();
        innerMap22.put("name", "standard");
        innerMap22.put("text", "分类设施达标率");
        innerMap22.put("value", Double.parseDouble(String.valueOf(map22.get("value"))));
        resultList6.add(innerMap22);
        Map<String, Object> map23 = data.get(23);
        Map<String, Object> innerMap23 = new HashMap<>();
        innerMap23.put("name", "standard");
        innerMap23.put("text", "分类设施达标率");
        innerMap23.put("value", Double.parseDouble(String.valueOf(map23.get("value"))));
        resultList6.add(innerMap23);
        resultMap6.put("value", resultList6);
        list.add(resultMap6);
        System.out.println(list);
    }

    @Test
    public void test3() {
        List<Map<String, Object>> data = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> repeatMap1 = new HashMap<>();
        repeatMap1.put("value", 1);
        data.add(repeatMap1);
        Map<String, Object> repeatMap2 = new HashMap<>();
        repeatMap2.put("value", 2);
        data.add(repeatMap2);
        Map<String, Object> repeatMap3 = new HashMap<>();
        repeatMap3.put("value", 3);
        data.add(repeatMap3);
        Map<String, Object> repeatMap4 = new HashMap<>();
        repeatMap4.put("value", 4);
        data.add(repeatMap4);
        Map<String, Object> repeatMap5 = new HashMap<>();
        repeatMap5.put("value", 5);
        data.add(repeatMap5);
        Map<String, Object> repeatMap6 = new HashMap<>();
        repeatMap6.put("value", 6);
        data.add(repeatMap6);

        if (data.size() > 8) {
            double cuValue = Double.parseDouble(String.valueOf(data.get(0).get("value")));
            double qtValue = Double.parseDouble(String.valueOf(data.get(1).get("value")));
            double ccValue = Double.parseDouble(String.valueOf(data.get(2).get("value")));
            double jyValue = Double.parseDouble(String.valueOf(data.get(3).get("value")));
            double bhValue = Double.parseDouble(String.valueOf(data.get(4).get("value")));
            double cuyValue = Double.parseDouble(String.valueOf(data.get(5).get("value")));
            double qtyValue = Double.parseDouble(String.valueOf(data.get(6).get("value")));
            double ccyValue = Double.parseDouble(String.valueOf(data.get(7).get("value")));
            double jyyValue = Double.parseDouble(String.valueOf(data.get(8).get("value")));
            double bhyValue = Double.parseDouble(String.valueOf(data.get(9).get("value")));
            double total = cuValue + qtValue + ccValue;
            double yTotal = cuyValue + qtyValue + ccyValue;
            Map<String, Object> map1 = new HashMap<>();
            map1.put("name", "垃圾总量");
            map1.put("text", "垃圾总量");
            map1.put("value", total);
            map1.put("beRising", total > yTotal);
            double rate1 = 0;
            if (yTotal != 0) {
                rate1 = Math.abs((total - yTotal) * 100 / yTotal);
            }
            rate1 = java.math.BigDecimal.valueOf(rate1).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map1.put("rate", rate1);
            list.add(map1);

            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", "厨余垃圾");
            map2.put("text", "厨余垃圾");
            map2.put("value", cuValue);
            map2.put("beRising", cuValue > cuyValue);
            double rate2 = 0;
            if (cuyValue != 0) {
                rate2 = Math.abs((cuValue - cuyValue) * 100 / cuyValue);
            }
            rate2 = java.math.BigDecimal.valueOf(rate2).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map2.put("rate", rate2);
            list.add(map2);

            Map<String, Object> map3 = new HashMap<>();
            map3.put("name", "餐厨垃圾");
            map3.put("text", "餐厨垃圾");
            map3.put("value", ccValue);
            map3.put("beRising", ccValue > ccyValue);
            double rate3 = 0;
            if (ccyValue != 0) {
                rate3 = Math.abs((ccValue - ccyValue) * 100 / ccyValue);
            }
            rate3 = java.math.BigDecimal.valueOf(rate3).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map3.put("rate", rate3);
            list.add(map3);

            Map<String, Object> map4 = new HashMap<>();
            map4.put("name", "其他垃圾");
            map4.put("text", "其他垃圾");
            map4.put("value", qtValue);
            map4.put("beRising", qtValue > qtyValue);
            double rate4 = 0;
            if (ccyValue != 0) {
                rate4 = Math.abs((qtValue - qtyValue) * 100 / qtyValue);
            }
            rate4 = java.math.BigDecimal.valueOf(rate4).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map4.put("rate", rate4);
            list.add(map4);

            Map<String, Object> map5 = new HashMap<>();
            map5.put("name", "餐厨垃圾积压量");
            map5.put("text", "餐厨垃圾积压量");
            map5.put("value", jyValue);
            map5.put("beRising", jyValue > jyyValue);
            double rate5 = 0;
            if (jyyValue != 0) {
                rate5 = Math.abs((jyValue - jyyValue) * 100 / jyyValue);
            }
            rate5 = java.math.BigDecimal.valueOf(rate5).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map5.put("rate", rate5);
            list.add(map5);

            Map<String, Object> map6 = new HashMap<>();
            map6.put("name", "末端处理厂饱和度");
            map6.put("text", "末端处理厂饱和度");
            map6.put("value", bhValue);
            map6.put("beRising", bhValue > bhyValue);
            double rate6 = 0;
            if (bhyValue != 0) {
                rate6 = Math.abs((bhValue - bhyValue) * 100 / bhyValue);
            }
            rate6 = java.math.BigDecimal.valueOf(rate6).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map6.put("rate", rate6);
            list.add(map6);
        } else {
            double cuValue = Double.parseDouble(String.valueOf(data.get(0).get("value")));
            double qtValue = Double.parseDouble(String.valueOf(data.get(1).get("value")));
            double ccValue = Double.parseDouble(String.valueOf(data.get(2).get("value")));
            double jyValue = Double.parseDouble(String.valueOf(data.get(3).get("value")));
            double cuyValue = Double.parseDouble(String.valueOf(data.get(4).get("value")));
            double qtyValue = Double.parseDouble(String.valueOf(data.get(5).get("value")));
            double ccyValue = Double.parseDouble(String.valueOf(data.get(6).get("value")));
            double jyyValue = Double.parseDouble(String.valueOf(data.get(7).get("value")));
            double total = cuValue + qtValue + ccValue;
            double yTotal = cuyValue + qtyValue + ccyValue;
            Map<String, Object> map1 = new HashMap<>();
            map1.put("name", "垃圾总量");
            map1.put("text", "垃圾总量");
            map1.put("value", total);
            map1.put("beRising", total > yTotal);
            double rate1 = 0;
            if (yTotal != 0) {
                rate1 = Math.abs((total - yTotal) * 100 / yTotal);
            }
            rate1 = java.math.BigDecimal.valueOf(rate1).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map1.put("rate", rate1);
            list.add(map1);

            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", "厨余垃圾");
            map2.put("text", "厨余垃圾");
            map2.put("value", cuValue);
            map2.put("beRising", cuValue > cuyValue);
            double rate2 = 0;
            if (cuyValue != 0) {
                rate2 = Math.abs((cuValue - cuyValue) * 100 / cuyValue);
            }
            rate2 = java.math.BigDecimal.valueOf(rate2).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map2.put("rate", rate2);
            list.add(map2);

            Map<String, Object> map3 = new HashMap<>();
            map3.put("name", "餐厨垃圾");
            map3.put("text", "餐厨垃圾");
            map3.put("value", ccValue);
            map3.put("beRising", ccValue > ccyValue);
            double rate3 = 0;
            if (ccyValue != 0) {
                rate3 = Math.abs((ccValue - ccyValue) * 100 / ccyValue);
            }
            rate3 = java.math.BigDecimal.valueOf(rate3).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map3.put("rate", rate3);
            list.add(map3);

            Map<String, Object> map4 = new HashMap<>();
            map4.put("name", "其他垃圾");
            map4.put("text", "其他垃圾");
            map4.put("value", qtValue);
            map4.put("beRising", qtValue > qtyValue);
            double rate4 = 0;
            if (ccyValue != 0) {
                rate4 = Math.abs((qtValue - qtyValue) * 100 / qtyValue);
            }
            rate4 = java.math.BigDecimal.valueOf(rate4).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map4.put("rate", rate4);
            list.add(map4);

            Map<String, Object> map5 = new HashMap<>();
            map5.put("name", "餐厨垃圾积压量");
            map5.put("text", "餐厨垃圾积压量");
            map5.put("value", jyValue);
            map5.put("beRising", jyValue > jyyValue);
            double rate5 = 0;
            if (jyyValue != 0) {
                rate5 = Math.abs((jyValue - jyyValue) * 100 / jyyValue);
            }
            rate5 = java.math.BigDecimal.valueOf(rate5).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map5.put("rate", rate5);
            list.add(map5);
        }
        System.out.println(list);
    }


    @Test
    public void test31() {
        List<Map<String, Object>> data = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> repeatMap1 = new HashMap<>();
        repeatMap1.put("value", "-1");
        data.add(repeatMap1);
        Map<String, Object> repeatMap2 = new HashMap<>();
        repeatMap2.put("value", 2);
        data.add(repeatMap2);
        Map<String, Object> repeatMap3 = new HashMap<>();
        repeatMap3.put("value", 3);
        data.add(repeatMap3);
        Map<String, Object> repeatMap4 = new HashMap<>();
        repeatMap4.put("value", 4);
        data.add(repeatMap4);
        Map<String, Object> repeatMap5 = new HashMap<>();
        repeatMap5.put("value", 5);
        data.add(repeatMap5);
        Map<String, Object> repeatMap6 = new HashMap<>();
        repeatMap6.put("value", 6);
        data.add(repeatMap6);
        Map<String, Object> repeatMap7 = new HashMap<>();
        repeatMap7.put("value", 7);
        data.add(repeatMap7);
        Map<String, Object> repeatMap8 = new HashMap<>();
        repeatMap8.put("value", 8);
        data.add(repeatMap8);
        Map<String, Object> repeatMap9 = new HashMap<>();
        repeatMap9.put("value", 9);
        data.add(repeatMap9);

        String regionName = String.valueOf(data.get(0).get("value"));
        double cuValue = Double.parseDouble(String.valueOf(data.get(1).get("value")));
        double qtValue = Double.parseDouble(String.valueOf(data.get(2).get("value")));
        double ccValue = Double.parseDouble(String.valueOf(data.get(3).get("value")));
        double cuyValue = Double.parseDouble(String.valueOf(data.get(4).get("value")));
        double qtyValue = Double.parseDouble(String.valueOf(data.get(5).get("value")));
        double ccyValue = Double.parseDouble(String.valueOf(data.get(6).get("value")));
        double csValue = Double.parseDouble(String.valueOf(data.get(7).get("value")));
        double peValue = 0;
        if ("-1".equals(regionName)) {
            peValue = Double.parseDouble(String.valueOf(data.get(8).get("value")));
        }
        double total = cuValue + qtValue + ccValue;
        double yTotal = cuyValue + qtyValue + ccyValue;
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "垃圾总量");
        map1.put("text", "垃圾总量");
        map1.put("value", total);
        map1.put("beRising", total > yTotal);
        double rate1 = 0;
        if (yTotal != 0) {
            rate1 = Math.abs((total - yTotal) * 100 / yTotal);
        }
        rate1 = java.math.BigDecimal.valueOf(rate1).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
        map1.put("rate", rate1);
        list.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "厨余垃圾");
        map2.put("text", "厨余垃圾");
        map2.put("value", cuValue);
        map2.put("beRising", cuValue > cuyValue);
        double rate2 = 0;
        if (cuyValue != 0) {
            rate2 = Math.abs((cuValue - cuyValue) * 100 / cuyValue);
        }
        rate2 = java.math.BigDecimal.valueOf(rate2).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
        map2.put("rate", rate2);
        list.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "餐厨垃圾");
        map3.put("text", "餐厨垃圾");
        map3.put("value", ccValue);
        map3.put("beRising", ccValue > ccyValue);
        double rate3 = 0;
        if (ccyValue != 0) {
            rate3 = Math.abs((ccValue - ccyValue) * 100 / ccyValue);
        }
        rate3 = java.math.BigDecimal.valueOf(rate3).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
        map3.put("rate", rate3);
        list.add(map3);

        Map<String, Object> map4 = new HashMap<>();
        map4.put("name", "其他垃圾");
        map4.put("text", "其他垃圾");
        map4.put("value", qtValue);
        map4.put("beRising", qtValue > qtyValue);
        double rate4 = 0;
        if (ccyValue != 0) {
            rate4 = Math.abs((qtValue - qtyValue) * 100 / qtyValue);
        }
        rate4 = java.math.BigDecimal.valueOf(rate4).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
        map4.put("rate", rate4);
        list.add(map4);

        double jyValue = 0;
        if (csValue != 0) {
            jyValue = java.math.BigDecimal.valueOf((csValue - ccValue) * 100 / csValue).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
        }
        double jyyValue = 0;
        if (csValue != 0) {
            jyyValue = java.math.BigDecimal.valueOf((csValue - ccyValue) * 100 / csValue).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
        }
        Map<String, Object> map5 = new HashMap<>();
        map5.put("name", "餐厨垃圾积压量");
        map5.put("text", "餐厨垃圾积压量");
        map5.put("value", jyValue);
        map5.put("beRising", jyValue > jyyValue);
        double rate5 = 0;
        if (jyyValue != 0) {
            rate5 = Math.abs((jyValue - jyyValue) * 100 / jyyValue);
        }
        rate5 = java.math.BigDecimal.valueOf(rate5).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
        map5.put("rate", rate5);
        list.add(map5);

        if ("-1".equals(regionName)) {
            double bhValue = java.math.BigDecimal.valueOf(ccValue * 100 / peValue).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            double bhyValue = java.math.BigDecimal.valueOf(ccyValue * 100 / peValue).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            Map<String, Object> map6 = new HashMap<>();
            map6.put("name", "末端处理厂饱和度");
            map6.put("text", "末端处理厂饱和度");
            map6.put("value", bhValue);
            map6.put("beRising", bhValue > bhyValue);
            double rate6 = 0;
            if (bhyValue != 0) {
                rate6 = Math.abs((bhValue - bhyValue) * 100 / bhyValue);
            }
            rate6 = java.math.BigDecimal.valueOf(rate6).setScale(2, java.math.RoundingMode.HALF_UP).doubleValue();
            map6.put("rate", rate6);
            list.add(map6);
        }
        System.out.println(list);
    }

    @Test
    public void test4() {
        List<Map<String, Object>> data = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> repeatMap1 = new HashMap<>();
        repeatMap1.put("value", 1);
        repeatMap1.put("rank", 1);
        data.add(repeatMap1);
        Map<String, Object> repeatMap2 = new HashMap<>();
        repeatMap2.put("value", 2);
        repeatMap2.put("rank", 2);
        data.add(repeatMap2);
        Map<String, Object> repeatMap3 = new HashMap<>();
        repeatMap3.put("value", 3);
        repeatMap3.put("rank", 3);
        data.add(repeatMap3);
        Map<String, Object> repeatMap4 = new HashMap<>();
        repeatMap4.put("value", 4);
        repeatMap4.put("rank", 4);
        data.add(repeatMap4);
        Map<String, Object> repeatMap5 = new HashMap<>();
        repeatMap5.put("value", 5);
        repeatMap5.put("rank", 5);
        data.add(repeatMap5);
        Map<String, Object> repeatMap6 = new HashMap<>();
        repeatMap6.put("value", 6);
        repeatMap6.put("rank", 6);
        data.add(repeatMap6);
        Map<String, Object> repeatMap7 = new HashMap<>();
        repeatMap7.put("value", 7);
        repeatMap7.put("rank", 7);
        data.add(repeatMap7);
        Map<String, Object> repeatMap8 = new HashMap<>();
        repeatMap8.put("value", 8);
        repeatMap8.put("rank", 8);
        data.add(repeatMap8);

        Map<String, Object> map0 = data.get(0);
        Map<String, Object> map1 = data.get(1);
        Map<String, Object> map2 = data.get(2);
        Map<String, Object> map3 = data.get(3);
        Map<String, Object> map4 = data.get(4);
        Map<String, Object> map5 = data.get(5);
        Map<String, Object> map6 = data.get(6);
        Map<String, Object> map7 = data.get(7);
        double value0 = Double.parseDouble(String.valueOf(map0.get("value")));
        double value1 = Double.parseDouble(String.valueOf(map1.get("value")));
        double value2 = Double.parseDouble(String.valueOf(map2.get("value")));
        double value3 = Double.parseDouble(String.valueOf(map3.get("value")));
        double value4 = Double.parseDouble(String.valueOf(map4.get("value")));
        double value5 = Double.parseDouble(String.valueOf(map5.get("value")));
        double value6 = Double.parseDouble(String.valueOf(map6.get("value")));
        double value7 = Double.parseDouble(String.valueOf(map7.get("value")));
        int rank0 = Integer.parseInt(String.valueOf(map0.get("rank")));
        int rank1 = Integer.parseInt(String.valueOf(map1.get("rank")));
        int rank2 = Integer.parseInt(String.valueOf(map2.get("rank")));
        int rank3 = Integer.parseInt(String.valueOf(map3.get("rank")));
        int rank4 = Integer.parseInt(String.valueOf(map4.get("rank")));
        int rank5 = Integer.parseInt(String.valueOf(map5.get("rank")));
        int rank6 = Integer.parseInt(String.valueOf(map6.get("rank")));
        int rank7 = Integer.parseInt(String.valueOf(map7.get("rank")));
        Map<String, Object> innerMap0 = new HashMap<>();
        innerMap0.put("name", "家庭厨余垃圾分出率");
        innerMap0.put("text", "家庭厨余垃圾分出率");
        innerMap0.put("value", value0);
        innerMap0.put("beRising", rank0 < rank4);
        innerMap0.put("rank", rank0);
        innerMap0.put("rankChange", Math.abs(rank0 - rank4));
        Map<String, Object> innerMap1 = new HashMap<>();
        innerMap1.put("name", "生活垃圾减量率");
        innerMap1.put("text", "生活垃圾减量率");
        innerMap1.put("value", value1);
        innerMap1.put("beRising", rank1 < rank5);
        innerMap1.put("rank", rank1);
        innerMap1.put("rankChange", Math.abs(rank1 - rank5));
        Map<String, Object> innerMap2 = new HashMap<>();
        innerMap2.put("name", "分类设施达标率");
        innerMap2.put("text", "分类设施达标率");
        innerMap2.put("value", value2);
        innerMap2.put("beRising", rank2 < rank6);
        innerMap2.put("rank", rank2);
        innerMap2.put("rankChange", Math.abs(rank2 - rank6));
        Map<String, Object> innerMap3 = new HashMap<>();
        innerMap3.put("name", "居民投放准确率");
        innerMap3.put("text", "居民投放准确率");
        innerMap3.put("value", value3);
        innerMap3.put("beRising", rank3 < rank7);
        innerMap3.put("rank", rank3);
        innerMap3.put("rankChange", Math.abs(rank3 - rank7));
        list.add(innerMap0);
        list.add(innerMap1);
        list.add(innerMap2);
        list.add(innerMap3);
        System.out.println(list);
    }

    @Test
    public void test5() {
        List<Map<String, Object>> data = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> repeatMap1 = new HashMap<>();
        repeatMap1.put("count", 10000);
        data.add(repeatMap1);
        Map<String, Object> repeatMap2 = new HashMap<>();
        repeatMap2.put("count", 20);
        data.add(repeatMap2);
        Map<String, Object> repeatMap3 = new HashMap<>();
        repeatMap3.put("count", 20000);
        data.add(repeatMap3);
        Map<String, Object> repeatMap4 = new HashMap<>();
        repeatMap4.put("count", 4);
        data.add(repeatMap4);

        int streetCount = Integer.valueOf(String.valueOf(data.get(0).get("count")));
        int districtCount = Integer.valueOf(String.valueOf(data.get(1).get("count")));
        int preStreetCount = Integer.valueOf(String.valueOf(data.get(2).get("count")));
        int preDistrictCount = Integer.valueOf(String.valueOf(data.get(3).get("count")));

        Map<String, Object> resultMap1 = new HashMap<>();
        resultMap1.put("name", "districtPatrol");
        resultMap1.put("text", "区网格员月上报数");
        Map<String, Object> innerMap1 = new HashMap<>();
        innerMap1.put("last", preDistrictCount);
        innerMap1.put("current", districtCount);
        innerMap1.put("beRising", districtCount > preDistrictCount);
        String str = String.valueOf(preDistrictCount == 0 ? 100 : Math.abs(districtCount - preDistrictCount) * 100 / preDistrictCount);
        str = str.substring(0, str.indexOf(".") == -1 ? str.length() :  str.indexOf(".") );
        innerMap1.put("rate", Integer.valueOf(str));
        innerMap1.put("variate", districtCount - preDistrictCount);
        resultMap1.put("value", innerMap1);
        Map<String, Object> resultMap2 = new HashMap<>();
        resultMap2.put("name", "streetPatrol");
        resultMap2.put("text", "街镇网格员月上报数");
        Map<String, Object> innerMap2 = new HashMap<>();
        innerMap2.put("last", preStreetCount);
        innerMap2.put("current", streetCount);
        innerMap2.put("beRising", streetCount > preStreetCount);
        innerMap2.put("rate", preStreetCount == 0 ? 100 : Math.abs(streetCount - preStreetCount) * 100 / preStreetCount);
        innerMap2.put("variate", streetCount - preStreetCount);
        resultMap2.put("value", innerMap2);
        list.add(resultMap1);
        list.add(resultMap2);
    }

    @Test
    public void test6() {
        List<Map<String, Object>> data = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> repeatMap1 = new HashMap<>();
        repeatMap1.put("name", "2021-09-27");
        repeatMap1.put("text", "2021-09-27");
        repeatMap1.put("alarm", 1);
        repeatMap1.put("discovery", 2);
        repeatMap1.put("complaint", 3);

        Map<String, Object> repeatMap2 = new HashMap<>();
        repeatMap2.put("name", "2021-09-26");
        repeatMap2.put("text", "2021-09-26");
        repeatMap2.put("alarm", 1);
        repeatMap2.put("discovery", 2);
        repeatMap2.put("complaint", 3);

        Map<String, Object> repeatMap3 = new HashMap<>();
        repeatMap3.put("name", "2021-09-25");
        repeatMap3.put("text", "2021-09-25");
        repeatMap3.put("alarm", 1);
        repeatMap3.put("discovery", 2);
        repeatMap3.put("complaint", 3);

        Map<String, Object> repeatMap4 = new HashMap<>();
        repeatMap4.put("name", "2021-09-24");
        repeatMap4.put("text", "2021-09-24");
        repeatMap4.put("alarm", 1);
        repeatMap4.put("discovery", 2);
        repeatMap4.put("complaint", 3);

        Map<String, Object> repeatMap5 = new HashMap<>();
        repeatMap5.put("name", "2021-09-23");
        repeatMap5.put("text", "2021-09-23");
        repeatMap5.put("alarm", 1);
        repeatMap5.put("discovery", 2);
        repeatMap5.put("complaint", 3);

        Map<String, Object> repeatMap6 = new HashMap<>();
        repeatMap6.put("name", "2021-09-22");
        repeatMap6.put("text", "2021-09-22");
        repeatMap6.put("alarm", 1);
        repeatMap6.put("discovery", 2);
        repeatMap6.put("complaint", 3);

        Map<String, Object> repeatMap7 = new HashMap<>();
        repeatMap7.put("name", "2021-09-27");
        repeatMap7.put("text", "2021-09-27");
        repeatMap7.put("alarm", 1);
        repeatMap7.put("discovery", 2);
        repeatMap7.put("complaint", 3);

        data.add(repeatMap1);
        data.add(repeatMap2);
        data.add(repeatMap3);
        data.add(repeatMap4);
        data.add(repeatMap5);
        data.add(repeatMap6);
        data.add(repeatMap7);

        for (Map<String, Object> datum : data) {
            String name = String.valueOf(datum.get("name"));
            String text = String.valueOf(datum.get("text"));
            int alarm = Integer.valueOf(String.valueOf(datum.get("alarm")));
            int discovery = Integer.valueOf(String.valueOf(datum.get("discovery")));
            int complaint = Integer.valueOf(String.valueOf(datum.get("complaint")));
            Map<String,Object> map = new HashMap<>();
            map.put("name", name);
            map.put("text", text);
            List<Map<String, Object>> innerList = new ArrayList<>();
            Map<String,Object> innerMap1 = new HashMap<>();
            innerMap1.put("name", "1");
            innerMap1.put("text", "监测预警");
            innerMap1.put("value", alarm);

            Map<String,Object> innerMap2 = new HashMap<>();
            innerMap2.put("name", "2");
            innerMap2.put("text", "检查发现");
            innerMap2.put("value", discovery);

            Map<String,Object> innerMap3 = new HashMap<>();
            innerMap3.put("name", "3");
            innerMap3.put("text", "市民投诉");
            innerMap3.put("value", complaint);
            innerList.add(innerMap1);
            innerList.add(innerMap2);
            innerList.add(innerMap3);
            map.put("value",innerList);
            list.add(map);
        }
        System.out.println(list);
    }

    @Test
    public void test7() {
        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        int companyTotal = 0;
        int deviceTotal = 0;
        int deviceOnline = 0;
        int deviceExceeded = 0;
        Object company_total = data.get("company_total");
        if (company_total != null) {
            companyTotal = Integer.parseInt(String.valueOf(company_total));
        }
        Object equipment_total = data.get("equipment_total");
        if (equipment_total != null) {
            deviceTotal = Integer.parseInt(String.valueOf(equipment_total));
        }
        Object online_on_total = data.get("online_on_total");
        if (online_on_total != null) {
            deviceOnline = Integer.parseInt(String.valueOf(online_on_total));
        }
        Object exceeded_total = data.get("exceeded_total");
        if (exceeded_total != null) {
            deviceExceeded = Integer.parseInt(String.valueOf(exceeded_total));
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "company");
        map1.put("text", "企业总数");
        map1.put("value", companyTotal);
        map1.put("unit", "家");
        list.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "device");
        map2.put("text", "设备总数");
        map2.put("value", deviceTotal);
        map2.put("unit", "台");
        list.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "online-device");
        map3.put("text", "在线设备数");
        map3.put("value", deviceOnline);
        map3.put("unit", "台");
        list.add(map3);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("name", "excessive-device");
        map4.put("text", "超标设备数");
        map4.put("value", deviceExceeded);
        map4.put("unit", "台");
        list.add(map4);
    }

    @Test
    public void test8() {
        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        int total = 0;
        int processed = 0;
        int pending = 0;
        Object totalObj = data.get("total");
        if (totalObj != null) {
            total = (int) Double.parseDouble(String.valueOf(totalObj));
        }
        Object processedValue = data.get("processedValue");
        if (processedValue != null) {
            processed = (int) Double.parseDouble(String.valueOf(processedValue));
        }
        Object pendingValue = data.get("pendingValue");
        if (pendingValue != null) {
            pending = (int) Double.parseDouble(String.valueOf(pendingValue));
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "total");
        map1.put("text", "工单总数");
        map1.put("value", total);
        list.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "processed");
        map2.put("text", "已办工单");
        map2.put("value", processed);
        list.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "pending");
        map3.put("text", "待办工单");
        map3.put("value", pending);
        list.add(map3);
    }

    @Test
    public void test9() {
        List<Map<String, Object>> data = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();
        List<Map<String, Object>> registerList = new ArrayList<>();
        List<Map<String, Object>> disposeList = new ArrayList<>();
        data.forEach(m -> {
            Object timeStr = m.get("timeStr");
            Object register = m.get("register");
            Object dispose = m.get("dispose");
            Map<String, Object> registerMap = new HashMap<>();
            Map<String, Object> disposeMap = new HashMap<>();
            registerMap.put("name", timeStr);
            registerMap.put("text", timeStr);
            registerMap.put("value", register);
            disposeMap.put("name", timeStr);
            disposeMap.put("text", timeStr);
            disposeMap.put("value", dispose);
            registerList.add(registerMap);
            disposeList.add(disposeMap);
        });
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "register");
        map1.put("text", "立案");
        map1.put("value", registerList);
        list.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "dispose");
        map2.put("text", "处置");
        map2.put("value", disposeList);
        list.add(map2);
    }

    @Test
    public void test10() {
        List<Map<String, Object>> data = new ArrayList<>();
        if (CollectionUtils.isEmpty(data)) {

        }
        Map<String, Object> map = data.get(0);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "0");
        map1.put("text", "人员姓名");
        map1.put("value", map.get("patrol_name"));
        list.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "1");
        map2.put("text", "工卡号");
        map2.put("value", map.get("card_id"));
        list.add(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "2");
        map3.put("text", "联系电话");
        map3.put("value", map.get("tel_mobile"));
        list.add(map3);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("name", "4");
        map4.put("text", "最后登录时间");
        map4.put("value", map.get("loginTime"));
        list.add(map4);
    }

    @Test
    public void test11() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.stream().filter(item -> item == 1).collect(Collectors.toList()));
    }

    @Test
    public void test12() {
        List<String> list = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(10);
        LocalDate tmp = startDate;
        while (tmp.compareTo(endDate) < 0) {
            list.add(tmp.format(dtf));
            tmp = tmp.plusDays(1);
        }
        System.out.println(list);
    }
}
