/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 *//*

package com.xyy.nio;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.*;


public class NettyServer {

    public static void main(String [] args){
        ExecutorService bossExecutor = Executors.newSingleThreadExecutor();
        ExecutorService workerExecutor = new ThreadPoolExecutor(0, 2, 60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        ChannelFactory cf = new NioServerSocketChannelFactory(bossExecutor,workerExecutor);
        ServerBootstrap sbs = new ServerBootstrap(cf);
        sbs.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline channelPipeline = Channels.pipeline();
                channelPipeline.addLast("handler",new HelloServerHandler());
                return channelPipeline;
            }
        });
        sbs.bind(new InetSocketAddress(8080));
    }
}*/
