package be.digitcom.streams.services;


import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greet() {
        return "Hello, World";
    }
}
