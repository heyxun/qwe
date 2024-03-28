package com.smart.water.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("雇员信息类")
@Component
public class Employee {
    @ApiModelProperty("雇员id")
    private Long id;
    @ApiModelProperty("雇员年龄")
    private int age;
    @ApiModelProperty("雇员姓名")
    private String name;
    @ApiModelProperty("雇员密码")
    private String pwd;
    @ApiModelProperty("雇员所在部门")
    private String depn;
    @ApiModelProperty("雇员薪水")
    private double sal;
}
