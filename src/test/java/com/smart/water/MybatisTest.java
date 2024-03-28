package com.smart.water;

import com.smart.water.dao.OrderMapper;
import com.smart.water.entity.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class MybatisTest {
    //测试业务之模板
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口对象
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        //测试功能
        int result = mapper.insertOrder();
        //提交事务
        sqlSession.commit();
        System.out.println("result:"+result);
    }

    //测试增删改查
    @Test
    public void testCRUD() throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        //mappers.updateOrder();
        //mappers.deleteOrder();
        List<Order> l = mapper.getOrderByBuyer("张三");
        l.forEach(order -> System.out.println(order));
//        List<Order> list = mappers.getAllOrder();
//        list.forEach(order -> System.out.println(order));
    }
}
