package com.burwasolution.vishwakarma;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableMongoAuditing
@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class MainApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
