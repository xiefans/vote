package cn.hangzhou.fans.exception;

import cn.hangzhou.fans.constant.ResultCodeConstant;

public class EmailVerifyCodeTimeLimitException extends ResultException {
    public EmailVerifyCodeTimeLimitException() {
        super(ResultCodeConstant.VERIFY_CODE_LIMIT_TIME, "验证码已过期");
    }
}
