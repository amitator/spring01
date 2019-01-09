package ru.otus.spring.hw01.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
    private String bundle;

    public String getBundle(){
        return bundle;
    }

    public void setBundle(String bundle){
        this.bundle = bundle;
    }
}
