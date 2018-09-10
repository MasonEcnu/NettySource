package com.mason.netty.ch3

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.util.AttributeKey

object NettyServer {

  @JvmStatic
  fun main(args: Array<String>) {
    // Server Thread
    val boosGroup = NioEventLoopGroup(1)
    // Client Thread
    val workerGroup = NioEventLoopGroup()

    try {
      val serverBoot = ServerBootstrap()
      serverBoot.group(boosGroup, workerGroup)
          .channel(NioServerSocketChannel::class.java)
          .childOption(ChannelOption.TCP_NODELAY, true)
          .childAttr(AttributeKey.newInstance("childAttr"), true)
          // channel处理逻辑
          .handler(ServerHandler())
          // 数据流读写处理逻辑
          .childHandler(object : ChannelInitializer<SocketChannel>() {
            override fun initChannel(ch: SocketChannel?) {
              if (ch != null) {
//                ch.pipeline().addLast()
              }
            }
          })
      val cf = serverBoot.bind(9876).sync()
      cf.channel().closeFuture().sync()
    } catch (ex: Exception) {
      println("服务器启动异常：${ex.message}")
    } finally {
      boosGroup.shutdownGracefully()
      workerGroup.shutdownGracefully()
    }
  }
}