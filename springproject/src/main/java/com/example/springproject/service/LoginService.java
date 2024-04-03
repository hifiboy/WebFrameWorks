package com.example.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.springproject.model.Login;
import com.example.springproject.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    LoginRepo lr;
    public Login create(Login ll)
    {
        return lr.save(ll);
    }
    public List<Login> getdetails()
    {
        return lr.findAll();
    }
    public Login getUsername(String username){
        return lr.findById(username).orElse(null);
    }
    public boolean deleteUsername(String Username)
        {
            if(this.getUsername(Username) == null)
            {
                return false;
            }
            lr.deleteById(Username);
            return true;
        }
        public boolean updateDetails(String password,Login L)
        {
            if(this.getUsername(password)==null)
            {
                return false;
            }
            try{
                lr.save(L);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
}
