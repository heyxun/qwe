package com.smart.water.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "订单实体类")
public class Order {
    @ApiModelProperty("订单号")
    private int id;
    @ApiModelProperty("商品名")
    private String name;
    @ApiModelProperty("商品单价")
    private double price;
    @ApiModelProperty("商品数量")
    private int amount;
    @ApiModelProperty("配送地址")
    private String address;
    @ApiModelProperty("购买者姓名")
    private String buyer;
}
