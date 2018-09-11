----------
title: Netty服务端启动
description: 第三章笔记
----------

### 两个问题

1. 服务端的socket在哪里初始化？
> 答案：在通过反射创建`SocketChannel`时
2. 在哪里accept连接？
> 答案：

### 服务端启动过程

1. 创建服务端Channel
- bind()[用户代码入口]
    - initAndRegister()[初始化并注册]
        - newChannel()[创建服务端channel]

2. 初始化服务端Channel

3. 注册selector

4. 端口绑定
