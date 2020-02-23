package cn.hangzhou.fans.dao;

import cn.hangzhou.fans.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    public User find(String username);
    public void insert(@Param("uuid") String uuid,
                       @Param("username") String username,
                       @Param("password") String password);
}
