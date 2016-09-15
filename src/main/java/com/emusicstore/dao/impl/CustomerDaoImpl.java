package com.emusicstore.dao.impl;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Authorities;
import com.emusicstore.model.Cart;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhy on 2016/9/12.
 */
@Repository
@Transactional
//Transactional: hibernate can invoke the transaction about database operation
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        try {
            Session session = sessionFactory.getCurrentSession();
            customer.getBillingAddress().setCustomer(customer);
            customer.getShippingAddress().setCustomer(customer);

            session.saveOrUpdate(customer);
            session.saveOrUpdate(customer.getBillingAddress());
            session.saveOrUpdate(customer.getShippingAddress());

            Users newUser = new Users();
            newUser.setUsername(customer.getUsername());
            newUser.setPassword(customer.getPassword());
            newUser.setEnabled(true);
            newUser.setCustomerId(customer.getCustomerId());

            Authorities newAuthority = new Authorities();
            newAuthority.setUsername(customer.getUsername());
            newAuthority.setAuthority("ROLE_USER");
            session.saveOrUpdate(newUser);
            session.saveOrUpdate(newAuthority);

            //generate cart, bind it to customer
            Cart newCart = new Cart();
            newCart.setCustomer(customer);
            customer.setCart(newCart);
            session.saveOrUpdate(customer);// we have called setCustomer here, so we need persist it again
            session.saveOrUpdate(newCart);

            session.flush();
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException is thrown in due to empty fields.");
            ex.printStackTrace();
        }
    }

    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;
    }

    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);
        return (Customer) query.uniqueResult();
    }
}
