package com.lgq.jbasic.dynamicproxy.e1;

/**
 * @author lgq
 */
public class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String username, String password) {
        //checkSecurity();
        System.out.println("-------------userManager.add()---------");
    }

    @Override
    public void delUser(int userId) {
        //checkSecurity();
        System.out.println("-------------userManager.delUser()---------");
    }

    @Override
    public String findUserById(int userId) {
        //checkSecurity();
        System.out.println("-------------userManager.findUserById()---------");
        return "张三";
    }

    @Override
    public void modifyUser(int userId, String username, String passwordString) {
        //checkSecurity();
        System.out.println("-------------userManager.modifyUser()---------");
    }
}

