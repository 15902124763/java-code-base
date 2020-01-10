package com.yarm.controller;

import com.yarm.common.Result;
import com.yarm.service.TestService;
import com.yarm.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/7
 * Time:15:43
 * Des:
 */
@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @ApiOperation(value = "新建用户表", notes = "新建用户表", response = Result.class)
    @RequestMapping(value = "/create/table",method = {RequestMethod.GET})
    public Result<Boolean> createTable(){
        Result<Boolean> result = new Result<>();
        this.userService.createTable();
        result.setData(true);
        return result;
    }


    @ApiOperation(value = "测试", notes = "测试", response = Result.class)
    @RequestMapping(value = "/test/test",method = {RequestMethod.GET})
    public Result<Boolean> test(){
        Result<Boolean> result = new Result<>();
        this.testService.test("good");
        result.setData(true);
        return result;
    }
}