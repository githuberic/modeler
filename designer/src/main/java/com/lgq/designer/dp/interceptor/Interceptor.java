package com.lgq.designer.dp.interceptor;

/**
 * @author lgq
 * <p>
 * 拦截器接口
 */
public interface Interceptor {
    Response execute(TargetInvocation targetInvocation);
}
