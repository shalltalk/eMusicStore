package com.emusicstore.dao;

import com.emusicstore.model.Customer;

import java.util.List;

/**
 * Created by zhy on 2016/9/12.
 */
public interface CustomerDao {
    void addCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    Customer getCustomerByUsername(String username);
    List<Customer> getAllCustomers();
}
