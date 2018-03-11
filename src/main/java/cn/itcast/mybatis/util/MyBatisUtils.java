package cn.itcast.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtils {
//封装一个类  获取 sqlsessionFactory 和  sqlsession
    private static SqlSessionFactory sqlSessionFactory;
    static {

        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//获取session工厂
    public  static  SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
//    获取session
    public  static SqlSession getSession(){
       return sqlSessionFactory.openSession();
    }
}
