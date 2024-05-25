package com.edison.socket.bio;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author LiangYi
 * @date 2022-7-30
 */
public class Service {

    public static void main(String[] args) {
        System.out.println("begin listen~ 8888");
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            Socket socket = serverSocket.accept();
            System.out.println("accept client: " + socket.getRemoteSocketAddress() + " : " + socket.getPort());
            char[] chars = new char[10];
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
            System.out.println(chars);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
