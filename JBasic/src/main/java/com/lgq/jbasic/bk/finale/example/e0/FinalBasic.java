package com.lgq.jbasic.bk.finale.example.e0;

/**
 * @author lgq
 */
public class FinalBasic {
    private final int x = 6;
    private final String str;
    private final static boolean b;
    private final double d;
    // private final char ch;

    // 静态代码为静态变量赋值
    static {
        b = false;
    }

    // 非静态代码为实例变量赋值
    {
        d = 1.891;
    }

    // 在构造函数中赋值
    public FinalBasic() {
        str = "lgq";
        // 赋值后不能再次修改
        // str = "lyy";
    }

    // 不能再实例方法中进行赋值
    public void temp() {
        // ch = 'a';
    }

    public void tempMethod(final int x){
        final int y = 1;
        // 再次赋值会报错
        // x = 3;
    }
}
