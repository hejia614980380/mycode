package com.hejia.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ddcatdemo2 {
    @Test
    public void test1() {
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
        Map<String, Object> repeatMap7 = new HashMap<>();
        repeatMap7.put("value", 7);
        data.add(repeatMap7);
        Map<String, Object> repeatMap8 = new HashMap<>();
        repeatMap8.put("value", 8);
        data.add(repeatMap8);

        Map<String, Object> map0 = data.get(0);
        Object value0 = map0.get("value");
        Map<String, Object> map1 = data.get(1);
        Object value1 = map1.get("value");
        Map<String, Object> map2 = data.get(2);
        Object value2 = map2.get("value");
        Map<String, Object> map3 = data.get(3);
        Object value3 = map3.get("value");
        Map<String, Object> map4 = data.get(4);
        Object value4 = map4.get("value");
        Map<String, Object> map5 = data.get(5);
        Object value5 = map5.get("value");
        Map<String, Object> map6 = data.get(6);
        Object value6 = map6.get("value");
        Map<String, Object> map7 = data.get(7);
        Object value7 = map7.get("value");

        Map<String, Object> resultMap1 = new HashMap<>();
        resultMap1.put("name", "register");
        resultMap1.put("text", "企业注册");
        List<Map<String, Object>> resultList1 = new ArrayList<>();
        Map<String, Object> innerMap1 = new HashMap<>();
        innerMap1.put("name", "新设企业");
        innerMap1.put("text", "新设企业");
        innerMap1.put("value", value0);
        innerMap1.put("unit", "户");
        Map<String, Object> innerMap2 = new HashMap<>();
        innerMap2.put("name", "注册资本");
        innerMap2.put("text", "注册资本");
        innerMap2.put("value", value1);
        innerMap2.put("unit", "亿");
        resultList1.add(innerMap1);
        resultList1.add(innerMap2);
        resultMap1.put("value", resultList1);
        list.add(resultMap1);

        Map<String, Object> resultMap2 = new HashMap<>();
        resultMap2.put("name", "in");
        resultMap2.put("text", "迁入");
        List<Map<String, Object>> resultList2 = new ArrayList<>();
        Map<String, Object> innerMap3 = new HashMap<>();
        innerMap3.put("name", "迁入企业");
        innerMap3.put("text", "迁入企业");
        innerMap3.put("value", value2);
        innerMap3.put("unit", "平方米");
        Map<String, Object> innerMap4 = new HashMap<>();
        innerMap4.put("name", "注册资本");
        innerMap4.put("text", "注册资本");
        innerMap4.put("value", value3);
        innerMap4.put("unit", "亿");
        resultList2.add(innerMap3);
        resultList2.add(innerMap4);
        resultMap2.put("value", resultList2);
        list.add(resultMap2);

        Map<String, Object> resultMap3 = new HashMap<>();
        resultMap3.put("name", "cancel");
        resultMap3.put("text", "注销");
        List<Map<String, Object>> resultList3 = new ArrayList<>();
        Map<String, Object> innerMap5 = new HashMap<>();
        innerMap5.put("name", "注销企业");
        innerMap5.put("text", "注销企业");
        innerMap5.put("value", value4);
        innerMap5.put("unit", "户");
        Map<String, Object> innerMap6 = new HashMap<>();
        innerMap6.put("name", "注册资本");
        innerMap6.put("text", "注册资本");
        innerMap6.put("value", value5);
        innerMap6.put("unit", "亿");
        resultList3.add(innerMap5);
        resultList3.add(innerMap6);
        resultMap3.put("value", resultList3);
        list.add(resultMap3);

        Map<String, Object> resultMap4 = new HashMap<>();
        resultMap4.put("name", "out");
        resultMap4.put("text", "迁出");
        List<Map<String, Object>> resultList4 = new ArrayList<>();
        Map<String, Object> innerMap7 = new HashMap<>();
        innerMap7.put("name", "迁出企业");
        innerMap7.put("text", "迁出企业");
        innerMap7.put("value", value6);
        innerMap7.put("unit", "户");
        Map<String, Object> innerMap8 = new HashMap<>();
        innerMap8.put("name", "注册资本");
        innerMap8.put("text", "注册资本");
        innerMap8.put("value", value7);
        innerMap8.put("unit", "亿");
        resultList4.add(innerMap7);
        resultList4.add(innerMap8);
        resultMap4.put("value", resultList4);
        list.add(resultMap4);

        System.out.println(list);
    }
}
