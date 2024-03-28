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
@ApiModel(value = "博文实体类")
public class Blog {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("博文标题")
    private String title;
    @ApiModelProperty("博文内容")
    private String content;
    @ApiModelProperty("博文作者")
    private String author;
    @ApiModelProperty("博文发布时间")
    private String time;
    @ApiModelProperty("博文更新时间")
    private String updateTime;
}
