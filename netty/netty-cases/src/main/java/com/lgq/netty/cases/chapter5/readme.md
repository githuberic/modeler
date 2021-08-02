# 发送队列解压导致内存泄露

利用netstat -ano等命令可以监控某个端口下tcp 接收(recv -q) 和 发送队列(send -q) 的挤压情况；

## netty 消息发送机制
业务调用write方法后，经过ChannelPipeline职责链处理-->消息被投递到发送缓冲区待发送-->调动flush执行真正的发送操作；
-->底层调用Java NIO 的SocketChannel 进行非阻塞的Write处理，将消息发送到网络上；

Netty 的消息发送涉及到线程切换、消息队列、高低水位和写半包消息；

### WriteAndFlushTask 原理和源码解析
- Netty 采用了串行-无锁设计，在IO线程内部进行串行操作；通过调整NIO线程池的线程参数；同时启动多个串行化的线程并行运行；
- 当用户线程发起write操作，如果发现不是NioEventLoop(IO线程)，将发送消息封装成WriteTask；放入NioEventLoop的任务队列由NioEventLoop线程执行；
- Netty的NioEventLoop线程内部维护了一个Queue<Runnable> taskQueue 除了处理IO读写；同时还负责执行网络读写相关的Task;

### ChannelOutboundBuffer原理和源码分析
ChannelOutboundBuffer 是netty的发送缓冲队列，它基于链表管理待发送的消息；