package com.andy.mycustombanner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MyCustomBannerApplication {

    public static void main(String[] args) {
        log.info("Main method Start");
        SpringApplication springApplication = new SpringApplication(MyCustomBannerApplication.class);
        springApplication.run(args);
        log.info("Main method End");
    }

}
