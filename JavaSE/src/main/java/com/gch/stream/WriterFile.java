package com.gch.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Sophia
 * @description:
 * @date: Create in 2021/7/31 20:13
 */
public class WriterFile {
    public static void main(String[] args) throws IOException {
        // write_data();
        read_data();
    }

    private static void read_data() throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            System.out.print(len);
        }
        fis.close();
    }

    private static void write_data() throws IOException {
        // 创建FileOutputStream对象
        FileOutputStream fos = new FileOutputStream("a.txt",true);
        // 使用writer方法写数据
        fos.write("bbb".getBytes());
        // 关闭io流
        fos.close();
    }

    // 写数据
}
