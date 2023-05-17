package com.luv2code.springboot.demo.mycoolapp.entities;

import org.springframework.stereotype.Component;

import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Pratice fast bowling for 15 minutes";
    }
    
}
