package com.yarm.http.test;

import com.yarm.http.pojo.OpenPrepareOrderFormRequest;
import com.yarm.http.pojo.Request;
import com.yarm.http.request.Pay;

/**
 * @program: base-parent
 * @description: 测试
 * @author: yarm
 * @create: 2019-11-18 11:17
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Request<OpenPrepareOrderFormRequest> request = new Request<>();
        OpenPrepareOrderFormRequest openPrepareOrderFormRequest = new OpenPrepareOrderFormRequest();

        // 接口入参

        // 接口签名

        request.setData(openPrepareOrderFormRequest);
        request.setHost("http://127.0.0.1:9999");
        request.setUri("/open/api/pay/prepareOrder");
        Pay.pay(request);
    }
}