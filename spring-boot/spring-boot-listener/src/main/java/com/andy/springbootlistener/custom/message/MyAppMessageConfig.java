package com.andy.springbootlistener.custom.message;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.andy.springbootlistener.custom.message"})
@EnableConfigurationProperties
public class MyAppMessageConfig {

}
