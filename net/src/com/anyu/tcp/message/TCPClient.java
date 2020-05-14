package com.anyu.tcp.message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class TCPClient {
    public static void main(String[] args) {
        try {
            //知道服务器地址
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 4555;
            try(
                    //创建一个请求
                    Socket socket = new Socket(serverIp, port);
                    OutputStream os = socket.getOutputStream();
                    ) {
                //发送信息
                os.write("你好啊".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
