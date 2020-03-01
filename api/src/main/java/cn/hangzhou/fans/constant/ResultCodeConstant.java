package cn.hangzhou.fans.constant;

public interface ResultCodeConstant {

    public Integer SUCCESS = 200;

    public Integer FAIL_UNKNOWN = -1;

    // 用户
    public Integer USER_NOT_FOUND = 300;
    public Integer USER_PASSWORD_FAIL = 301;
    public Integer USER_EXIST = 301;

    // 验证码
    public Integer VERIFY_CODE_SEND_FAIL = 400;
}
