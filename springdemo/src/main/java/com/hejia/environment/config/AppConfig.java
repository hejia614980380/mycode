package com.hejia.environment.config;

import com.hejia.environment.bean.Car;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.hejia.environment")
@PropertySource("car.properties")
public class AppConfig {
    @Bean
//    @Profile("default")
//    @Profile("test")
    public Car car() {
        return new Car(1, "湘A21G2J", "帕拉梅拉");
    }
}
