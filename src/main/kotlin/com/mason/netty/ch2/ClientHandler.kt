package com.mason.netty.ch2

import java.io.IOException
import java.net.Socket

/**
 * Created by mwu on 2018/8/31
 */
class ClientHandler(client: Socket) {

  private val socket = client

  private val MAX_DATA_LENGTH = 1024

  fun start() {
    println("新客户端接入")
    Thread { doStart() }.start()
  }

  private fun doStart() = try {
    val input = socket.getInputStream()
    while (true) {
      val data = ByteArray(size = MAX_DATA_LENGTH)
      var len = 0
      while (input.read(data).also { len = it } != -1) {
        val message = String(data, 0, len)
        println("客户端传来消息：$message")
        socket.getOutputStream().write(data)
      }
    }
  } catch (ex: IOException) {
    println("服务器端异常：${ex.message}")
  }
}