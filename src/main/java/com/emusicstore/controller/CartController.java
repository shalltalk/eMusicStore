package com.emusicstore.controller;

import com.emusicstore.model.Customer;
import com.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhy on 2016/9/12.
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    // in order to use @AuthenticationPrincipal, a bean is added in the dispatcher-servlet:
    // <bean class="org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver"></bean>
    public String getCart(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cartId = customer.getCart().getCartId();
        return "redirect:/customer/cart/" + cartId;
    }

    // Get cartId, add it to model, so that cart.jsp can use this ID to communicate with the backend (rest service)
    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model){
        model.addAttribute("cartId", cartId);
        return "cart";
    }
}
