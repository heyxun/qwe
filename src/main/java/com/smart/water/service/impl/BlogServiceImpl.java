package com.smart.water.service.impl;

import com.smart.water.dao.BlogMapper;
import com.smart.water.entity.Blog;
import com.smart.water.service.BlogService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Lazy
@Component
@Service("BlogServiceImpl")
public class BlogServiceImpl implements BlogService {
    //导入配置文件
//    String config = "mybatis-config.xml";
//    InputStream inputStream = Resources.getResourceAsStream(config);
//    public BlogServiceImpl() throws IOException {
//    }
//    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    @Resource(name = "blogMapper")
    private BlogMapper blogMapper;

    @Override
    public int delete(int id) {
        return blogMapper.delete(id);
//        int num = 0;
//        try (SqlSession session = sqlSessionFactory.openSession()){
//            num = session.delete("delete",id);
//            session.commit();
//        }catch (Exception e){e.printStackTrace();}
//        return num;
    }

    @Override
    public List<Blog> getAllByAuthorAndTime(String author, String time) {
        return blogMapper.getAllByAuthorAndTime(author,time);
    }
}
