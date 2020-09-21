package com.lgq.modeler.bk.mem;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by eric on 2019/12/13.
 * VM Args: -XX:MetaspaceSize=1M -XX:MaxMetaspaceSize=1M
 * 借助CGlib使得方法区出现内存溢出异常
 * 方法区：存放class的类名、访问修饰符、常量池、字段描述、方法描述等
 *
 * @author lgq
 */
public class JavaMethodAreaOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }
            });
            enhancer.create();
        }
    }
}
