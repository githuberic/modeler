package com.lgq.designer.dp.interceptor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lgq;
 */
public class TargetInvocation {
    private final List<Interceptor> interceptorList = new ArrayList<Interceptor>();
    private Target target;
    private Request request;
    private Iterator<Interceptor> interceptors;

    public void addInterceptor(Interceptor interceptor) {
        interceptorList.add(interceptor);
        interceptors = interceptorList.listIterator();
    }

    public Response invoke() {
        if (interceptors.hasNext()) {
            Interceptor interceptor = interceptors.next();
            interceptor.execute(this);
        }
        return target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Target getTarget() {
        return this.target;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
