package com.hejia.bio.demo.tcp;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: hj
 * @Date: 2021/2/22 9:40
 */
public class TCPServer {
    private static Logger log = LoggerFactory.getLogger(TCPServer.class);
    private static List<String> messageList = new ArrayList<>();
    private static Set<Socket> socketList = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicInteger temp = new AtomicInteger(0);
        while (true) {
            if (temp.get() == 0) {
                System.out.println("当前无客户端连接, 阻塞!");
            } else {
                System.out.println("等待下一个客户端连接, 阻塞!");
            }
            Socket socket = serverSocket.accept();
            addSocket(socket);
            String name = socket.getInetAddress().getHostAddress() + ":" +  socket.getPort();
            System.out.println("第" + temp.addAndGet(1) + "个客户端已连接!ip地址为: " + socket.getInetAddress().getHostAddress() + "端口为: " + socket.getPort());
            // 从线程池中取一个线程进行操作
            executorService.execute(() -> {
                // 获取socket的消息
                BufferedReader br = null;
                try {
                    InputStream ips = socket.getInputStream();
                    br = new BufferedReader(new InputStreamReader(ips, StandardCharsets.UTF_8));
                    String line = br.readLine();
                    while (line != null) {
                        String message = name + ": " + line;
                        addMessage(message);
                        sendMessage(message);
                        line = br.readLine();
                    }
                } catch (IOException e) {
                    log.error("error!", e);
                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                    } catch (IOException e) {
                        log.error("输入流关闭出错!", e);
                    }
                }
            });
        }
    }

    private synchronized static void addSocket(Socket socket) {
        socketList.add(socket);
    }

    private synchronized static void addMessage(String message) {
        messageList.add(message);
    }

    private synchronized static void sendMessage(String message) {
        socketList.forEach(socket -> {
            BufferedWriter bw = null;
            try {
                OutputStream ops = socket.getOutputStream();
                bw = new BufferedWriter(new OutputStreamWriter(ops, StandardCharsets.UTF_8));
                bw.write(message);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                log.error("error!", e);
            }
        });
    }
}
