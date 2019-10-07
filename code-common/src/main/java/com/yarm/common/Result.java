package com.yarm.common;

import lombok.Data;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/7
 * Time:16:07
 * Des:
 */
@Data
public class Result<T> {
    public Result(){
        this.code = 200;
        this.msg ="ok";
        this.status = true;
    }
    private T data;
    private boolean status;
    private int code;
    private String msg;
}