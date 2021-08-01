package com.gch.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author: Sophia
 * @description:
 * @date: Create in 2021/8/1 9:06
 */
public class ClinetSocket {
    public static void main(String[] args) throws IOException {
        Socket clinet = new Socket("localhost", 8888);
        OutputStream osm = clinet.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入发送给服务器端的内容：");
        String msg = scanner.nextLine();
        osm.write(msg.getBytes(StandardCharsets.UTF_8));
        clinet.shutdownOutput();
        System.out.println("等待服务端回应");
        InputStream ism = clinet.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = ism.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }
        ism.close();
        osm.close();
        clinet.close();
    }
}
