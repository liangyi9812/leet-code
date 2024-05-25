package com.edison.socket.bio.onlysend;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author liangyi
 * @date 2024/3/15
 */
public class SocketOnlySend {

    public static void main(String[] args) {

        try (Socket client = new Socket("127.0.0.1", 55533);
             OutputStream outputStream = client.getOutputStream();
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))
        {
            outputStreamWriter.write("你好，梁毅！\uD83D\uDE00");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
