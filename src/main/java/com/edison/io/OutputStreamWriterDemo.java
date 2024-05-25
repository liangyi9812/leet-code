package com.edison.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author liangyi
 * @date 2024/3/11
 */
public class OutputStreamWriterDemo {

    public static void main(String[] args) {


        try (FileWriter fileWriter = new FileWriter("test.txt")){
            fileWriter.write("你好");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
