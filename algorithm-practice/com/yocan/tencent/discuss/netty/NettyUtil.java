package com.yocan.tencent.discuss.netty;

import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;

/**
 * @author liuyongkang
 */
public class NettyUtil {

    static String getMessage(ByteBuf buf) {
        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con, "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
