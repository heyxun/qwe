package com.smart.water.service.impl;

import com.smart.water.dao.OrderMapper;
import com.smart.water.entity.Order;
import com.smart.water.service.OrderService;
import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Lazy
@Component
@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {
    //导入配置文件
//    String config = "mybatis-config.xml";
//    InputStream inputStream = Resources.getResourceAsStream(config);
//
//    public OrderServiceImpl() throws IOException {
//    }
    @Resource(name = "orderMapper")
    private OrderMapper orderMapper;
    @Override
    public int addOrder(Order order){
        return orderMapper.addorder(order);
    }
    @Override
    public int deleteOrder(int id) {
        return orderMapper.deleteOrder(id);
    }
    @Override
    public int updateOrder(int id){
        return orderMapper.updateOrder(id);
    }
    @Override
    public List<Order> getAllOrder(){
        return orderMapper.getAllOrder();
    }
    @Override
    public Order getOrderById(int id){
        return orderMapper.getOrderById(id);
    }
    @Override
    public List<Order> getOrderByBuyer(String buyer){
        return orderMapper.getOrderByBuyer(buyer);
    }
}
