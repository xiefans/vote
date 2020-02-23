package cn.hangzhou.fans.exception;

import cn.hangzhou.fans.constant.ResultCodeConstant;

public class PasswordFailException extends ResultException {

    public PasswordFailException() {
        super(ResultCodeConstant.USER_PASSWORD_FAIL, "密码错误!");
    }
}
