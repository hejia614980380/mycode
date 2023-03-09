package com.hejia.annotationconfigapplicationcontext.config;

import com.hejia.annotationconfigapplicationcontext.bean.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {
    @Bean
    public Teacher teacher() {
        return new Teacher();
    }
}
