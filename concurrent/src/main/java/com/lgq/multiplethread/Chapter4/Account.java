package com.lgq.multiplethread.Chapter4;

/**
 * Created by eric on 2019/12/16.
 *
 * @author lgq
 */
public class Account {
    private Integer balance;
    // actr 应该为单例
    private Allocator actr;
    private Integer id;

    public void transfer(Account target, Integer amt) {
        // 一次性申请转出账户和转入账户，直到成功
        while (!actr.apply(this, target)) {
            ;
        }

        try {
            synchronized (this) {
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            actr.free(this, target);
        }
    }

    public void transfer(Account target, int amt) {
        Account left = this;
        Account right = target;

        if (this.id > target.id) {
            left = target;
            right = this;
        }
        // 锁定序号小的账户
        synchronized (left) {
            // 锁定序号大的账户
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
