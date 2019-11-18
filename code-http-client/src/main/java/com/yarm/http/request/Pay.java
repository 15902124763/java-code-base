package com.yarm.http.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yarm.http.pojo.HttpClientResult;
import com.yarm.http.pojo.OpenPrepareOrderFormRequest;
import com.yarm.http.pojo.Request;
import com.yarm.http.util.HttpUtil;

import javax.security.auth.kerberos.KerberosKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: base-parent
 * @description: 预支付
 * @author: yarm
 * @create: 2019-11-18 10:55
 */
public class Pay {
    public static void pay(Request<OpenPrepareOrderFormRequest> request) throws Exception {
        //字符串转map
        String jsonString = JSONObject.toJSONString(request.getData());
        JSONObject  jsonObject = JSONObject.parseObject(jsonString);
        Map<String,Object> map = (Map)jsonObject;
        HashMap<String, String> reqHashMap = new HashMap();
        map.forEach((k,v)->{
            reqHashMap.put(k, v + "");
        });
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");
        HttpClientResult httpClientResult = HttpUtil.doPost(request.getHost() + request.getUri(), headers, reqHashMap);
        System.out.println(httpClientResult);
    }
}