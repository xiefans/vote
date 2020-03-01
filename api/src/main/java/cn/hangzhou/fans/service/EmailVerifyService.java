package cn.hangzhou.fans.service;

import cn.hangzhou.fans.exception.EmailVerifyCodeFailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Service
public interface EmailVerifyService {

    public void sendCode(String email) throws EmailVerifyCodeFailException;
}
