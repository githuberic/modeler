package com.lgq.designer.dp.interceptor;

/**
 * @author lgq
 */
public class AuthenticationFilter implements Interceptor {
    @Override
    public Response execute(TargetInvocation targetInvocation) {
        if (targetInvocation == null || targetInvocation.getTarget() == null) {
            throw new IllegalArgumentException("Target is null");
        }
        System.out.println("Authenticating succeeded");
        return targetInvocation.invoke();
    }
}
