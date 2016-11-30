package cn.my.dao;

import cn.my.user.User;

public interface UserDao {
    public abstract void addUser(User user);
    public abstract void updateUser(User user);
    public abstract void deleteUser(User user);
    public abstract User getUser(int userId);
    public abstract User searchUser(String name);
}
