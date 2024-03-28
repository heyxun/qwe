package com.smart.water;

import com.smart.water.entity.Blog;
import com.smart.water.dao.BlogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SmartWaterApplicationTests {

    @Resource
    private BlogMapper blogMapper;


    @Test
    void contextLoads() {
        List<Blog> blogList = blogMapper.getAll();
        System.out.println(blogList);
    }

    @Test
    void testInsert(){
        Blog blog = Blog.builder()
                .title("bbb")
                .content("bbbbbbb")
                .author("李四")
                .build();
        int i = blogMapper.insert(blog);

    }

}
