package com.mason.netty.ch2

import java.io.IOException
import java.net.Socket

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
    val socket = Socket(HOST, PORT)

    Thread {
      println("客户端启动成功")
      while (true) {
        try {
          val message = "Hello World!"
          println("客户端发送数据：$message")
          socket.getOutputStream().write(message.toByteArray())
        } catch (ex: IOException) {
          println("写数据出错：${ex.message}")
        }
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

