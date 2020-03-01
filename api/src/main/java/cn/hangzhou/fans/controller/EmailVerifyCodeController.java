package cn.hangzhou.fans.controller;

import cn.hangzhou.fans.exception.EmailVerifyCodeFailException;
import cn.hangzhou.fans.exception.EmailVerifyCodeSendFailException;
import cn.hangzhou.fans.exception.EmailVerifyCodeTimeLimitException;
import cn.hangzhou.fans.global.bean.Result;
import cn.hangzhou.fans.service.EmailVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/verify/email")
public class EmailVerifyCodeController {

    @Autowired
    private EmailVerifyService emailVerifyService;

    @RequestMapping("/getCode")
    public Result getCode(String email) {
        try {
            emailVerifyService.sendCode(email);
        }  catch (EmailVerifyCodeSendFailException e) {
            return Result.fail(e);
        }

        return Result.success(null);
    }

    @RequestMapping("/verify")
    public Result verify(String email, String code) {
        try {
            return Result.success(emailVerifyService.verifyCode(email, code));
        } catch (EmailVerifyCodeFailException e) {
            return Result.fail(e);
        } catch (EmailVerifyCodeTimeLimitException e) {
            return Result.fail(e);
        }
    }
}
