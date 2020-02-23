package cn.hangzhou.fans.exception;

import cn.hangzhou.fans.constant.ResultCodeConstant;

public class UserExistException extends ResultException {
    public UserExistException() {
        super(ResultCodeConstant.USER_EXIST, "用户已经存在");
    }
}
