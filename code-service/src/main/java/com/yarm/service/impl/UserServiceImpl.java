package com.yarm.service.impl;

import com.yarm.pojo.UserDO;
import com.yarm.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/7
 * Time:15:49
 * Des:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String createTable() {
        String sql = "CREATE TABLE `t_user_1` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `user_name` varchar(255) DEFAULT NULL,\n" +
                "  `pass_word` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;\n" +
                "\n";
        jdbcTemplate.execute(sql);
        return "ok";
    }

    @Override
    public void save(UserDO userDO) {

    }

    @Override
    public List<User> select(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public void batchSave(List<UserDO> list) {
        String sql =
                "INSERT INTO USER (USER_NAME,PASS_WORD) VALUES (?,?)" ;
        List<Object[]> args = this.convertList(list);
        int fromIndex = 0; int toIndex = BATCH_SIZE;
        while (fromIndex != args.size()) {
            if (toIndex > args.size()) {
                toIndex = args.size();
            }
            this.jdbcTemplate.batchUpdate(sql,args.subList(fromIndex, toIndex));
            fromIndex = toIndex;
            toIndex += BATCH_SIZE;
            if (toIndex > args.size())
                toIndex = args.size();
        }
    }

    private List<Object[]> convertList(List<UserDO> list){
        List<Object[]> listObj = new ArrayList<>();
        list.stream().forEach(userDO -> {
            Object[] obj;
            obj = new Object[]{
                    userDO.getId(),
                    userDO.getUser_name(),
                    userDO.getPass_word()
            };
            listObj.add(obj);
        });
        return listObj;
    }
}