package com.myfirstapp.service;

import com.myfirstapp.exception.GreetingException;
import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;

import java.util.List;
import java.util.ListIterator;

public interface IGreetingService {
    Greeting addGreeting(User user);

    List<Greeting> getAllGreetings();

    Greeting getGreetingById(Long id) throws GreetingException;

    Greeting updateGreeting(User user, Long id) throws GreetingException;

    List<Greeting> deleteGreeting(Long id) throws GreetingException;

    void deleteAllGreeting();
}