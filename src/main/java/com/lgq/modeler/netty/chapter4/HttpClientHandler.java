package com.lgq.modeler.netty.chapter4;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.concurrent.DefaultPromise;

/**
 * @author lgq
 */
public class HttpClientHandler extends SimpleChannelInboundHandler<FullHttpResponse> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpResponse msg) throws Exception {
        if (msg.decoderResult().isFailure()) {
            throw new Exception("Decode HttpResponse error : " + msg.decoderResult().cause());
        }
        HttpResponse response = new HttpResponse(msg);
        respPromise.setSuccess(response);
    }

    @Override
    public void exceptionCaught(
            ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    DefaultPromise<HttpResponse> respPromise;
    public DefaultPromise<HttpResponse> getRespPromise() {
        return respPromise;
    }
    public void setRespPromise(DefaultPromise<HttpResponse> respPromise) {
        this.respPromise = respPromise;
    }
}
