package com.anyu.tcp.message;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TCPServer {
    public static void main(String[] args) {
        try (
                //创建地址
                ServerSocket serverSocket = new ServerSocket(4555);
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                //管道流--》过滤，缓冲
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ) {
        //缓冲字节
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        System.out.println(bos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
