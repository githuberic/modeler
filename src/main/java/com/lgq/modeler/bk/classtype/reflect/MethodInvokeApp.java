package com.lgq.modeler.bk.classtype.reflect;

import java.lang.reflect.Method;

/**
 * Created by eric on 2019/11/10.
 *
 * @author lgq
 */
public class MethodInvokeApp {
    public static void main(String[] args) {
        // 要获取方法就是获取类的信息，获取类的信息首先要获取类的类类型
        MethodInvoke methodInvoke = new MethodInvoke();
        Class classV1 = methodInvoke.getClass();

        // 获取方法名称和参数列表来决定 getMethod获取的是public的方法 getDelcaredMethod自己声明的方法
        try {
            Method method = classV1.getMethod("print", int.class, int.class);
            method.invoke(methodInvoke, 10, 20);

            method = classV1.getMethod("print", String.class);
            Object object = method.invoke(methodInvoke, "Eric Liu");
            System.out.println(object);

            method = classV1.getMethod("print", String.class, String.class);
            method.invoke(methodInvoke, "Hi", "Eric");

            method = classV1.getMethod("print");
            method.invoke(methodInvoke);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
