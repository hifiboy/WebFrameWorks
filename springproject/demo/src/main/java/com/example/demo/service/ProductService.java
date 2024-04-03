package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo Pr;
    public Product create(Product ll)
    {
        return Pr.save(ll);
    }
    public List<Product> getdetails()
    {
        return Pr.findAll();
    }
    public Product getproductname(String productname){
        return Pr.findById(productname).orElse(null);
    }
    public boolean deleteproductname(String productname)
        {
            if(this.getproductname(productname) == null)
            {
                return false;
            }
            Pr.deleteById(productname);
            return true;
        }
        public boolean updateDetails(String price,Product P)
        {
            if(this.getproductname(price)==null)
            {
                return false;
            }
            try{
                Pr.save(P);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
}
