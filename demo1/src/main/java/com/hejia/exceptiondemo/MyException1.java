package com.hejia.exceptiondemo;

/**
 * @Author: hj
 * @Date: 2021/7/19 9:58
 */
public class MyException1 extends RuntimeException {
    private String message;

    public MyException1(String message) {
        super(message);
        this.message = message;
    }
}
