package com.mason.netty.ch2

import java.io.IOException
import java.net.ServerSocket

/**
 * Created by mwu on 2018/8/30
 * netty源码学习第二章：Netty基本组件
 * 基于Socket IO Server
 *
 */
object Server {

  private lateinit var serverSocket: ServerSocket
  private const val PORT = 8765

  init {
    try {
      this.serverSocket = ServerSocket(PORT)
      println("服务器启动成功，端口：$PORT")
    } catch (ex: IOException) {
      println("启动服务器失败：${ex.message}")
    }
  }

  @JvmStatic
  fun main(args: Array<String>) {
    start()
  }

  private fun start() {
    Thread { doStart() }.start()
  }

  private fun doStart() {
    while (true) {
      try {
        val client = serverSocket.accept()
        ClientHandler(client).start()
      } catch (ex: IOException) {
        println("服务器端异常：${ex.message}")
      }
    }
  }
}