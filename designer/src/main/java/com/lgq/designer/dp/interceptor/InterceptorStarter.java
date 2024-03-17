package com.lgq.designer.dp.interceptor;

/**
 * @author lgq
 */
public class InterceptorStarter {
    public static void main(String[] args) {
        TargetInvocation targetInvocation = new TargetInvocation();
        targetInvocation.addInterceptor(new AuthenticationFilter());
        targetInvocation.addInterceptor(new LogInterceptor());
        targetInvocation.setRequest(new Request());
        targetInvocation.setTarget(request -> {
            return new Response();
        });
        targetInvocation.invoke();
    }
}
