package cn.hangzhou.fans.service.impl;

import cn.hangzhou.fans.exception.EmailVerifyCodeFailException;
import cn.hangzhou.fans.exception.EmailVerifyCodeSendFailException;
import cn.hangzhou.fans.exception.EmailVerifyCodeTimeLimitException;
import cn.hangzhou.fans.service.EmailVerifyService;
import cn.hangzhou.fans.utils.EmailVerifyCodeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EmailVerifyServiceImpl implements EmailVerifyService {

    private JedisPool jedisPool = new JedisPool();

    @Override
    public void sendCode(String email) throws EmailVerifyCodeSendFailException {
        String code = EmailVerifyCodeUtil.generateCode();
        Jedis jedis = jedisPool.getResource();
        jedis.setex(email, 300, code);
        jedis.close();
        EmailVerifyCodeUtil.sendCode(code, email);
    }

    @Override
    public Boolean verifyCode(String email, String code) throws EmailVerifyCodeFailException, EmailVerifyCodeTimeLimitException {
        Jedis jedis = jedisPool.getResource();
        if (!jedis.exists(email)) {
            jedis.close();
            throw new EmailVerifyCodeTimeLimitException();
        }

        if (!jedis.get(email).equals(code)) {
            jedis.close();
            throw new EmailVerifyCodeFailException();
        }

        jedis.del(email);
        jedis.close();
        return true;
    }


}
