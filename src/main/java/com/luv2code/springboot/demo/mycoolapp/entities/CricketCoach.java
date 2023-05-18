package com.luv2code.springboot.demo.mycoolapp.entities;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // This will create a new instance every time
@Primary
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In constructor:" + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Pratice fast bowling for 15 minutes";
    }
    
}
