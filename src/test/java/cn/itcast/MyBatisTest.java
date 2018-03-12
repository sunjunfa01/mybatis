package cn.itcast;

import cn.itcast.mybatis.model.IdCard;
import cn.itcast.mybatis.model.User;
import cn.itcast.mybatis.util.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisTest {

    @Test
    public  void testAddUser() throws IOException {

//        构建一个user对象
        User user = new User();
        user.setUserage(22);
        user.setUsername("黑黑");
//        读取文件MYBatista核心配置文件
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
//        创建Sqlsession回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        从工厂里获取Sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        对数据库进行增删改查  (增加一条数据)
        sqlSession.insert("cn.itcast.mybatis.model.User.addUser",user);
        System.out.println(user);
//        提交事务
        sqlSession.commit();
//        关闭流
        sqlSession.close();
    }

    private  SqlSession sqlSession;

    @Before
    public  void init(){
        sqlSession = MyBatisUtils.getSession();
    }
    @Test
    public  void testUpdateUser() throws IOException {
        User user = new User();
        user.setUserid(9);
        user.setUsername("大黑不");
        user.setUserage(220);

        //        读取文件MYBatista核心配置文件
//        Reader reader = Resources.getResourceAsReader("mybatis.xml");
//        创建Sqlsession回话工厂
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        从工厂里获取Sqlsession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        对数据库进行增删改查  (增加一条数据)
//        sqlSession.update("cn.itcast.mybatis.model.User.updateUser",user);
//        提交事务
//        sqlSession.commit();
//        关闭流
//        sqlSession.close();
        sqlSession.update("cn.itcast.mybatis.model.User.updateUser",user);

    } /*getUserById*/
    @Test
    public  void  testUser(){

        User user = sqlSession.selectOne("cn.itcast.mybatis.model.User.getUserById", 9);
        System.out.println(user);
    }

    @Test
    public void  testUserAll(){
        List<User> users = sqlSession.selectList("cn.itcast.mybatis.model.User.getUserAll");
        for (User user : users) {
            System.out.println(user);

        }
    }

//    删除用户
    @Test
    public   void  testDelete(){

        sqlSession.delete("cn.itcast.mybatis.model.User.DeleteById",9);
        
    }
//获取主键自增后的值
    @Test
    public  void   testUserid(){
        User user = new User();
        user.setUsername("hao");
        user .setUserage(55);
        sqlSession.insert("cn.itcast.mybatis.model.User.KeyId",user);
        System.out.println(user);

    }
//
//    IdCard的增加数据

    @Test
    public  void  testIdCard(){
        IdCard idCard = new IdCard();
        idCard.setCity("抚州");
        idCard.setProvince("江西");
        idCard.setUsserid(2);
        sqlSession.insert("cn.itcast.mybatis.model.IdCard.addIdcard",idCard);
        System.out.println("aahh"+idCard);
        System.out.println("aahh"+idCard);
        System.out.println("aahh"+idCard);

    }
    @After
    public void  deso(){
        sqlSession.commit();
        sqlSession.close();
        System.out.println("a");

    }
    
}
