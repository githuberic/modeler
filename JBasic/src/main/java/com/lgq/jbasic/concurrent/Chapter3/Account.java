package com.lgq.jbasic.concurrent.Chapter3;

/**
 * Created by eric on 2019/12/15.
 *
 * @author lgq
 */
public class Account {
    // 锁：保护账户余额
    private final Object balLock = new Object();
    // 账户余额
    private Integer balance;
    // 锁：保护账户密码
    private final Object pwdLock = new Object();
    // 账户密码
    private String password;

    public void withDraw(Integer amt) {
        if (amt == null || amt <= 0) {
            return;
        }

        synchronized (balLock) {
            if (this.balance >= amt) {
                this.balance -= amt;
            }
        }
    }

    public synchronized void transfer(Account target, Integer amt) {
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }

    //Account.class 作为共享的锁。Account.class 是所有 Account 对象共享的，
    //而且这个对象是 Java 虚拟机在加载 Account 类的时候创建的，所以我们不用担心它的唯一性。
    public void transferV2(Account target, Integer amt) {
        synchronized (Account.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }

    public Integer getBalance() {
        synchronized (balLock) {
            return this.balance;
        }
    }

    public void updatePassword(String pwd) {
        synchronized (pwdLock) {
            this.password = pwd;
        }
    }

    public String getPassword() {
        synchronized (pwdLock) {
            return this.password;
        }
    }
}

