package com.lgq.jbasic.callback;

public class CallbackTest2 {
     public static void main(String[] args) {
          Server server = new Server();
          Client client = new Client(server);

          client.sendMsg("Server,Hello~");
     }
}



interface CSCallback {
    void process(String status);
}

class Server {
    public void getClientMsg(CSCallback csCallBack, String msg) {
        System.out.println("服务端：服务端接收到客户端发送的消息为:" + msg);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("服务端:数据处理成功，返回成功状态 200");
        String status = "200";

        csCallBack.process(status);
    }
}

class Client implements CSCallback {

    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void sendMsg(final String message) {
        System.out.println("客户端：发送的消息为：" + message);
        new Thread(() -> server.getClientMsg(Client.this, message)).start();
        System.out.println("客户端：异步发送成功");
    }

    @Override
    public void process(String status) {
        System.out.println("客户端：服务端回调状态为：" + status);
    }
}
