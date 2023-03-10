package com.hejia.demo;

import com.alibaba.fastjson.JSON;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.junit.Test;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HejiaDemo2 {
    @Test
    public void test1() {
        String[] arr = {"1", "3", "5", "7"};
        List<String> list = Stream.of(arr).collect(Collectors.toList());
        list.forEach(s -> {
            if (StringUtils.equals(s, "3")) {
                return;
            }
            System.out.println(s);
        });

    }

    @Test
    public void test2() {
        List<Student> list = new ArrayList<>();
        list.add(new Student());
        List<Student> collect = list.stream().map(s -> s).collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void test3() {
        Long time = 2146009554L;
        long l = System.currentTimeMillis();
        System.out.println(new Date(l));
        System.out.println(new Date(l - time));
        System.out.println(time / (24 * 60 * 60 * 1000));
        System.out.println((time % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000));
        System.out.println((time % (60 * 60 * 1000)) / (60 * 1000));
        System.out.println((time % (60 * 1000)) / 1000);

        long day = time / (24 * 60 * 60 * 1000);
        long hour = (time % (24 * 60 * 60 * 1000)) / (60 * 60 * 1000);
        long minute = (time % (60 * 60 * 1000)) / (60 * 1000);
        long second = (time % (60 * 1000)) / 1000;
        System.out.println(String.format("%s%s%s%s",
                day == 0 ? "" : day + "???",
                hour == 0 ? "" : hour + "???",
                minute == 0 ? "" : minute + "???",
                second == 0 ? "" : second + "???"));

        // 29 41 25 77
        // 30 17 26 17
    }

    @Test
    public void test4() {
        System.out.println(true ^ false);
    }

    @Test
    public void test5() {
        Set<Integer> set = new HashSet<>();
        set.add(1234);
        set.add(1234);
        set.add(1235);
        set.add(1235);
        System.out.println(set);
    }

    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(1, 2, 5, 4, 8);
        System.out.println(list.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList()));
    }

    @Test
    public void test7() {
        String text = "2021-01-12 11:05:21.0";
        String format = "yyyy-MM-dd HH:mm:ss.SSS";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            System.out.println(sdf.parse(text));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test8() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1);
        List<Integer> list3 = Arrays.asList(1, 2);
        System.out.println(Arrays.asList(list1, list2, list3).stream().sorted((o1, o2) -> o2.size() - o1.size()).collect(Collectors.toList()));
    }

    @Test
    public void test9() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(String.valueOf(Math.random()).substring(2, 5));
        }
    }

    @Test
    public void test10() {
        // Integer -> int : ??????Integer??????intValue()??????
        int i = new Integer(127);
        // int -> Integer : ??????Integer??????valueOf()??????
        Integer j = 127;
        // + ??????int????????????????????????, i + j?????????j???Integer -> int, ?????? +,k????????????int -> Integer
        Integer k = i + j;
        // ??????????????????????????????Long???Integer???Short???Byte???Char???Boolean??????????????????, ???-127~127???????????????????????????
        // , ??????????????????????????????,???????????????????????????,?????????????????????
        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println("Boolean??????:" + (b1 == b2));
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println("Integer??????:" + (i1 == i2));
        // ?????????new??????????????????, ??????????????????????????????
        Integer i3 = new Integer(10);
        System.out.println("Integer??????:" + (i1 == i3));
    }

    @Test
    public void test11() {
        // ????????????????????????"abc"??????????????????????????????????????????new????????????String???????????????????????????????????????????????????
        // ?????????????????????"abc"???????????????????????????str?????????????????????
        String i = "xyz";
        // ????????????????????????new??????String??????
        String j = new String("xyz");
        System.out.println(i == j);
        // ????????????????????????"abc"???????????????????????????????????????????????????????????????????????????????????????????????????
        // ?????????????????????"abc"?????????????????????????????????????????????????????????
        String ji = j.intern();
        System.out.println(i == ji);
        System.out.println(j == ji);
        String str = "Str";
        String ing = "ing";
        // ????????????????????????
        String string1 = "Str" + "ing";
        // ??????StringBuilder??????, ??????new String;
        String string2 = str + ing;
        System.out.println(string1 == string2);
    }

    @Test
    public void test12() {
        String x1 = new StringBuilder("hahaha").toString();
        String x2 = "hahaha";
        System.out.println(x1 == x1.intern());
    }

    @Test
    public void test13() {
        System.out.println(Timestamp.valueOf(LocalDateTime.now()).getTime());
        System.out.println(System.currentTimeMillis());
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.addPropertyAccessor(new MapAccessor());
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "bbb");
        context.setVariable("result", map);
        String template = "#{#result.aaa}";
        System.out.println(parser.parseExpression(template, new TemplateParserContext()).getValue(context, String.class));
    }

    @Test
    public void test14() {
        LocalDate first = LocalDate.now().minusDays(1);
        LocalDate second = LocalDate.now().minusDays(2);
        System.out.println(first.until(second, ChronoUnit.DAYS));
        System.out.println(second.until(first, ChronoUnit.DAYS));

//        LocalDate oneWeek = LocalDate.now().minusWeeks(0);
//        int oneWeekValue = oneWeek.getDayOfWeek().getValue();
//        Timestamp oneWeekStart = Timestamp.from(oneWeek.minusDays(oneWeekValue - 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        Timestamp oneWeekEnd = Timestamp.from(oneWeek.plusDays(7 - oneWeekValue).atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println(oneWeekStart);
//        System.out.println(oneWeekEnd);
    }

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

    private static void doSomething() {
        doSomething();
    }

    @Test
    public void test15() {
        System.out.println(Arrays.asList(1, 2, 2, 3).stream().distinct().collect(Collectors.toList()));
    }

    @Test
    public void test16() {
        System.out.println(Duration.between(LocalDateTime.now(), LocalDateTime.now().plusDays(5)).toDays());
    }
}
