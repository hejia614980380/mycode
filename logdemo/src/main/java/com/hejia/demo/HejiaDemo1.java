package com.hejia.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @Author: hj
 * @Date: 2021/7/19 16:42
 */
public class HejiaDemo1 {
    Logger logger = LogManager.getLogger("druid.sql.Statement");

    @Test
    public void test1() {
        logger.info("test");
    }
}
