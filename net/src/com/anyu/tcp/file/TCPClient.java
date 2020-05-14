package com.anyu.tcp.file;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//发送文件的客户端
public class TCPClient {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        try (
                //请求
                Socket socket = new Socket(ip, 8888);
                OutputStream os = socket.getOutputStream();
                //读取文件
                FileInputStream fis = new FileInputStream(new File("Surface Family 2019.jpg"));
                InputStream is = socket.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ) {
            byte[] buffer = new byte[1024];
            int len;
            //向外写文件
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer);
            }
            //发送完毕
            socket.shutdownOutput();
            //读取是否接受成功信息
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
            System.out.println(bos.toString().equals("success"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
