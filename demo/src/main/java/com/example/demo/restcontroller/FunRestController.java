package com.example.demo.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHallo(){
        return "Hallo";
    }

    @GetMapping("/workout")
    public String  saySomething(){
        return "Hallo from workout";
    }
    @GetMapping("/other")
    public String  sayOtherStuff(){
        return "Hallo from the other side";
    }

    @GetMapping("/otherother")
    public String  otherother(){
        return "Hallo from the other side";
    }

}
