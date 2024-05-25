package com.edison.socket.bio.onlysend;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author liangyi
 * @date 2024/3/15
 */

@Slf4j
public class ServerSocketOnlySend {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(55533)) {

            log.info("ServerSocket listen~");
            Socket accepted = serverSocket.accept();
            InputStream inputStream = accepted.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            int len;
            byte[] buffer = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, len, StandardCharsets.UTF_8));
            }
            log.info("receive msg from socket, ip: {}, port: {}, msg: {}",
                    accepted.getInetAddress().getHostAddress(),
                    accepted.getPort(),
                    stringBuilder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
