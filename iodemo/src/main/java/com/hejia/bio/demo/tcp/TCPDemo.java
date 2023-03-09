package com.hejia.bio.demo.tcp;

import com.sun.deploy.util.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Author: hj
 * @Date: 2021/2/19 9:39
 */
public class TCPDemo {
    private ExecutorService executorService;

    @Before
    public void before() {
        executorService = Executors.newCachedThreadPool();
    }

    @Test
    public void server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        AtomicInteger ai = new AtomicInteger(1);
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.execute(() -> {
                try {
                    int temp = ai.getAndAdd(1);
                    System.out.println("ip:" + socket.getInetAddress() + ", 端口: " + socket.getPort() + "的用户已连接!" + "标识为: " + temp);
                    InputStream ips = socket.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ips, StandardCharsets.UTF_8));
                    while (true) {
                        String line = bufferedReader.readLine();
                        while (line != null) {
                            System.out.println(temp + " : " + line);
                            line = bufferedReader.readLine();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
