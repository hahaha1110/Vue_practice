package com.bitcamp.web.controller;

import java.util.HashMap;

import com.bitcamp.web.common.util.Printer;
import com.bitcamp.web.domain.CustomerDTO;
import com.bitcamp.web.service.CustomerService;

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


@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired CustomerService customerService;
    @Autowired CustomerDTO customer;
    @Autowired Printer p;


    // @PostMapping("")
    // public HashMap<String,Object> join(@RequestBody CustomerDTO param){
        
    //     HashMap<String,Object> map = new HashMap<>();
    //     p.accept("POST 진입 ");
    //     map.put("result", "SUCCESS");
    //     return map; 
    // }

    @PostMapping("/join")
    public HashMap<String,Object> join(@RequestBody HashMap<String, Object> param){
        System.out.println("CustomerController join() 경로로 들어옴");
        System.out.println(param);
        System.out.println(param.get("id"));
        System.out.println(param.get("pass"));
        HashMap<String,Object> map = new HashMap<>();
        map.put("result", param.get("id")+"가입 SUCCESS");
        
        return map; 
    }

    @GetMapping("/page/{pageNum}")
    public HashMap<String, Object> list(@PathVariable String pageNum){
       HashMap<String, Object> map = new HashMap<>();
       
       return map;
    }

    @GetMapping("/count")   
    public String count() {
        System.out.println("CustomerController count() 경로로 들어옴");
        Long count = customerService.countAll();
        return String.valueOf(count);
    }

    @GetMapping("/{customerId}/{password}")
    public CustomerDTO login(@PathVariable("customerId")String id,
                        @PathVariable("password")String pass){
        // CustomerDTO a = new 
        //         CustomerDTO();
        customer.setCustomerId(id);
        customer.setPassword(pass);
        // return customerService.login(customer);
        return null;
    }

   
    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable String customerId) {
        // HashMap<String,Object> map = new HashMap<>();
        p.accept("Get 진입 "+customerId);
        customer.setCustomerId("hong");
        return customer; 
    }

    @PutMapping("/{customerId}")
    public HashMap<String,Object> updateCustomer(@PathVariable String customerId) {
        HashMap<String,Object> map = new HashMap<>();
        p.accept("PUT 진입: "+customerId);
        map.put("result","SUCCESS");
        return map;
    }

    @DeleteMapping("/{customerId}")
    public HashMap<String,Object> deleteCustomer(@PathVariable String customerId) {
        HashMap<String, Object> map = new HashMap<>();
        p.accept("DELETE 진입: "+customerId);
        customer.setCustomerId(customerId);
        map.put("result","SUCCESS");
        return map;
    }
}