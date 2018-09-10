package com.mason.netty.ch3

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

class ServerHandler : ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext?) {
    println("channelActive")
  }

  override fun channelRegistered(ctx: ChannelHandlerContext?) {
    println("channelRegistered")
  }

  override fun handlerAdded(ctx: ChannelHandlerContext?) {
    println("handlerAdded")
  }
}