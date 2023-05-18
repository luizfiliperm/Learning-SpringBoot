package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

@RestController
public class DemoController {
    
    // define a private field for the dependecy
    private Coach myCoach;
    private Coach anotherCoach;

    // define a constructor for the dependecy injection
    // @Autowired (Optional if there is only one constructor)
    public DemoController(Coach theCoach, Coach theAnotherCoach){
        System.out.println("In constructor:" + this.getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
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

    @GetMapping("/check")
    public String check(){
        return "Comparing Beans: my coach == another coach: " + (myCoach == anotherCoach);
    }
}
