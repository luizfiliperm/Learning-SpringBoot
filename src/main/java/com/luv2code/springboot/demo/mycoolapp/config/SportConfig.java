package com.luv2code.springboot.demo.mycoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.springboot.demo.mycoolapp.entities.SwimCoach;
import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

@Configuration
public class SportConfig {
    
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
