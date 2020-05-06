package com.myfirstapp.controller;
import org.springframework.web.bind.annotation.*;
import com.myfirstapp.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "hello world !!!";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "fName") String fName, @RequestParam(value = "lName") String lName) {
        return "Hello" + " " + fName + " " + lName + "!";
    }

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + User.getFirstName() + " " + User.getLastName() + "!";
    }

    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello" + " " + firstName + " " + lastName + "!";
    }
}