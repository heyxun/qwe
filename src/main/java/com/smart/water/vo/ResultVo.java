package com.smart.water.vo;

import com.smart.water.enums.ResultEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Builder
@ApiModel("响应参数")
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo<T> implements Serializable {

    @ApiModelProperty(value = "响应状态码", example = "1", dataType = "Integer")
    private int code;

    // 是否成功标识.true表示成功,false表示失败
    @ApiModelProperty("success标识,true表示成功,false表示失败")
    private boolean success = false;

    // 操作成功时需要响应给客户端的响应数据
    @ApiModelProperty("响应信息")
    private String msg;

    @ApiModelProperty("响应数据")
    private T data;
    public static <T> ResultVo success(T data) {
        ResultVo<T> resultVO = new ResultVo<>();
        resultVO.setData(data);
        resultVO.setSuccess(true);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static <T> ResultVo error(T data) {
        ResultVo<T> resultVO = new ResultVo<>();
        resultVO.setData(data);
        resultVO.setCode(-1);
        resultVO.setMsg("失败");
        return resultVO;
    }

    public static ResultVo error(ResultEnums resultEnums) {
        ResultVo resultVO = new ResultVo<>();
        resultVO.setCode(resultEnums.getCode());
        resultVO.setMsg(resultEnums.getMessage());
        return resultVO;
    }

    public static ResultVo error(ResultEnums resultEnums, String message) {
        ResultVo resultVO = new ResultVo<>();
        resultVO.setCode(resultEnums.getCode());
        resultVO.setMsg(message);
        return resultVO;
    }

    public static ResultVo error(Integer code, String message) {
        ResultVo resultVO = new ResultVo<>();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        return resultVO;
    }
}
