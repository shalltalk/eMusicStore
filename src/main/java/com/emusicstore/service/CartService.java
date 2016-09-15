package com.emusicstore.service;

import com.emusicstore.model.Cart;

/**
 * Created by zhy on 2016/9/12.
 */
public interface CartService {

    Cart getCartById(int cartId);
    void update(Cart cart);
}
