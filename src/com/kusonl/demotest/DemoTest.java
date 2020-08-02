package com.kusonl.demotest;


import com.kusonl.domain.User;
import com.kusonl.domain.UserExample;
import com.kusonl.mapper.UserMapper;
import com.kusonl.tools.MyBatisTools;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DemoTest {

    // 按PK搜索
    @Test
    public void fun1() {
        SqlSession session = MyBatisTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user1 = mapper.selectByPrimaryKey(1);

        System.out.println(user1);

        List<User> users = mapper.selectByExample(null);

        for (User user : users) {
            System.out.println(user);
        }
    }


    // 模糊查询、绝对查询
    @Test
    public void fun2() {
        SqlSession session = MyBatisTools.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        // 模糊查询
        criteria.andUsernameLike("a%");
        criteria.andUsernameEqualTo("boss");

        List<User> users = userMapper.selectByExample(userExample);

        for (User user : users) {
            System.out.println(user);
        }

    }
}
