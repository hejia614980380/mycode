package com.hejia.nio.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: hj
 * @Date: 2021/4/13 11:01
 */
public class ChannelDemo {
    @Test
    public void test1() throws Exception {
        FileInputStream fis = new FileInputStream("D:\\test\\test.txt");
        FileChannel channel = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int read = channel.read(buffer);
        while (read != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println(buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
        }
        fis.close();
    }

    @Test
    public void test2() throws Exception {
        String text1 = "你好Java";
        String text2 = "你好Python";
        FileOutputStream fos = new FileOutputStream("D:\\test\\test1.txt");
        FileChannel channel = fos.getChannel();
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        buffer1.put(text1.getBytes(StandardCharsets.UTF_8));
        buffer1.flip();
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        buffer2.put(text2.getBytes(StandardCharsets.UTF_8));
        buffer2.flip();
        byteBuffers[0] = buffer1;
        byteBuffers[1] = buffer2;
        channel.write(byteBuffers);
        fos.close();
    }

    @Test
    public void test3() throws Exception {
        String DATE_TIMESTAMP_REGEX = "^-?[0-9]+$";
        String s = "135792468.0";
        System.out.println(Pattern.matches(DATE_TIMESTAMP_REGEX, s));
        String s1 = "2021-12-31 00:00:00";
        System.out.println(s1.substring(0, -1));
        String s2 = "2021-12";
//        System.out.println(LocalDate.parse(s2, DateTimeFormatter.ofPattern("yyyy-MM")));
    }

    @Test
    public void test4() throws Exception {
        String s = "1";
        String collect = Stream.of(s.split(",")).map(str -> String.format("'%s'", str)).collect(Collectors.joining(",", "[", "]"));
        List<String> strings = JSON.parseArray(collect, String.class);
        System.out.println(strings);
    }

    @Test
    public void test5() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("吸毒人员");
        System.out.println(JSON.toJSONString(list));
    }
}
