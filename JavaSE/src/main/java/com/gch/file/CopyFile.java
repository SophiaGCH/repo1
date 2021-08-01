package com.gch.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Sophia
 * @description:
 * @date: Create in 2021/7/31 15:23
 */
public class CopyFile {

    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("d:\\1.jpg");
        FileOutputStream fos = new FileOutputStream("e:\\1.jpg");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
        long e = System.currentTimeMillis();
        System.out.println("耗时：" + (e-l));
    }
}
