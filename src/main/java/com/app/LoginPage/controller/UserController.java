package com.app.LoginPage.controller;

import com.app.LoginPage.model.User;
import com.app.LoginPage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData){
        System.out.println(userData);
        Optional<User> user = userRepository.findById(userData.getUsuario());
        if(user.get().getSenha().equals(userData.getSenha())){
            return ResponseEntity.ok(user);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

    @GetMapping()
    public ResponseEntity<List<User>> userList(){
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
