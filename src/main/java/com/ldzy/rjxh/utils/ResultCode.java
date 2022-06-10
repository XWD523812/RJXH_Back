package com.ldzy.rjxh.utils;


public enum ResultCode implements ErrorCode{
    SUCCESS("00000","操作成功"),
    ERROR_TOP_USER("A0001","用户端错误"),
    NOT_LOGIN("A0101","未登录"),
    ERROR_USER("A0111","用户已存在"),
    NOT_USER_OR_PASSWORD("A0102","用户名或者密码不对"),
    ERROR_NAME_OR_ID("A0200","用户登录异常"),
    ERROR_USER_LONG("A0201","用户名长度最多为七个字"),
    ERROR_INPUT("A0130","校验码输入错误"),
    ERROR("B0001","系统执行出错 "),
    ERROR_WEB_YB("B0100","服务器内部错误！"),
    ERROR_DB("B0200","数据库异常"),
    ERROR_PARAMS("B0201","请求参数格式不对或类型不对或缺失参数项！");

    private String code;
    private String msg;

    ResultCode() {
    }

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }


}
