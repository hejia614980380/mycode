package com.hejia.demo;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

/**
 * @Author: hj
 * @Date: 2021/1/9 15:48
 */
public class FreemarkerDemo {
    public final static String template = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><style type=\"text/css\">table {border-collapse:collapse;}th,td {padding:0 10px;border-bottom:2px dashed #666;text-align:center;}</style></head><body><h1 style=\"text-align: center\">探矿权使用费欠缴单位清单</h1><p>缴费基准日期：${baseDate}</p><table><tr><th>许可证号(勘察年度)</th><th>申请人</th><th>总面积</th><th>欠缴费额(千元)</th></tr><#list results as res><tr><td>${res.permitNo}(${res.annual})</td><td>${res.applicant}</td><td>${res.area}</td><td>${res.noChargeFee}</td></tr></#list></table><p>合计欠缴使用费：${total} 万元</p></body></html>";

    @Test
    public void test1() {
        Configuration configuration = new Configuration(new Version("2.3.28"));
        configuration.setDefaultEncoding("UTF-8");
        try {
            configuration.setDirectoryForTemplateLoading(new File("D:\\test"));
            Template template = configuration.getTemplate("miningWordTemplate.xml", "utf-8");
            String fileName = "分析报告.doc";
            FileOutputStream outputStream = new FileOutputStream("D:\\test" + File.separator +  fileName);
            Map<String, Object> map = new HashMap<>();
            map.put("permitNo", "1");
            map.put("projectType", "新立");
            map.put("projectName", "projectName");
            map.put("applicant", "国家卫健委");
            map.put("varietyName", "金矿");
            map.put("area", "11.22");
            map.put("year1", "1");
            map.put("area1", "20.22");
            map.put("permitNo1", "111111");
            map.put("chargeTime1", "2020-12-12～2020-12-12");
            map.put("dutyCharge1", "12");
            map.put("actualCharge1", "12");
            map.put("totalDuty", "12");
            map.put("totalActual", "12");
            template.process(map, new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Configuration configuration = new Configuration(new Version("2.3.28"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
        StringTemplateLoader stringTemplateLoader= new StringTemplateLoader();
        String name = "test";
        stringTemplateLoader.putTemplate(name, template);
        configuration.setTemplateLoader(stringTemplateLoader);
        Map<String, Object> data = new HashMap<>();
        data.put("baseDate", "2020年12月20日");
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Map<String, Object> data1 = new HashMap<>();
            data1.put("permitNo", "C5325002014092130135626");
            data1.put("annual", 12);
            data1.put("applicant", "峨山昆钢矿产业有限公司");
            data1.put("area", 6.47);
            data1.put("noChargeFee", 3.24);
            list.add(data1);
        }
        data.put("results", list);
        data.put("total", 0.32);
        try {
            Template template = configuration.getTemplate(name,"UTF-8");
            StringWriter out = new StringWriter();
            template.process(data, out);
            out.flush();
            System.out.println(out.toString());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        System.out.println(LocalDate.ofYearDay(2020, 1));
    }
}
