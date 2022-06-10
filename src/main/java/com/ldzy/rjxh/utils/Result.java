package com.ldzy.rjxh.utils;

/**
 * @Auction:XWD
 * @Data:2022/5/25
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */

public class Result<T> {
    private String code;
    private String msg;
    private T data;

    private Result() {
    }

    private Result(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        // 操作成功
        return new Result<T>(ResultCode.SUCCESS.getCode(),  ResultCode.SUCCESS.getMsg(),data);
    }

    public static <T> Result<T> errorTopUser(T data) {
        // 用户端错误
        return new Result<T>(ResultCode.ERROR_TOP_USER.getCode(), ResultCode.ERROR_TOP_USER.getMsg(),data);
    }

    public static <T> Result<T> noLogin(T data) {
        // 未登录
        return new Result<T>(ResultCode.NOT_LOGIN.getCode(), ResultCode.NOT_LOGIN.getMsg(),data);
    }

    public static <T> Result<T> noUserOrPassword(T data) {
        // 用户或者密码不正确
        return new Result<T>(ResultCode.NOT_USER_OR_PASSWORD.getCode(), ResultCode.NOT_USER_OR_PASSWORD.getMsg(),data);
    }

    public static <T> Result<T> errorUsername(T data) {
        // 用户名已存在
        return new Result<T>(ResultCode.ERROR_USER.getCode(), ResultCode.ERROR_USER.getMsg(),data);
    }

    public static <T> Result<T> errorNameOrId(T data) {
        // 用户登录异常
        return new Result<T>(ResultCode.ERROR_NAME_OR_ID.getCode(), ResultCode.ERROR_NAME_OR_ID.getMsg(),data);
    }

    public static <T> Result<T> errorUsernameLong(T data) {
        // 用户名长度最多为7
        return new Result<T>(ResultCode.ERROR_USER_LONG.getCode(), ResultCode.ERROR_USER_LONG.getMsg(),data);
    }

    public static <T> Result<T> errorInput(T data) {
        // 校验码输入错误
        return new Result<T>(ResultCode.ERROR_INPUT.getCode(), ResultCode.ERROR_INPUT.getMsg(),data);
    }

    public static <T> Result<T> failed(T data) {
        // 系统执行出错
        return new Result<T>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMsg());
    }

    public static <T> Result<T> errorWebYB(T data) {
        // 服务器内部错误
        return new Result<T>(ResultCode.ERROR_WEB_YB.getCode(), ResultCode.ERROR_WEB_YB.getMsg(),data);
    }

    public static <T> Result<T> errorDB(T data) {
        // 数据库异常
        return new Result<T>(ResultCode.ERROR_DB.getCode(), ResultCode.ERROR_DB.getMsg(),data);
    }

    public static <T> Result<T> errorParams(T data) {
        // 请求参数格式不对或类型不对或缺失参数项
        return new Result<T>(ResultCode.ERROR_PARAMS.getCode(), ResultCode.ERROR_PARAMS.getMsg(),data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
