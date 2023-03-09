package com.hejia.io.file.FileDemo;

import org.junit.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @Author: hj
 * @Date: 2021/4/12 15:00
 */
public class FileDemo1 {
    @Test
    public void test1() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\test\\test.txt"));
        byte[] bytes = new byte[256];
        int i = bis.read(bytes);
        while (i != -1) {
            String result = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(result);
            i = bis.read(bytes);
        }
        bis.close();
    }

    @Test
    public void test2() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\test\\test1.txt"));
        String text = "大漠孤烟直，长河落日圆。";
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        bos.write(bytes);
        // flush()方法是将缓存中的数据刷到流中, 如果没有调用这个方法, 那么此次写入缓存中的数据将被下一次写入覆盖
        bos.flush();
        text = "\r\n穿越人海，到你身边。";
        byte[] bytes1 = text.getBytes(StandardCharsets.UTF_8);
        bos.write(bytes1);
        // close()方法自动调用了flush()方法, 故最后一次没有调用flush()方法也可以写入到流中
        bos.close();
    }

    @Test
    public void test3() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("D:\\test\\test.txt"));
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
    }

    @Test
    public void test4() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\test\\test1.txt"));
        BufferedReader br = new BufferedReader(new FileReader("D:\\test\\test.txt"));
        String line = br.readLine();
        while (line != null) {
            bw.write(line);
            bw.flush();
            bw.newLine();
            line = br.readLine();
        }
        br.close();
        bw.close();
    }

    @Test
    public void test5() throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\test\\test1.txt"));
        String text = "大漠孤烟直，长河落日圆。";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(text.getBytes(StandardCharsets.UTF_8));
//        System.out.println(bos.toString("UTF-8"));
        bos.writeTo(bufferedOutputStream);
        bufferedOutputStream.close();
        bos.close();
    }

    @Test
    public void test6() throws Exception {
        String text = "穿越人海，到你身边。";
        ByteArrayInputStream bis = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = new byte[1024];
        int i = bis.read(bytes);
        while (i != -1) {
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
            i = bis.read(bytes);
        }
    }

    @Test
    public void test7() throws Exception {
        CharArrayWriter caw = new CharArrayWriter();
        caw.append("你好Java");
        System.out.println(caw.toString());
    }

    @Test
    public void test8() throws Exception {
        String text = "穿越人海，到你身边。";
        CharArrayReader car = new CharArrayReader(text.toCharArray());
        CharBuffer allocate = CharBuffer.allocate(10);
        int i = car.read(allocate);
    }

    @Test
    public void test9() throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\test\\test1.txt"));
        for (int i = 32; i < 128; i++) {
            dos.writeChar(i);
            dos.flush();
        }
        dos.close();
    }

    @Test
    public void test10() throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream("D:\\test\\test1.txt"));
    }
}
