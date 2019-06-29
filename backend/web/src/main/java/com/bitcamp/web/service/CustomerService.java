package com.bitcamp.web.service;


import java.util.List;
import java.util.Optional;

import com.bitcamp.web.domain.CustomerDTO;
import com.bitcamp.web.entities.Customer;
import com.bitcamp.web.service.CustomerService;
import com.bitcamp.web.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 */
@Service
public class CustomerService{
    @Autowired CustomerRepository customerRepository;

    public Long countAll() {
        return customerRepository.count();
        
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        
    }

    public void deleteCustomer(Iterable<Customer> it){
        customerRepository.deleteAll(it);
    }

    public void deleteAll(){
        customerRepository.deleteAll();
    }


    public boolean exist(Long id){
        return customerRepository.existsById(id);
    }
  
 
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    public List<CustomerDTO> findCustomers() {
        // Iterable<Customer> customer = customerRepository.findAll();
        // List<CustomerDTO> list = new ArrayList<>();
        // list = customerRepository.findAll();
        return null;
    }

    public Iterable<Customer> findAll(){//findCustomers으로 대체
        return customerRepository.findAll();
    }

    public Iterable<Customer> findAll(Iterable<Customer> it){//findCustomers으로 대체
        return findAll(it);
    }

    public List<CustomerDTO> findCustomersByOption(CustomerDTO option) {
        return null;
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public CustomerDTO findByCustomerId(String customerId) {
        
        return customerRepository.findByCustomerId(customerId);
        // return null;
    }

    public Iterable<Customer> save(Iterable<Customer> it){
        return customerRepository.saveAll(it);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public int updateCustomer(CustomerDTO customer) {
        int res = 0;
        if(res == 1){
            System.out.println("서비스 수정성공");
        }else{
            System.out.println("서비스 수정실패");
        }
        return res;
    }


    public CustomerDTO login(Customer customer) {
        System.out.println("컨트롤러에서 넘어온 ID: "+customer.getCustomerId());
        System.out.println("컨트롤러에서 넘어온 PASS: "+customer.getPassword());
        return customerRepository.login(customer);
    }

    
}