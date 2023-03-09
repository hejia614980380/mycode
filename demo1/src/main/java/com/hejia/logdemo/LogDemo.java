package com.hejia.logdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @Author: hj
 * @Date: 2021/7/19 15:29
 */
public class LogDemo {
    @Test
    public void test1() {
        Log log = LogFactory.getLog("stdout");
        log.debug("hello");
    }
}
