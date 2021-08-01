package com.gch.stream;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Sophia
 * @description:
 * @date: Create in 2021/7/31 20:24
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader read = new FileReader("a.txt");
        int len = 0;
        while ((len = read.read()) != -1){
            System.out.println((char)len);
        }
        read.close();
    }
}
