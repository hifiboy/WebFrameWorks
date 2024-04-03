package com.example.demo.controller;

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

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;;

@RestController
public class ProductController {
    @Autowired
    ProductService ps;
    @PostMapping("/post")
    public ResponseEntity<Product> add(@RequestBody Product ll){
        Product log=ps.create(ll);
        return new ResponseEntity<>(log,HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Product>>show(){
        List<Product>obj=ps.getdetails();
        return new ResponseEntity<>(obj,HttpStatus.OK);


    }
    @PutMapping("/api/Product/{productname}")
    public ResponseEntity<Product> putMethodName(@PathVariable("productname") String productname, @RequestBody Product P) {
        if(ps.updateDetails(productname,P) == true)
        {
            return new ResponseEntity<>(P,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/Product/{productname}")
    public ResponseEntity<Boolean> delete(@PathVariable("productname") String productname)
    {
        if(ps.deleteproductname(productname) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
