package com.example.bookstore.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.Entity.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>();

    // POST method to create a new customer using JSON request body
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customerList.add(customer);
        return customer;
    }
 // POST method to process form data for customer registration
    @PostMapping("/register")
    public Customer registerCustomer(@RequestParam("name") String name,
                                     @RequestParam("email") String email,
                                     @RequestParam("password") String password) {
        Customer customer = new Customer(null, name, email, password);
        customerList.add(customer);
        return customer;
    }
 // GET method to retrieve all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerList;
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                customerList.remove(customer);
                return "Customer: " + id + " has been deleted.";
            }
        }
        return "Customer:" + id + " not found.";
    }
}

