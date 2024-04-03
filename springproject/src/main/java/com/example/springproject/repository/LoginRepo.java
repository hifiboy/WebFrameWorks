package com.example.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springproject.model.Login;

public interface LoginRepo extends JpaRepository<Login,String> {
    
}