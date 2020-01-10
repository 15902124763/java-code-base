package com.yarm.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: base-parent
 * @description: 测试
 * @author: yarm.yang
 * @create: 2020-01-10 17:46
 */
@Service
@Slf4j
@StopJob("stop")
public class TestService {

    public void test(String s){
        log.info("ok");
    }
}
