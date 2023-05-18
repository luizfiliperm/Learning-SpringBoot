package com.luv2code.springboot.demo.mycoolapp.entities;

import org.springframework.stereotype.Component;

import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
    
}
