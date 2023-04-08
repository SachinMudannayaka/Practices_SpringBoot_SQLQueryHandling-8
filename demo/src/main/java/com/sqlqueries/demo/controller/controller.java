package com.sqlqueries.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sqlqueries.demo.dto.Dto;
import com.sqlqueries.demo.service.service;

@RestController
@RequestMapping(value = "api/v/user")
@CrossOrigin
public class controller {
    @Autowired
    private service service;
    @PostMapping("/postUser")
    public Dto postUser(@RequestBody Dto dto){
     return service.postUser(dto);
    }
    @GetMapping("/getUser")
    public List<Dto> getUser(){
        return service.getUser();
    }
    @PutMapping("/editUser")
    public Dto editUser(@RequestBody Dto dto){
      return service.editUser(dto);
    }
    @DeleteMapping("/deleteUser")
    public Boolean deleteUser(@RequestBody Dto dto){
        return service.deleteUser(dto);
    }

    @GetMapping("/getUserByUserId/{userId}")
    public Dto getUserByUserId(@PathVariable String userId){
        return service.getUserByUserId(userId);
    }
}
