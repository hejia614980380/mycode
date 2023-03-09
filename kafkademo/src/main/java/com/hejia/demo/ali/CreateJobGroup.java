package com.hejia.demo.ali;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.outboundbot.model.v20191226.CreateJobGroupRequest;
import com.aliyuncs.outboundbot.model.v20191226.CreateJobGroupResponse;
import com.aliyuncs.profile.DefaultProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *  任务组(JobGroup)是任务的逻辑分组,可以根据业务实际情况,按照时间或者人群等维度划分.
 */
public class CreateJobGroup {
    public static void main(String[] args) throws ClientException {
        DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", "LTAI5t61GMWXodzpjLrLvtNb", "ooPsarlVQmgPPf35XkT8AQQKqBN27S");
        IAcsClient client = new DefaultAcsClient(profile);
        CreateJobGroupRequest request = new CreateJobGroupRequest();
        request.setJobGroupName("第二个作业组");
        request.setInstanceId("9d4cd2b1-b456-4b42-a253-829de99e23a7");
        request.setScriptId("b2a5a687-4e26-4de8-9504-925080804f45");
        request.setStrategyJson(JSON.toJSONString(createStrategy()));
        try {
            CreateJobGroupResponse response = client.getAcsResponse(request);
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
     * AssignJobs接口也可以传入Strategy参数.
     * Strategy优先级为: AssignJobs > CreateJobGroup.
     * @return
     */
    private static JSONObject createStrategy() {
        JSONObject strategy = new JSONObject();
        strategy.put("maxAttemptsPerDay", 3); //号码每天最大呼叫次数
        strategy.put("minAttemptInterval", 10); //未接通情况下的重试时间间隔，单位为分钟
        strategy.put("name", UUID.randomUUID().toString()); //策略名称
        strategy.put("startTime", System.currentTimeMillis()); //开始时间戳
        strategy.put("endTime", System.currentTimeMillis() + 60 * 60 * 1000L); //结束时间戳
        List<JSONObject> workingTimes = new ArrayList<>(); // 可呼出的时间窗口，24小时制
        JSONObject workingTime0 = new JSONObject();
        workingTime0.put("beginTime", "08:00:00");
        workingTime0.put("endTime", "12:00:00");
        JSONObject workingTime1 = new JSONObject();
        workingTime1.put("beginTime", "13:00:00");
        workingTime1.put("endTime", "22:00:00");
        workingTimes.add(workingTime0);
        workingTimes.add(workingTime1);
        strategy.put("workingTime", workingTimes);
        return strategy;
    }
}
