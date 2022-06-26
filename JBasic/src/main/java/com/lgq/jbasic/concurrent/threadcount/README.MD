## 应用程序方面/jvm方面线程数量
关于今天我们讨论的题目你做到心中有数了吗？今天我准备了一个有意思的问题，写一个最简单的打印 HelloWorld 的程序，说说看，运行这个应用，Java 至少会创建几个线程呢？然后思考一下，如何明确验证你的结论，真实情况很可能令你大跌眼镜哦。

1、站在应用程序方面，只创建了一个线程。
2、站在jvm方面，肯定还有gc等其余线程。

检测获得
Thread[Reference Handler,10,system]
Thread[Finalizer,8,system]
Thread[main,5,main]
Thread[Signal Dispatcher,9,system]
Hello World!
其中：
Reference Handler：处理引用对象本身的垃圾回收
Finalizer：处理用户的Finalizer方法
Signal Dispatcher：外部jvm命令的转发器

大概10来个吧，native占多数。大致分下面几类
1. 用户线程，main
2. GC相关线程，包括C1/C2；与运行机器配置、操作系统、启动参数相关
3. 编译器/解释器相关线程；与运行机器配置、操作系统、启动参数相关
   4.引用及Finalizer处理线程
6. VM Thread：可以说它类似linux的init进程
7. VM Periodic Task Thread：JVM时钟模拟线程
8. Signal Dispatcher：JVM信号处理线程
9. Attach Listener：jdk工具类请求响应处理线程
10. Service Thread：低内存检测、JVMTI事件转发线程
