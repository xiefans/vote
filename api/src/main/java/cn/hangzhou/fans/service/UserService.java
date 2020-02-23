package cn.hangzhou.fans.service;

import cn.hangzhou.fans.pojo.User;
import cn.hangzhou.fans.exception.PasswordFailException;
import cn.hangzhou.fans.exception.UserExistException;
import cn.hangzhou.fans.exception.UserNotFoundException;

public interface UserService {

    public User login(String username, String password, String code)
            throws UserNotFoundException, PasswordFailException;

    public User register(String username, String password, String code)
            throws UserExistException;
}
