package com.wuzx.boot.crud.crud.SocektDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSoceketImpl {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        BufferedReader in = null;
        try {
            //服务端一定会去监听一个端口号,ip默认就是本机的ip地址
            serverSocket = new ServerSocket(8080);

            Socket socket = serverSocket.accept();//接受客户端的连接（阻塞）

            ObjectInputStream objectInputStream =
                    new ObjectInputStream(socket.getInputStream());
            User user = (User) objectInputStream.readObject();
            System.out.println(user);

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {

                serverSocket.close();
            }
        }

    }
}
