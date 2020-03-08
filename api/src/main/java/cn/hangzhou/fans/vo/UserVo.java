package cn.hangzhou.fans.vo;

import cn.hangzhou.fans.pojo.User;

public class UserVo extends User {

    private String token;

    public static UserVo from(User user) {
        return new UserVo(user);
    }

    private UserVo(User user) {
        this.setUuid(user.getUuid());
        this.setUsername(user.getUsername());
        this.setCreateTime(user.getCreateTime());
        this.setUpdateTime(user.getUpdateTime());
        this.setRowNum(user.getRowNum());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
