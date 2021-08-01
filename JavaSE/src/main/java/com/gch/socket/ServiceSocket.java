package com.gch.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author: Sophia
 * @description:
 * @date: Create in 2021/8/1 9:11
 */
public class ServiceSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket accept = server.accept();
        Scanner scanner = new Scanner(System.in);
        System.out.println("等待客户端发送数据");
        InputStream ism = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = ism.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }
        System.out.println("请输入回复内容：");
        String s = scanner.nextLine();
        OutputStream ops = accept.getOutputStream();
        ops.write(s.getBytes(StandardCharsets.UTF_8));
        ops.close();
        scanner.close();
        ism.close();
        accept.close();
        server.close();
    }
}
