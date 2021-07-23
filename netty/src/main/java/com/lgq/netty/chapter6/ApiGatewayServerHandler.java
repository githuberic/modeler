package com.lgq.netty.chapter6;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author lgq
 */
public class ApiGatewayServerHandler extends ChannelInboundHandlerAdapter {
    ExecutorService executorService = Executors.newFixedThreadPool(8);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
        char[] req = new char[64 * 1024];
        executorService.execute(() ->
        {
            char[] dispatchReq = req;
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /*
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
        char[] req = new char[((ByteBuf) msg).readableBytes()];
        executorService.execute(() ->
        {
            char[] dispatchReq = req;
            try {
                TimeUnit.MICROSECONDS.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }*/

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
