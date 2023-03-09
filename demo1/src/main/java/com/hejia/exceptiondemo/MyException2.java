package com.hejia.exceptiondemo;

/**
 * @Author: hj
 * @Date: 2021/7/19 10:00
 */
public class MyException2 extends Exception {
    private String message;

    public MyException2(String message) {
        super(message);
        this.message = message;
    }
}
