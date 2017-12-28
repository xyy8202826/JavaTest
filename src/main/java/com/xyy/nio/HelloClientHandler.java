/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.xyy.nio;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author XYY
 * @version Id: HelloServerHandler.java, v 0.1 2017/12/28 19:35 xuyuanye Exp $$
 */
public class HelloClientHandler extends SimpleChannelHandler {
    /**
     *
     * connected to a remote address.
     *
     * @param ctx
     * @param e
     */
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("HelloClientHandler channelConnected");
    }
}