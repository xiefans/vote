package cn.hangzhou.fans.exception;

import cn.hangzhou.fans.constant.ResultCodeConstant;

public class UserNotFoundException extends ResultException {

    public UserNotFoundException() {
        super(ResultCodeConstant.USER_NOT_FOUND, "用户不存在");
    }
}
