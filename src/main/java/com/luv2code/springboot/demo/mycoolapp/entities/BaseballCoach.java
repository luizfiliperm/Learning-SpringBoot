package com.luv2code.springboot.demo.mycoolapp.entities;

import org.springframework.stereotype.Component;

import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

@Component
public class BaseballCoach implements Coach {

	public BaseballCoach(){
        System.out.println("In constructor:" + this.getClass().getSimpleName());
    }

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}
    
}
