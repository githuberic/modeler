package com.lgq.jbasic.dynamicproxy.e1;

/**
 * @author lgq
 */
public interface UserManager {

    public void addUser(String username, String password);

    public void delUser(int userId);

    public String findUserById(int userId);

    public void modifyUser(int userId, String username, String passwordString);
}
