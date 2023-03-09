package com.hejia.demo.ali;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.outboundbot.model.v20191226.AssignJobsRequest;
import com.aliyuncs.outboundbot.model.v20191226.AssignJobsResponse;
import com.aliyuncs.profile.DefaultProfile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * 可使用AssignJobs循环多次向同一任务组下发任务，每次下发任务数建议25个job.
 */
public class AssignJobs {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", "LTAI5t61GMWXodzpjLrLvtNb", "ooPsarlVQmgPPf35XkT8AQQKqBN27S");
        IAcsClient client = new DefaultAcsClient(profile);
        AssignJobsRequest request = new AssignJobsRequest();
        request.setInstanceId("9d4cd2b1-b456-4b42-a253-829de99e23a7");
        request.setJobGroupId("dc360acc-b6cd-49ea-9ffd-1dc7e96cda21");
        request.setJobsJsons(createJobsJson());
        try {
            AssignJobsResponse response = client.getAcsResponse(request);
            System.out.println(JSON.toJSONString(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }
    /**
     *  JobsJson.N是个List，每个JobJson对应一个联系人(contact)。
     * @return
     */
    private static List<String> createJobsJson() {
        JSONObject contact = new JSONObject();
        contact.put("phoneNumber", "15972178732");
        contact.put("honorific", "何先生");
        contact.put("name", "何佳");
        contact.put("referenceId", UUID.randomUUID().toString());
        List<JSONObject> extras = new ArrayList<>();
        extras.add(new JSONObject().fluentPut("key", "name").fluentPut("value", "何佳"));
        extras.add(new JSONObject().fluentPut("key", "occurTime").fluentPut("value", "2022年3月17日20时06分"));
        extras.add(new JSONObject().fluentPut("key", "station").fluentPut("value", "垃圾回收站"));
        extras.add(new JSONObject().fluentPut("key", "question").fluentPut("value", "垃圾满溢"));
        extras.add(new JSONObject().fluentPut("key", "level").fluentPut("value", "一级"));
        JSONObject job = new JSONObject();
        job.put("contacts", Collections.singletonList(contact));
        job.put("extras", extras);
        List<String> jobs = new ArrayList<>();
        jobs.add(JSON.toJSONString(job));
        return jobs;
    }
}
