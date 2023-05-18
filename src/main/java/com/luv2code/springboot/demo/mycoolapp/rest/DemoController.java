package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
public class DemoController {
    
    // define a private field for the dependecy
    private Coach myCoach;

    // define a constructor for the dependecy injection
    // @Autowired (Optional if there is only one constructor)
    public DemoController(Coach theCoach){
        System.out.println("In constructor:" + this.getClass().getSimpleName());
        myCoach = theCoach;
    }

    // define a setter method for the dependecy injection
    // @Autowired
    // public void setMyCoach(Coach theCoach){
    //     myCoach = theCoach;
    // }

    // define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In init method:" + this.getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In destroy method:" + this.getClass().getSimpleName());
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorlout(){
        return myCoach.getDailyWorkout();
    }

}
