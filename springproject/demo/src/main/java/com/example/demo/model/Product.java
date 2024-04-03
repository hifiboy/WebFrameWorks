package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private String productname;
    private String productdetails;
    private String price;
   
    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }
    public String getProductdetails() {
        return productdetails;
    }
    public void setProductdetails(String productdetails) {
        this.productdetails = productdetails;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Product() {
    }
    public Product(String  productname, String  productdetails, String price) {
        this. productname =  productname;
        this.productdetails =  productdetails;
        this.price = price;
    }
    
}
