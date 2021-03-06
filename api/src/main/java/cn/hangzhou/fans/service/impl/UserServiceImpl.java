package cn.hangzhou.fans.service.impl;

import cn.hangzhou.fans.dao.UserDao;
import cn.hangzhou.fans.pojo.User;
import cn.hangzhou.fans.exception.PasswordFailException;
import cn.hangzhou.fans.exception.UserExistException;
import cn.hangzhou.fans.exception.UserNotFoundException;
import cn.hangzhou.fans.service.UserService;
import cn.hangzhou.fans.utils.PasswordUtil;
import cn.hangzhou.fans.utils.RandomStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User login(String username, String password) throws UserNotFoundException, PasswordFailException {
        User user = userDao.find(username);

        if (user == null)
            throw new UserNotFoundException();

        if (!user.getPassword().equals(PasswordUtil.saltPassword(user.getSalt(), password)))
            throw new PasswordFailException();

        return user;
    }

    @Override
    public User register(String username, String password, String code) throws UserExistException {

        User user = userDao.find(username);
        if (user != null)
            throw new UserExistException();

        String salt = RandomStringUtil.random(5);

        userDao.insert(UUID.randomUUID().toString(), username, PasswordUtil.saltPassword(salt, password), salt);
        user = userDao.find(username);
        return user;
    }
}
