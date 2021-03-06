package cn.hangzhou.fans.controller;

import cn.hangzhou.fans.pojo.User;
import cn.hangzhou.fans.exception.ResultException;
import cn.hangzhou.fans.global.bean.Result;
import cn.hangzhou.fans.service.EmailVerifyService;
import cn.hangzhou.fans.service.UserService;
import cn.hangzhou.fans.utils.RandomStringUtil;
import cn.hangzhou.fans.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailVerifyService emailVerifyService;

    @RequestMapping("/login")
    public Result login(String username, String password) {
        try {
            User user = userService.login(username, password);
            UserVo userVo = UserVo.from(user);
            return Result.success(userVo);
        } catch (ResultException e) {
            return Result.fail(e);
        }
    }

    @RequestMapping("/register")
    public Result register(String username, String password, String code) {
        try {
            emailVerifyService.verifyCode(username, code);
            User user = userService.register(username, password, code);
            UserVo userVo = UserVo.from(user);
            userVo.setToken(RandomStringUtil.random(10));
            return Result.success(userVo);
        } catch (ResultException e) {
            return Result.fail(e);
        }
    }
}
