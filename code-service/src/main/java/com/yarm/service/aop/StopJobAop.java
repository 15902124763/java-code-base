package com.yarm.service.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yarm.service.StopJob;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: base-parent
 * @description: 关闭job切面
 * @author: yarm.yang
 * @create: 2020-01-10 16:54
 */
@Aspect
@Component
@Slf4j
public class StopJobAop {

    // 切点
    @Pointcut("@annotation(com.yarm.service.StopJob)")
    public void pointCut(){}

    @Around(value = "pointCut() && @annotation(stopJob)", argNames = "joinPoint,stopJob")
    public Object around(ProceedingJoinPoint joinPoint, StopJob stopJob) throws Throwable {

        // 是否开启
        boolean isSign = false;

        String value = stopJob.value();

        log.info("annacation value:{}", value);

        Object proceedResult = null;
        if(isSign){
            // 开启执行目标方法
            proceedResult = joinPoint.proceed(joinPoint.getArgs());
        }else {
            return null;
        }
        // 返回
        return proceedResult;
    }

    /**
     * @Description: 获取请求参数
     * @Param: [joinPoint]
     * @Return: java.util.Map<java.lang.String,java.lang.String>
     * @Author: yarm.yang
     * @Date: 2020/1/10 17:51
     */
    private static Map<String, String> getReqParam(ProceedingJoinPoint joinPoint) {
        // 参数值
        Object[] args = joinPoint.getArgs();
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String[] parameterNames = pnd.getParameterNames(method);

        Map<String, Object> paramMap = new HashMap<>(32);
        for (int i = 0; i < parameterNames.length; i++) {
            if(i == 0){
                paramMap.put("p", args[i]);
            }else {
                // 约定好取第一个参数 直接过滤
                continue;
                // paramMap.put(parameterNames[i], args[i]);
            }
        }

        Object p = paramMap.get("p");
        Map<String, Object> tempMap = JSON.parseObject(JSON.toJSONString(p),new TypeReference<Map<String,Object>>(){});

        // 返回map
        Map<String, String> resultMap = new HashMap<>(32);
        tempMap.forEach((k,v) -> {
            resultMap.put(k, v + "");
        });

        return resultMap;
    }
}
