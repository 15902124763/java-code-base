package com.yarm.pojo;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/7
 * Time:16:35
 * Des:
 */
@Data
public class UserDO implements RowMapper<UserDO> {
    private int id;
    private String user_name;
    private String pass_word;
    @Override
    public UserDO mapRow(ResultSet resultSet, int i) throws SQLException {
        UserDO user = new UserDO();
        user.setId(resultSet.getInt("id"));
        user.setUser_name(resultSet.getString("user_name"));
        user.setPass_word(resultSet.getString("pass_word"));
        return user;
    }
}