package cn.hangzhou.fans.utils;

import org.springframework.util.DigestUtils;

public class PasswordUtil {

    public static String saltPassword(String salt, String password) {
        return DigestUtils.md5DigestAsHex((password + salt).getBytes());
    }
}
