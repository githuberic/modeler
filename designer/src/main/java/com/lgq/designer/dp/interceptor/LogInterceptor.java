package com.lgq.designer.dp.interceptor;

/**
 * @author lgq
 */
public class LogInterceptor implements Interceptor {
    @Override
    public Response execute(TargetInvocation targetInvocation) {
        System.out.println("Logging Begin");
        Response response = targetInvocation.invoke();
        System.out.println("Logging End");
        return response;
    }
}
