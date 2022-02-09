# Thead Exit 线程退出

对于Java程序，Main线程退出，
- 如果当前存在非守护线程，则Java程序会等待非守护线程都执行完再退出；
- 如果只存在守护线程，则会直接退出。这是JVM底层实现的机制。

https://www.cnblogs.com/flowers-bloom/p/java-concurrent-aqs-1.html
