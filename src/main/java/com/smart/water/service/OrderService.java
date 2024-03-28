package com.smart.water.service;

import com.smart.water.entity.Order;

import java.util.List;

public interface OrderService {
    int addOrder(Order order);
    int deleteOrder(int id);
    int updateOrder(int id);
    List<Order> getAllOrder();
    Order getOrderById(int id);
    List<Order> getOrderByBuyer(String buyer);
}
