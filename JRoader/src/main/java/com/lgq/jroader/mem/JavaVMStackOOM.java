package com.lgq.jroader.mem;

/**
 * Created by eric on 2019/12/13.
 * VM Args: -Xss2M
 * <p>
 * 创建线程导致内存溢出异常
 *
 * @author lgq
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakThrea() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });

            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakThrea();
    }
}
