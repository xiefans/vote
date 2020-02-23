package cn.hangzhou.fans.global.bean;

import cn.hangzhou.fans.constant.ResultCodeConstant;
import cn.hangzhou.fans.exception.ResultException;

public class Result {

    private Integer code;
    private String message;
    private Object content;

    public static Result success(Object content) {
        Result result = new Result(ResultCodeConstant.SUCCESS, "请求成功", content);
        return result;
    }

    public static Result success(String message, Object content) {
        Result result = new Result(ResultCodeConstant.SUCCESS, message, content);
        return result;
    }

    public static Result fail(ResultException exception) {
        Result result = new Result(exception.getCode(), exception.getMessage(), null);
        return result;
    }

    private Result(Integer code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getContent() {
        return content;
    }
}
