package com.example.demo.rest;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/find/{id}")
    public User findById(@PathVariable("id") final String id){
        return userRepository.findById(id);
    }

    @GetMapping(value = "/add/{id}/{name}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name){
        userRepository.save(new User(id, name, 20000L));
        return userRepository.findById(id);
    }

    @GetMapping(value = "/update/{id}/{name}")
    public User update(@PathVariable("id") final String id,
                    @PathVariable("name") final String name){
        userRepository.update(new User(id, name, 20000L));
        return userRepository.findById(id);
    }

    @GetMapping(value = "/all")
    public Map<String, User> getAll(){
        return userRepository.findAll();
    }

}
