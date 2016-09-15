package com.emusicstore.service.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
import com.emusicstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * Created by zhy on 2016/9/12.
 */

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartDao cartDao;
    public Cart getCartById(int cartId){
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart){
        cartDao.update(cart);
    }
}
