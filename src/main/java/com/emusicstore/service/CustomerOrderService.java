package com.emusicstore.service;

import com.emusicstore.model.CustomerOrder;

/**
 * Created by zhy on 2016/9/13.
 */
public interface CustomerOrderService {
    void addCustomerOrder(CustomerOrder customerOrder);
    double getCustomerOrderGrandTotal(int cartId);
}
