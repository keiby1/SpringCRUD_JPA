package com.example.demo.Controller;

import com.example.demo.DTO.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController() {
        service = null;
    }

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    public void add(@RequestParam(name = "id") Long id, @RequestParam(name = "name") String name, @RequestParam(name = "phone") String phone){
        System.out.println(id+ " "+ name + " "+ phone);
        service.save(new User(id, name, phone));
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return service.save(user).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PostMapping("/save/all")
    public ResponseEntity<List<User>> saveAll(@RequestBody List<User> users) {
        return new ResponseEntity<>(service.saveAll(users), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<User> get(@RequestParam Long id) {
        return service.get(id).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/all/ids")
    public ResponseEntity<List<User>> getAllById(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(service.getAllById(ids), HttpStatus.OK);
    }
}