package com.smart.water.dao;

import com.smart.water.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 添加订单信息
     */
    @Insert("insert into `order` values(null,'water','1.00','1','江苏','张三')")
    int insertOrder();
    @Insert("insert into `order` values " +
            "(null, #{name}, #{price}, #{amount}, #{address}, #{buyer})")
    int addorder(Order order);

    /**
     * 修改
     */
    @Update("update `order` set name = #{name} " +
            "and price = #{price} " +
            "and amount = #{amount} " +
            "and address = #{address} " +
            "and buyer = #{buyer}" )
    int updateOrder(@Param("id") int id);

    /**
     * 删除
     */
    @Delete("delete from `order` where id = #{id}")
    int deleteOrder(@Param("id") int id);

    /**
     * 查询
     */
    @Select("select * from `order` where id = #{id}")
    Order getOrderById(@Param("id") int id);
    @Select("select * from `order` ")
    List<Order> getAllOrder();
    @Select("select * from `order` where buyer = #{name}")
    List<Order> getOrderByBuyer(@Param("buyer") String buyer);
}
