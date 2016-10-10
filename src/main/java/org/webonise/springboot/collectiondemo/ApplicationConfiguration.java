package org.webonise.springboot.collectiondemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public HashMap<Integer, User> getHashMap() {
        return new HashMap<>();
    }
}
