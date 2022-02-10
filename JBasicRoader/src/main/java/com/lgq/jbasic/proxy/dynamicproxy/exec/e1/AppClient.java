package com.lgq.jbasic.proxy.dynamicproxy.exec.e1;

/**
 * @author lgq
 */
public class AppClient {
    public static void main(String[] args) {
        SecurityHandler handler = new SecurityHandler();
        UserManager userManager = (UserManager) handler.createProxyInstanceObject(new UserManagerImpl());
        userManager.addUser("zhangsan", "123");
        userManager.modifyUser(123, "123", "123456");
    }
}



