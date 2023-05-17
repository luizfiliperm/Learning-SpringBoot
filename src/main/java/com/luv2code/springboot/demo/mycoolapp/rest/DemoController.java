package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.mycoolapp.entities.interfaces.Coach;

@RestController
public class DemoController {
    
    // define a private field for the dependecy
    private Coach myCoach;

    // define a constructor for the dependecy injection
    // @Autowired (Optional if there is only one constructor)
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorlout(){
        return myCoach.getDailyWorkout();
    }
}
