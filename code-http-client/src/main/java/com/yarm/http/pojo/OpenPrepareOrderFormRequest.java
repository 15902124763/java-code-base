package com.yarm.http.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @program: base-parent
 * @description: 请求
 * @author: yarm
 * @create: 2019-11-18 10:19
 */
public class OpenPrepareOrderFormRequest {

    @NotBlank(message = "来源系统不能为空！")
    @JsonProperty(value = "from_system")
    @JSONField(name = "from_system")
    private String fromSystem;

    @NotBlank(message = "支付渠道不能为空！")
    @JsonProperty(value = "pay_channel")
    @JSONField(name = "pay_channel")
    private String payChannel;

    @NotBlank(message = "支付方式不能为空！")
    @JsonProperty(value = "pay_type")
    @JSONField(name = "pay_type")
    private String payType;

    @JsonProperty(value = "ono_type")
    @JSONField(name = "ono_type")
    private byte onoType;

    @NotBlank(message = "业务方订单号不能为空！")
    private String ono;

    @Min(value = 1, message = "支付金额不能小于1分！")
    @Max(value = 999999999, message = "支付金额不能大于999999999！")
    private Integer amount;

    private String ext;

    private String subject;

    @Min(value = 5, message = "交易过期时间不能小于5分钟！")
    @Max(value = 1440, message = "交易过期时间不能大于1440分钟！")
    @JsonProperty(value = "expire_time")
    @JSONField(name = "expire_time")
    private Integer expireTime;

    @NotBlank(message = "回调地址不能为空！")
    @JsonProperty(value = "callback_url")
    @JSONField(name = "callback_url")
    private String callbackUrl;

    private String openid;

    @NotBlank(message = "业务方用户ID不能为空！")
    private String cpid;

    private String ip;

    @JsonProperty(value = "trade_no")
    @JSONField(name = "trade_no")
    private String tradeNo;

    @JsonProperty(value = "trace_id")
    @JSONField(name = "trace_id")
    private String traceId;

    //汇付天下支付宝和微信小程序使用，支付成功后跳转到的h5页面地址
    @JsonProperty(value = "ret_url")
    @JSONField(name = "ret_url")
    private String retUrl;

    //微信H5支付必传场景信息
    @JsonProperty(value = "scene_info")
    @JSONField(name = "scene_info")
    private String sceneInfo;

    @NotBlank(message = "签名字段不能为空！")
    @Length(min = 32, max = 32,message = "签名字段必须32位！")
    private String sign;
}