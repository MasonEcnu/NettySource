package com.mason.netty.ch2

import java.io.IOException
import java.net.Socket
import java.net.UnknownHostException

/**
 * Created by mwu on 2018/8/30
 * netty源码学习第二章：Netty基本组件
 * 基于Socket IO Client
 */
object Client {

  private const val HOST = "localhost"
  private const val PORT = 8765
  private const val SLEEP_TIME = 10000L

  @JvmStatic
  fun main(args: Array<String>) {
    // 初始化客户端socket，并尝试连接远程host
    var socket: Socket? = null
    try {
      socket = Socket(HOST, PORT)
    } catch (ux: UnknownHostException) {
      println("未知Host异常：${ux.message}")
    } catch (iox: IOException) {
      println("IO异常：${iox.message}")
    }

    Thread {
      println("客户端启动成功")
      while (true) {
        try {
          val message = "Hello World!"
          println("客户端发送数据：$message")
          // 向服务端写数据
          if (socket != null) {
            socket.getOutputStream().write(message.toByteArray())
          } else {
            throw IOException("客服端socket为空")
          }
        } catch (ex: IOException) {
          println("写数据出错：${ex.message}")
        }
        // 客户端线程休眠
        sleep()
      }
    }.start()
  }

  private fun sleep() {
    try {
      Thread.sleep(SLEEP_TIME)
    } catch (ex: InterruptedException) {
      println("客户端中断：${ex.message}")
    }
  }
}

