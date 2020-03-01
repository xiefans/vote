package cn.hangzhou.fans.exception;

import cn.hangzhou.fans.constant.ResultCodeConstant;

public class EmailVerifyCodeFailException extends ResultException {
    public EmailVerifyCodeFailException() {
        super(ResultCodeConstant.VERIFY_CODE_SEND_FAIL, "验证码发送失败");
    }
}
