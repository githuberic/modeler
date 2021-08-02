## Chapter1

### netty 优雅退出
- 预处理的操作
    - 通信队列中尚未发送的消息
    - NIO线程中待处理的定时任务
    - 注册到NIO线程中shutdownhook任务
- 资源释放
    - 关闭所有的channel
    - 从selector上注册
    - 清空所有的队列
    - NIO线程退出

### SignalHandler 处理流程
- 初始化Signal
- 根据操作系统选择信号量
- 获取并注册SignalHandler
- 在handler(Signal sgin)根据信号量类型经相应操作

