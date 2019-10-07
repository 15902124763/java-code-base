package com.yarm.service;

import com.yarm.pojo.UserDO;
import org.apache.catalina.User;

import java.util.List;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/7
 * Time:15:49
 * Des:
 */
public interface UserService {
    final int BATCH_SIZE = 100;
    String createTable();
    void save(UserDO userDO);
    List<User> select(int pageIndex, int pageSize);
    void batchSave(List<UserDO> list);
}