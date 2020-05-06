
package com.myfirstapp.controller;
import com.myfirstapp.exception.GreetingException;
import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @PostMapping(value = {"/post"})
    public Greeting addGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/getAll/greeting")
    public List<Greeting> findGreeting() {
        return greetingService.getAllGreetings();
    }

    @GetMapping(value = "/get/greeting/{id}")
    public Greeting findByIdGreeting(@PathVariable(value = "id") Long id) throws GreetingException {
        return greetingService.getGreetingById(id);
    }

    @PutMapping("/update/greeting")
    public Greeting updateGreeting(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String firstName) throws GreetingException {
        User user = new User();
        user.setFirstName(firstName);
        return greetingService.updateGreeting(user, id);
    }

    @DeleteMapping(value = "/delete/greeting")
    public List<Greeting> deleteGreeting(@RequestParam(value = "id") Long id) throws GreetingException {
        return greetingService.deleteGreeting(id);
    }

    @DeleteMapping(value = {"/deleteAll"})
    public String deleteAllGreeting() {
        greetingService.deleteAllGreeting();
        return "Deleted All this Greetings ==>> " + greetingService.getAllGreetings() + " Successfully";
    }
}