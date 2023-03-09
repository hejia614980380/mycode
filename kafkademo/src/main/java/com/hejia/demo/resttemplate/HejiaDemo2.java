package com.hejia.demo.resttemplate;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class HejiaDemo2 {
    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusMonths(13);
        ChronoUnit chronoUnit = ChronoUnit.YEARS;
        System.out.println(chronoUnit.between(now, localDateTime));
        System.out.println(localDateTime.plusYears(1).withDayOfYear(1).minusDays(1).getDayOfYear());
    }

    @Test
    public void test2() {
        String str = "1111100111110011111001111100111";
        System.out.println(Arrays.toString(str.substring(1, 7).toCharArray()));
        System.out.println(str.substring(0, 31).chars().filter(i -> i == '1').count());
    }

    @Test
    public void test3() {
        System.out.println(System.currentTimeMillis() - (1000 * 60 * 60 * 24 * 30 * 12));
        System.out.println(System.currentTimeMillis());

//        BigDecimal.valueOf(1).setScale(2, RoundingMode.HALF_UP).doubleValue()
    }
}
