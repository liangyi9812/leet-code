package com.edison.socket.bio.case1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author LiangYi
 * @date 2022-7-30
 */
public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8888)) {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
