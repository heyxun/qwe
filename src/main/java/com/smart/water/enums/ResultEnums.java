package com.smart.water.enums;

import lombok.Getter;

@Getter
public enum ResultEnums {

    PARAM_ERROR(1000, "参数错误"),
    PHONE_REGISTERED(1002,"该手机已经注册过"),
    PHONE_NO_BLANK(1003,"手机号码不能为空"),
    PASSWORD_NO_BLANK(1004,"密码不能为空"),
    PASSWORD_NO_MATCH(1005,"密码不匹配"),

    LOGIN_FAIL(1007, "用户名或者密码不正确"),
    CODE_LOGIN_FAIL(1107, "验证码不正确 请重新输入"),
    PASSWORD_LENGTH_ERROR(1108, "密码位数不足8-20位"),

    REGISTER_FAIL(1008, "用户名称已经存在"),
    BAD_REQUEST(1009,"请求参数错误"),
    OTHER_EXCEPTION(1010,"未知异常"),
    NULL_POINTER(1011,"空指针异常"),


    ;
    private final Integer code;

    private final String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
