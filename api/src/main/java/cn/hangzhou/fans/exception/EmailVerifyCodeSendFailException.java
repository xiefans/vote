package cn.hangzhou.fans.exception;

import cn.hangzhou.fans.constant.ResultCodeConstant;

public class EmailVerifyCodeSendFailException extends ResultException {
    public EmailVerifyCodeSendFailException() {
        super(ResultCodeConstant.VERIFY_CODE_SEND_FAIL, "验证码发送失败");
    }
}
