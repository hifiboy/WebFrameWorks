package com.example.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springproject.model.Login;
import com.example.springproject.service.LoginService;

@RestController
public class LoginController {
    @Autowired
    LoginService ls;
    @PostMapping("/post")
    public ResponseEntity<Login> add(@RequestBody Login ll){
        Login log=ls.create(ll);
        return new ResponseEntity<>(log,HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Login>>show(){
        List<Login>obj=ls.getdetails();
        return new ResponseEntity<>(obj,HttpStatus.OK);


    }
    @PutMapping("/api/Login/{Username}")
    public ResponseEntity<Login> putMethodName(@PathVariable("Username") String Username, @RequestBody Login L) {
        if(ls.updateDetails(Username,L) == true)
        {
            return new ResponseEntity<>(L,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/Login/{Username}")
    public ResponseEntity<Boolean> delete(@PathVariable("Username") String Username)
    {
        if(ls.deleteUsername(Username) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
