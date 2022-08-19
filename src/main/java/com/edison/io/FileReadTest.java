package com.edison.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author LiangYi
 * @date 2022-8-15
 */
public class FileReadTest {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("C:\\Users\\Administrator\\Desktop\\1.txt"), StandardCharsets.UTF_8)){
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
