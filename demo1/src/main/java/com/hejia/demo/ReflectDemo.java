package com.hejia.demo;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
    @Test
    public void test1() {
        Student student = new Student();
        student.setGender(Gender.Male);
        Class<? extends Student> aClass = student.getClass();
        try {
            Field gender = aClass.getDeclaredField("gender");
            gender.setAccessible(true);
            Class<?> type = gender.getType();
            if (type == Class.forName("com.hejia.demo.Gender")) {
                Method method = aClass.getDeclaredMethod("getGender");
                method.setAccessible(true);
                Object invoke = method.invoke(student);
                Gender invoke1 = (Gender) invoke;
                System.out.println(invoke1.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
