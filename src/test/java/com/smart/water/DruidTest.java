package com.smart.water;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
public class DruidTest {
    @Resource
    private DataSource dataSource;
    @Test
    void test(){
        System.out.println(dataSource.getClass());
    }
}
