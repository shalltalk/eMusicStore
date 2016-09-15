package com.emusicstore.dao;

import com.emusicstore.model.Cart;

import java.io.IOException;

/**
 * Created by zhy on 2016/9/8.
 */
public interface CartDao {
    Cart getCartById(int cartId);
    void update(Cart cart);
    Cart validate(int cartId) throws IOException;
}
