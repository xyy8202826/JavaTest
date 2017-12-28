/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.xyy.nio;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

/**
 * @author XYY
 * @version Id: NettyServer.java, v 0.1 2017/12/26 14:04 xuyuanye Exp $$
 */
public class NettyClient {

    public static void main(String [] args){
        ChannelFactory cf = new NioClientSocketChannelFactory();
        ClientBootstrap cb = new ClientBootstrap(cf);
        cb.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                    ChannelPipeline channelPipeline = Channels.pipeline();
                    channelPipeline.addLast("handler",new HelloClientHandler());
                    return channelPipeline;
            }
        });
        cb.connect(new InetSocketAddress(8080));


    }
}