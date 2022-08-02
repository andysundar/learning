package com.andy.springbootlistener.custom.message;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(MyAppMessageProperties.PREFIX)
public class MyAppMessageProperties {

    public static final String PREFIX = "myapp.message";
}
