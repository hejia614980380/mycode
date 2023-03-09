package com.hejia.generate;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hj
 * @Date: 2021/5/27 11:00
 */
public class GenerateDemo {

    @Test
    public void test1() {
//        String content = "";
        String content = "{\"mainType\":\"personnel\",\"mainTypeText\":\"特殊人群\",\"subType\":\"visit\",\"subTypeText\":\"走访人员\",\"tableName\":\"\",\"tableNameNew\":\"\",\"url\":\"/unity/personnel/visit/detail/{id}\",\"pageUrl\":\"/unity/personnel/visit/page\",\"querySql\":\"\",\"pageQuerySql\":\"\",\"fields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"type\",\"text\":\"人员类型\",\"showFlag\":true},{\"name\":\"visitTime\",\"text\":\"走访时间\",\"showFlag\":true},{\"name\":\"visitAddress\",\"text\":\"走访地点\",\"showFlag\":true},{\"name\":\"visitor\",\"text\":\"走访人\",\"showFlag\":true},{\"name\":\"respondent\",\"text\":\"被走访人\",\"showFlag\":true},{\"name\":\"respondentContact\",\"text\":\"被走访人联系方式\",\"showFlag\":true},{\"name\":\"visitMethod\",\"text\":\"走访方式\",\"showFlag\":true},{\"name\":\"visitSituation\",\"text\":\"走访情况\",\"showFlag\":true},{\"name\":\"image\",\"text\":\"图片\",\"showFlag\":true},{\"name\":\"longitude\",\"text\":\"经度\",\"showFlag\":false},{\"name\":\"latitude\",\"text\":\"纬度\",\"showFlag\":false}],\"pageFields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"type\",\"text\":\"人员类型\",\"showFlag\":true},{\"name\":\"visitTime\",\"text\":\"走访时间\",\"showFlag\":true},{\"name\":\"visitAddress\",\"text\":\"走访地点\",\"showFlag\":true},{\"name\":\"visitor\",\"text\":\"走访人\",\"showFlag\":true},{\"name\":\"respondent\",\"text\":\"被走访人\",\"showFlag\":true},{\"name\":\"respondentContact\",\"text\":\"被走访人联系方式\",\"showFlag\":true},{\"name\":\"visitMethod\",\"text\":\"走访方式\",\"showFlag\":true},{\"name\":\"visitSituation\",\"text\":\"走访情况\",\"showFlag\":true},{\"name\":\"image\",\"text\":\"图片\",\"showFlag\":true},{\"name\":\"longitude\",\"text\":\"经度\",\"showFlag\":false},{\"name\":\"latitude\",\"text\":\"纬度\",\"showFlag\":false}]}";
        GenerateVO generateVO = JSON.parseObject(content, GenerateVO.class);
        List<GenerateVO.Inner> fields = generateVO.getFields();
        StringBuilder sb = new StringBuilder();
        fields.forEach(field -> {
            sb.append(String.format("\"%s\"", field.getName()));
            sb.append(": \"\", // ");
            sb.append(field.getText());
        });
        System.out.println(sb.toString());
    }

    @Test
    public void test2() {
        String content = "3715124104032210307";
        int length = content.length();
        System.out.println(Integer.valueOf(content.substring(length-2, length)));

    }

    @Test
    public void test3() {
//        String content = "";
        String content = "{\"mainType\":\"personnel\",\"mainTypeText\":\"特殊人群\",\"subType\":\"visit\",\"subTypeText\":\"走访人员\",\"tableName\":\"\",\"tableNameNew\":\"\",\"url\":\"/unity/personnel/visit/detail/{id}\",\"pageUrl\":\"/unity/personnel/visit/page\",\"querySql\":\"\",\"pageQuerySql\":\"\",\"fields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"type\",\"text\":\"人员类型\",\"showFlag\":true},{\"name\":\"visitTime\",\"text\":\"走访时间\",\"showFlag\":true},{\"name\":\"visitAddress\",\"text\":\"走访地点\",\"showFlag\":true},{\"name\":\"visitor\",\"text\":\"走访人\",\"showFlag\":true},{\"name\":\"respondent\",\"text\":\"被走访人\",\"showFlag\":true},{\"name\":\"respondentContact\",\"text\":\"被走访人联系方式\",\"showFlag\":true},{\"name\":\"visitMethod\",\"text\":\"走访方式\",\"showFlag\":true},{\"name\":\"visitSituation\",\"text\":\"走访情况\",\"showFlag\":true},{\"name\":\"image\",\"text\":\"图片\",\"showFlag\":true},{\"name\":\"longitude\",\"text\":\"经度\",\"showFlag\":false},{\"name\":\"latitude\",\"text\":\"纬度\",\"showFlag\":false}],\"pageFields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"type\",\"text\":\"人员类型\",\"showFlag\":true},{\"name\":\"visitTime\",\"text\":\"走访时间\",\"showFlag\":true},{\"name\":\"visitAddress\",\"text\":\"走访地点\",\"showFlag\":true},{\"name\":\"visitor\",\"text\":\"走访人\",\"showFlag\":true},{\"name\":\"respondent\",\"text\":\"被走访人\",\"showFlag\":true},{\"name\":\"respondentContact\",\"text\":\"被走访人联系方式\",\"showFlag\":true},{\"name\":\"visitMethod\",\"text\":\"走访方式\",\"showFlag\":true},{\"name\":\"visitSituation\",\"text\":\"走访情况\",\"showFlag\":true},{\"name\":\"image\",\"text\":\"图片\",\"showFlag\":true},{\"name\":\"longitude\",\"text\":\"经度\",\"showFlag\":false},{\"name\":\"latitude\",\"text\":\"纬度\",\"showFlag\":false}]}\n";
        GenerateVO generateVO = JSON.parseObject(content, GenerateVO.class);
        List<GenerateVO.Inner> fields = generateVO.getPageFields();
        StringBuilder sb = new StringBuilder("{\n" +
                "  \"hasError\": false,\n" +
                "  \"result\": [");
        int num = 1;
        for (int i = 0; i < 3; i++) {
            sb.append("{\"id\":\"").append(num ++).append("\", // 主键 \n");
            for (int j = 0; j < fields.size(); j++) {
                GenerateVO.Inner field = fields.get(j);
                if (!field.getShowFlag()) {
                    continue;
                }
                sb.append(String.format("\"%s\"", field.getName()));
                if (j < fields.size() -1) {
                    sb.append(": \"\", // ");
                } else {
                    sb.append(": \"\" // ");
                }
                sb.append(field.getText());
                sb.append('\n');
            }
            if (i < 2) {
                sb.append("},\n");
            } else {
                sb.append("}\n");
            }
        }
        sb.append("],\n" +
                "\"message\": null,\n" +
                "\"messageList\": [],\n" +
                "\"tag\": null,\n" +
                "\"totalCount\": 3\n" +
                "}");
        System.out.println(sb.toString());
    }

    @Test
    public void test4() {
//        String content = "";
        String content = "[{\"mainType\":\"serviced-personnel\",\"mainTypeText\":\"被服务人员\",\"subType\":\"Poor\",\"subTypeText\":\"贫困户\",\"tableName\":\"tccmpkh\",\"tableNameNew\":\"\",\"url\":\"/unity/serviced-personnel/Poor/detail/{id}\",\"pageUrl\":\"/unity/serviced-personnel/Poor/page\",\"querySql\":\"\",\"pageQuerySql\":\"\",\"fields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"姓名\",\"showFlag\":true},{\"name\":\"gender\",\"text\":\"性别\",\"showFlag\":true},{\"name\":\"birthday\",\"text\":\"出生日期\",\"showFlag\":true},{\"name\":\"identityNo\",\"text\":\"身份号码\",\"showFlag\":true},{\"name\":\"domicile\",\"text\":\"户籍所在地\",\"showFlag\":true},{\"name\":\"address\",\"text\":\"家庭住址\",\"showFlag\":true},{\"name\":\"contact\",\"text\":\"联系方式\",\"showFlag\":true},{\"name\":\"liveAloneFlag\",\"text\":\"是否独居\",\"showFlag\":true},{\"name\":\"hzrName\",\"text\":\"合住人姓名\",\"showFlag\":true},{\"name\":\"hzrIdentityNo\",\"text\":\"合住人身份证号\",\"showFlag\":true},{\"name\":\"hzrContact\",\"text\":\"合住人联系方式\",\"showFlag\":true},{\"name\":\"hzrRelation\",\"text\":\"合住人与走访对象关系\",\"showFlag\":true},{\"name\":\"seriousDisease\",\"text\":\"重大疾病\",\"showFlag\":true},{\"name\":\"actionCapability\",\"text\":\"行动能力\",\"showFlag\":true},{\"name\":\"expressionCapability\",\"text\":\"表达能力\",\"showFlag\":true},{\"name\":\"liveCapability\",\"text\":\"具备自主吃饭、穿衣、上下床、如厕、室内行走、洗澡能力\",\"showFlag\":true},{\"name\":\"districtName\",\"text\":\"所属区域\",\"showFlag\":true},{\"name\":\"streetName\",\"text\":\"所属街道\",\"showFlag\":true},{\"name\":\"communityName\",\"text\":\"所属社区\",\"showFlag\":true},{\"name\":\"gridName\",\"text\":\"所属网格\",\"showFlag\":true}],\"pageFields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"姓名\",\"showFlag\":true},{\"name\":\"gender\",\"text\":\"性别\",\"showFlag\":true},{\"name\":\"birthday\",\"text\":\"出生日期\",\"showFlag\":true},{\"name\":\"address\",\"text\":\"家庭住址\",\"showFlag\":true},{\"name\":\"seriousDisease\",\"text\":\"重大疾病\",\"showFlag\":true}]},{\"mainType\":\"serviced-personnel\",\"mainTypeText\":\"被服务人员\",\"subType\":\"LowIncomeResident\",\"subTypeText\":\"低保户\",\"tableName\":\"tccmdbh\",\"tableNameNew\":\"\",\"url\":\"/unity/serviced-personnel/LowIncomeResident/detail/{id}\",\"pageUrl\":\"/unity/serviced-personnel/LowIncomeResident/page\",\"querySql\":\"\",\"pageQuerySql\":\"\",\"fields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"姓名\",\"showFlag\":true},{\"name\":\"gender\",\"text\":\"性别\",\"showFlag\":true},{\"name\":\"birthday\",\"text\":\"出生日期\",\"showFlag\":true},{\"name\":\"identityNo\",\"text\":\"身份号码\",\"showFlag\":true},{\"name\":\"domicile\",\"text\":\"户籍所在地\",\"showFlag\":true},{\"name\":\"address\",\"text\":\"家庭住址\",\"showFlag\":true},{\"name\":\"contact\",\"text\":\"联系方式\",\"showFlag\":true},{\"name\":\"liveAloneFlag\",\"text\":\"是否独居\",\"showFlag\":true},{\"name\":\"hzrName\",\"text\":\"合住人姓名\",\"showFlag\":true},{\"name\":\"hzrIdentityNo\",\"text\":\"合住人身份证号\",\"showFlag\":true},{\"name\":\"hzrContact\",\"text\":\"合住人联系方式\",\"showFlag\":true},{\"name\":\"hzrRelation\",\"text\":\"合住人与走访对象关系\",\"showFlag\":true},{\"name\":\"seriousDisease\",\"text\":\"重大疾病\",\"showFlag\":true},{\"name\":\"actionCapability\",\"text\":\"行动能力\",\"showFlag\":true},{\"name\":\"expressionCapability\",\"text\":\"表达能力\",\"showFlag\":true},{\"name\":\"liveCapability\",\"text\":\"具备自主吃饭、穿衣、上下床、如厕、室内行走、洗澡能力\",\"showFlag\":true},{\"name\":\"districtName\",\"text\":\"所属区域\",\"showFlag\":true},{\"name\":\"streetName\",\"text\":\"所属街道\",\"showFlag\":true},{\"name\":\"communityName\",\"text\":\"所属社区\",\"showFlag\":true},{\"name\":\"gridName\",\"text\":\"所属网格\",\"showFlag\":true}],\"pageFields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"姓名\",\"showFlag\":true},{\"name\":\"gender\",\"text\":\"性别\",\"showFlag\":true},{\"name\":\"birthday\",\"text\":\"出生日期\",\"showFlag\":true},{\"name\":\"address\",\"text\":\"家庭住址\",\"showFlag\":true},{\"name\":\"seriousDisease\",\"text\":\"重大疾病\",\"showFlag\":true}]},{\"mainType\":\"serviced-personnel\",\"mainTypeText\":\"被服务人员\",\"subType\":\"FiveGuaranteeResident\",\"subTypeText\":\"五保户\",\"tableName\":\"tccmwbh\",\"tableNameNew\":\"\",\"url\":\"/unity/serviced-personnel/FiveGuaranteeResident/detail/{id}\",\"pageUrl\":\"/unity/serviced-personnel/FiveGuaranteeResident/page\",\"querySql\":\"\",\"pageQuerySql\":\"\",\"fields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"姓名\",\"showFlag\":true},{\"name\":\"gender\",\"text\":\"性别\",\"showFlag\":true},{\"name\":\"birthday\",\"text\":\"出生日期\",\"showFlag\":true},{\"name\":\"identityNo\",\"text\":\"身份号码\",\"showFlag\":true},{\"name\":\"domicile\",\"text\":\"户籍所在地\",\"showFlag\":true},{\"name\":\"address\",\"text\":\"家庭住址\",\"showFlag\":true},{\"name\":\"contact\",\"text\":\"联系方式\",\"showFlag\":true},{\"name\":\"liveAloneFlag\",\"text\":\"是否独居\",\"showFlag\":true},{\"name\":\"hzrName\",\"text\":\"合住人姓名\",\"showFlag\":true},{\"name\":\"hzrIdentityNo\",\"text\":\"合住人身份证号\",\"showFlag\":true},{\"name\":\"hzrContact\",\"text\":\"合住人联系方式\",\"showFlag\":true},{\"name\":\"hzrRelation\",\"text\":\"合住人与走访对象关系\",\"showFlag\":true},{\"name\":\"seriousDisease\",\"text\":\"重大疾病\",\"showFlag\":true},{\"name\":\"actionCapability\",\"text\":\"行动能力\",\"showFlag\":true},{\"name\":\"expressionCapability\",\"text\":\"表达能力\",\"showFlag\":true},{\"name\":\"liveCapability\",\"text\":\"具备自主吃饭、穿衣、上下床、如厕、室内行走、洗澡能力\",\"showFlag\":true},{\"name\":\"districtName\",\"text\":\"所属区域\",\"showFlag\":true},{\"name\":\"streetName\",\"text\":\"所属街道\",\"showFlag\":true},{\"name\":\"communityName\",\"text\":\"所属社区\",\"showFlag\":true},{\"name\":\"gridName\",\"text\":\"所属网格\",\"showFlag\":true}],\"pageFields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"姓名\",\"showFlag\":true},{\"name\":\"gender\",\"text\":\"性别\",\"showFlag\":true},{\"name\":\"birthday\",\"text\":\"出生日期\",\"showFlag\":true},{\"name\":\"address\",\"text\":\"家庭住址\",\"showFlag\":true},{\"name\":\"seriousDisease\",\"text\":\"重大疾病\",\"showFlag\":true}]},{\"mainType\":\"serviced-personnel\",\"mainTypeText\":\"被服务人员\",\"subType\":\"Handicapped\",\"subTypeText\":\"残疾人\",\"tableName\":\"tccmcjr\",\"tableNameNew\":\"\",\"url\":\"/unity/serviced-personnel/Handicapped/detail/{id}\",\"pageUrl\":\"/unity/serviced-personnel/Handicapped/page\",\"querySql\":\"\",\"pageQuerySql\":\"\",\"fields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"姓名\",\"showFlag\":true},{\"name\":\"gender\",\"text\":\"性别\",\"showFlag\":true},{\"name\":\"birthday\",\"text\":\"出生日期\",\"showFlag\":true},{\"name\":\"identityNo\",\"text\":\"身份号码\",\"showFlag\":true},{\"name\":\"contact\",\"text\":\"联系方式\",\"showFlag\":true},{\"name\":\"districtName\",\"text\":\"所属区域\",\"showFlag\":true},{\"name\":\"streetName\",\"text\":\"所属街道\",\"showFlag\":true},{\"name\":\"communityName\",\"text\":\"所属社区\",\"showFlag\":true},{\"name\":\"gridName\",\"text\":\"所属网格\",\"showFlag\":true}],\"pageFields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"姓名\",\"showFlag\":true},{\"name\":\"gender\",\"text\":\"性别\",\"showFlag\":true},{\"name\":\"birthday\",\"text\":\"出生日期\",\"showFlag\":true},{\"name\":\"address\",\"text\":\"家庭住址\",\"showFlag\":true}]},{\"mainType\":\"religion\",\"mainTypeText\":\"宗教活动场所\",\"subType\":\"ReligionPlace\",\"subTypeText\":\"宗教活动场所\",\"tableName\":\"tccmzjhdcs\",\"tableNameNew\":\"\",\"url\":\"/unity/religion/ReligionPlace/detail/{id}\",\"pageUrl\":\"/unity/religion/page\",\"querySql\":\"\",\"pageQuerySql\":\"\",\"fields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"场所名称\",\"showFlag\":true},{\"name\":\"address\",\"text\":\"地址\",\"showFlag\":true},{\"name\":\"districtName\",\"text\":\"所属区域\",\"showFlag\":true},{\"name\":\"streetName\",\"text\":\"所属街道\",\"showFlag\":true},{\"name\":\"communityName\",\"text\":\"所属社区\",\"showFlag\":true},{\"name\":\"gridName\",\"text\":\"所属网格\",\"showFlag\":true},{\"name\":\"picture\",\"text\":\"图片\",\"showFlag\":true}],\"pageFields\":[{\"name\":\"id\",\"text\":\"主键\",\"showFlag\":false},{\"name\":\"name\",\"text\":\"场所名称\",\"showFlag\":true},{\"name\":\"address\",\"text\":\"地址\",\"showFlag\":true}]}]";
//        GenerateVO generateVO = JSON.parseObject(content, GenerateVO.class);
        List<GenerateVO> generateVOS = JSON.parseArray(content, GenerateVO.class);
        int num = 43;
        StringBuilder sb = new StringBuilder("INSERT INTO bra_field_configuration VALUES ");
        for (GenerateVO generateVO : generateVOS) {
            sb.append("(");
            sb.append(String.format("'%s'", num ++));
            sb.append(",");
            sb.append(String.format("'%s'", generateVO.getMainType()));
            sb.append(",");
            sb.append(String.format("'%s'", generateVO.getMainTypeText()));
            sb.append(",");
            sb.append(String.format("'%s'", generateVO.getSubType()));
            sb.append(",");
            sb.append(String.format("'%s'", generateVO.getSubTypeText()));
            sb.append(",");
            sb.append(String.format("'%s'", content));
            sb.append(",");
            sb.append("NULL");
            sb.append("),");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test5() {
        File file = new File("D:\\test.txt");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append(",");
            }
            System.out.println(sb.toString());
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
