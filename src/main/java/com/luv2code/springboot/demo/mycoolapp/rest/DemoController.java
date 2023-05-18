package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

@RestController
public class DemoController {
    
    // define a private field for the dependecy
    private Coach myCoach;

    // define a constructor for the dependecy injection
    // @Autowired (Optional if there is only one constructor)
    public DemoController(@Qualifier("tennisCoach") Coach theCoach){
        myCoach = theCoach;
    }

    // define a setter method for the dependecy injection
    // @Autowired
    // public void setMyCoach(Coach theCoach){
    //     myCoach = theCoach;
    // }

    @GetMapping("/dailyworkout")
    public String getDailyWorlout(){
        return myCoach.getDailyWorkout();
    }
}
