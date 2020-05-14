package com.anyu.tcp.file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//接受文件的服务端
public class TCPServer {
    public static void main(String[] args) throws IOException {
        try (
                //初始化服务端
                ServerSocket serverSocket = new ServerSocket(8888);
                //监听服务端，阻塞
                Socket accept = serverSocket.accept();
                InputStream is = accept.getInputStream();
                FileOutputStream fos = new FileOutputStream("receive.jpg");
                OutputStream os = accept.getOutputStream();
        ) {
            //读取文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            //读取完毕
            accept.getInputStream();
            //发送接收完毕信息
            os.write("success".getBytes());

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
