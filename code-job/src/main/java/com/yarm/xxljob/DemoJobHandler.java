package com.yarm.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program: hds-community-service
 * @description: 任务Handler示例（Bean模式）
 * @author: yarm
 * @create: 2019-12-02 17:23
 */
@JobHandler(value="demoJobHandler")
@Component
@Slf4j
public class DemoJobHandler extends IJobHandler {

    /**
     * @Description: 这里可以写业务代码
     * @Param: [param]
     * @Return: com.xxl.job.core.biz.model.ReturnT<java.lang.String>
     * @Author: yarm.yang
     * @Date: 2020/2/12 12:12
     */
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("demo xxl job");

        for (int i = 0; i < 5; i++) {
            log.info("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        return SUCCESS;
    }
}