package com.luv2code.springboot.demo.mycoolapp.entities;

import org.springframework.stereotype.Component;

import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

@Component
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In constructor:" + this.getClass().getSimpleName());
    }

	@Override
	public String getDailyWorkout() {
        return "Run a hard 5k";
    }

}
