package com.hejia.bio.demo.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: hj
 * @Date: 2021/2/19 11:08
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Socket socket = new Socket("127.0.0.1", 6666);
        // 主线程用于写, 子线程用于读
        executorService.execute(() -> {
            InputStream ips = null;
            try {
                ips = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(ips, StandardCharsets.UTF_8));
                String line = br.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (ips != null) {
                    try {
                        ips.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        OutputStream ops = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ops, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                String next = scanner.nextLine();
                if ("end".equals(next)) {
                    break;
                }
                bw.write(next);
                bw.newLine();
                bw.flush();
            }
        }
        executorService.shutdown();
        socket.close();
    }
}
