package cn.hangzhou.fans.service.impl;

import cn.hangzhou.fans.exception.EmailVerifyCodeFailException;
import cn.hangzhou.fans.service.EmailVerifyService;
import cn.hangzhou.fans.utils.EmailVerifyCodeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EmailVerifyServiceImpl implements EmailVerifyService {

    @Override
    public void sendCode(String email) throws EmailVerifyCodeFailException {
        EmailVerifyCodeUtil.sendCode(EmailVerifyCodeUtil.generateCode(), email);
    }
}
