package com.crazy.article.result.util;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Date;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-7-28 10:49
 */
public class SmsUtil {

    private final String KEY = "LTAIl6WlNc1gN3bG";
    private final String SECRET = "OSqX1hyF75SsYcBm7Pr9Ljbu8RLUXM";

    public boolean sendSms(String ip, String app, String errormsg) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", KEY, SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "13895691709");
        request.putQueryParameter("SignName", "不思量");
        request.putQueryParameter("TemplateCode", "SMS_172883333");
        // 实际需要的值，json格式
        // 亲爱的小仙女，早上好 今天的天气：${weather}, 温度：${tem}, 平均温度：${avtmp}, 天气状况：${fen},具体${title}

        Sms sms = new Sms();
        sms.setAvtmp(app);
        sms.setFen(ip);
        sms.setTem("sdf");
        sms.setTitle("我爱你");
        sms.setWeather("sdfa");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(sms));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new SmsUtil().sendSms("180_76_234_60", "油烟项目", "设备离线");
    }
}
