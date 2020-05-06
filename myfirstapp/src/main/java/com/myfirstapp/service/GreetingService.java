package com.myfirstapp.service;
import com.myfirstapp.exception.GreetingException;
import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class GreetingService implements IGreetingService{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getGreetingById(Long id) throws GreetingException {
        return greetingRepository.findById(id).orElseThrow(() -> new GreetingException("No Record Available"));
    }

    @Override
    public Greeting updateGreeting(User user, Long id) throws GreetingException {
        if (!greetingRepository.existsById(id)) throw new GreetingException("Record Can Not Be Update");
        Greeting greeting = getGreetingById(id);
        String message = String.format(template, (user.toString().isEmpty()) ? "World" : user.toString());
        return greetingRepository.save(new Greeting(greeting.getId(), message));
    }

    @Override
    public List<Greeting> deleteGreeting(Long id) throws GreetingException {
        if (!greetingRepository.existsById(id)) throw new GreetingException("Record Can Not Be Deleted");
        greetingRepository.deleteById(id);
        return getAllGreetings();
    }


    @Override
    public void deleteAllGreeting() {
        greetingRepository.deleteAll();
    }
}