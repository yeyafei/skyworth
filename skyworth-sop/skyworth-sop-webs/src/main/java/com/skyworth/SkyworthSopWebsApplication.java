package com.skyworth;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication
//public class SkyworthSopWebsApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SkyworthSopWebsApplication.class, args);
//    }
//}

//@SpringBootApplication
//@EnableAspectJAutoProxy(exposeProxy = true)
//@EnableAsync 
@SpringBootApplication
@MapperScan(basePackages = {"com.skyworth.sop.*.dao"})
@EnableSwagger2
public class SkyworthSopWebsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SkyworthSopWebsApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SkyworthSopWebsApplication.class);
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
 
            System.out.println("Let's inspect the beans provided by Spring Boot:");
 
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
 
        };

    }
}