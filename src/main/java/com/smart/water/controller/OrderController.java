package com.smart.water.controller;

import com.smart.water.entity.Order;
import com.smart.water.service.OrderService;
import com.smart.water.vo.ResultVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @ResponseBody
    @GetMapping("/all")
    public ResultVo getAllOrder() {
        return ResultVo.success(orderService.getAllOrder());
    }
    @ResponseBody
    @GetMapping("/info/s/{id}")
    public ResultVo getOrderById(@PathVariable int id){
        return ResultVo.success(orderService.getOrderById(id));
    }
    @ResponseBody
    @GetMapping("/info/b/{buyer}")
    public ResultVo getOrderByBuyer(@PathVariable String buyer){
        return ResultVo.success(orderService.getOrderByBuyer(buyer));
    }
    @ResponseBody
    @PostMapping("/add")
    public ResultVo addOrder(@RequestBody Order order){
        return ResultVo.success(orderService.addOrder(order));
    }
    @ResponseBody
    @GetMapping("/update/{id}")
    public ResultVo updateOrder(@PathVariable int id){
        return ResultVo.success();
    }
    @ResponseBody
    @PutMapping("/update/{id}")
    public String updateById(@PathVariable int id){
        orderService.updateOrder(id);
        return "update done";
    }
    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        orderService.deleteOrder(id);
        return "delete done";
    }
}
