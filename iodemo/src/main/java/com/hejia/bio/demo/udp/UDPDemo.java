package com.hejia.bio.demo.udp;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @Author: hj
 * @Date: 2021/2/19 11:14
 */
public class UDPDemo {
    @Test
    public void server() throws Exception {
        DatagramSocket ds = new DatagramSocket(8888);
        String message = "hello!我是小红花";
        byte[] data = message.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        ds.send(dp);
        ds.close();
    }

    @Test
    public void client() throws Exception {
        DatagramSocket ds = new DatagramSocket(9999);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        ds.receive(dp);
        System.out.println(new String(dp.getData(), 0, dp.getLength(), StandardCharsets.UTF_8));
    }
}
