package com.yocan.tencent.discuss.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Handler implementation for the echo client.  It initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private final ByteBuf firstMessage;

    /**
     * Creates a client-side handler.
     */
    public EchoClientHandler() {
        firstMessage = Unpooled.buffer(EchoClient.SIZE);
//        for (int i = 0; i < firstMessage.capacity(); i ++) {
//            firstMessage.writeByte((byte) i);
//        }
    }

    private void sendMessage(ChannelHandlerContext ctx){
        Scanner scanner =new Scanner(System.in);
        String data =scanner.nextLine();
        byte[] bytes =data.getBytes();
        if (firstMessage.refCnt()<=1){
            System.out.println("计数器数量"+firstMessage.refCnt());
            firstMessage.retain();
            System.out.println("计数器加一");
        }
        firstMessage.clear();
        firstMessage.writeBytes(bytes);
        ctx.writeAndFlush(firstMessage);
        System.err.println("客户端发送消息:"+data);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
//        byte[] data = "你好，服务器".getBytes();
        sendMessage(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ctx.write(msg);
        ByteBuf buf = (ByteBuf) msg;
        String rev = NettyUtil.getMessage(buf);
        System.err.println("客户端收到服务器消息:" + rev);

        sendMessage(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
