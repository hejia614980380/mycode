package com.hejia.annotationconfigapplicationcontext.config;

import com.hejia.annotationconfigapplicationcontext.bean.Car;
import com.hejia.annotationconfigapplicationcontext.bean.Company;
import com.hejia.annotationconfigapplicationcontext.bean.Company1;
import com.hejia.annotationconfigapplicationcontext.bean.Person;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.hejia.annotationconfigapplicationcontext")
//@Import(OtherConfig.class)
public class AppConfig {

    /**
     * 自动注入容器中的Car对象
     * @param car
     * @return
     */
//    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Bean
//    @Scope("prototype")
    public Person person(Car car) {
        return new Person(car);
    }

    @Bean
    public Company company() {
        Company company = new Company();
        company.setCar(car());
        return company;
    }

    @Bean
//    @Profile("test")
    public Company1 company1() {
        Company1 company = new Company1();
        company.setCar(car());
        return company;
    }

    @Bean
    public Car car() {
        return new Car(1, "湘A21G2J", "保时捷");
    }
}
