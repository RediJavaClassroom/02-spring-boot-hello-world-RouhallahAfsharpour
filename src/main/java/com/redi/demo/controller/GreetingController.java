package com.redi.demo.controller;

import com.redi.demo.domain.Greeting;
import com.redi.demo.domain.GreetingStatistics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private AtomicLong counter = new AtomicLong(); // unique id always
    public HashMap<String,Integer> greetStatistics = new HashMap<>();
    public List<GreetingStatistics> greetingStatistics = new ArrayList<>();

    @GetMapping("greeting")
    public Greeting greet(@RequestParam(value="name", defaultValue = "world") String name){ //default in case no name is defined by user - value is optional

        if(greetStatistics.containsKey(name)){
            greetStatistics.put(name,greetStatistics.get(name)+1);
        }else {
            greetStatistics.put(name,1);
        }
        return new Greeting(counter.incrementAndGet(),"Hello, " + name + "!");
    }

    @GetMapping("statistics")
    public List<GreetingStatistics> GreetingStatistics(){
        greetStatistics.forEach((key, value) -> greetingStatistics.add(new GreetingStatistics(key,value)));
        return greetingStatistics;
    }

}
