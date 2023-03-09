package com.hejia.exceptiondemo;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

/**
 * @Author: hj
 * @Date: 2021/7/19 9:58
 */
@Slf4j
public class ExceptionDemo {

    public static void main(String[] args) {
        int count = 11;

        try {
            method1(count);
        } catch (Exception e) {
            log.error("捕捉到运行时异常", e);
        }

        try {
            method2(count);
        } catch (MyException2 e) {
            log.error("捕捉到异常", e);
        }
        Logger logger = Logger.getLogger(ExceptionDemo.class);
        logger.info("1");

        Logger log1 = Logger.getLogger("stdout");
        log1.info("1");
    }

    public static void method1(int count) {
        if (count < 100) {
            throw new MyException1("error");
        }
    }

    public static void method2(int count) throws MyException2 {
        if (count < 100) {
            throw new MyException2("error");
        }
    }
}
