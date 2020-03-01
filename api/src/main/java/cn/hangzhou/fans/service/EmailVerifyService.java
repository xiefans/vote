package cn.hangzhou.fans.service;

import cn.hangzhou.fans.exception.EmailVerifyCodeFailException;
import cn.hangzhou.fans.exception.EmailVerifyCodeSendFailException;
import cn.hangzhou.fans.exception.EmailVerifyCodeTimeLimitException;
import org.springframework.stereotype.Service;

@Service
public interface EmailVerifyService {

    public void sendCode(String email) throws EmailVerifyCodeSendFailException;
    public Boolean verifyCode(String email, String code) throws EmailVerifyCodeFailException, EmailVerifyCodeTimeLimitException;
}
