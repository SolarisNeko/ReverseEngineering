package com.kusonl.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTools {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        String config = "MyBatis.conf.xml";
        InputStream resourceAsStream = null;

        try {
            resourceAsStream = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

    }

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }

    public void closeSession(SqlSession sqlSession) {

        if (sqlSession != null) { // 先判NPE, 如果不写, 以后凌晨自己爬起来加班背锅
            sqlSession.close();
        }
    }
}
