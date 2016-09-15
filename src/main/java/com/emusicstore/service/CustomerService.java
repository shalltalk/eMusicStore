package com.emusicstore.service;

import com.emusicstore.model.Customer;

import java.util.List;

/**
 * Created by zhy on 2016/9/12.
 */
public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    List<Customer> getAllCustomers();
    Customer getCustomerByUsername(String username);
}
