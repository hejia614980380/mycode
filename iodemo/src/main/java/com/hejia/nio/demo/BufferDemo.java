package com.hejia.nio.demo;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @Author: hj
 * @Date: 2021/2/19 11:38
 */
public class BufferDemo {
    @Test
    public void test1() {
        String text = "你好Java";
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(text.getBytes(StandardCharsets.UTF_8));
//        buffer.clear();
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
