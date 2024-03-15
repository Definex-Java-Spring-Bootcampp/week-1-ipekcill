package com.patika.onlineshoppingservice.service;

import com.patika.onlineshoppingservice.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer (Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerByName (String name) {
        Optional<Customer> customerOpt = customers.stream().filter(f -> f.getName().equalsIgnoreCase(name)).findFirst();
        return customerOpt.orElse(null);
    }

    public int findCustomerCount (List<Customer> customers) {
        return customers.size();
    }
}
