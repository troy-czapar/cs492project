package com.cs492.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cs492.frontend.apiclient.MenuServiceClient;
import com.cs492.frontend.apiclient.OrdersServiceClient;

// This controller handles web requests and serves the frontend views.

@Controller
public class Web {

    private final MenuServiceClient menu;
    private final OrdersServiceClient orders;
    

    // Default Constructor
    public Web(MenuServiceClient menu, OrdersServiceClient orders) {
        this.menu = menu;
        this.orders = orders;
    }

    
    // Here we load up any attributes we want to be able to use with
    // the HTML/Javascript frontend
    // return index loads up index.html
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pizzamenu", menu.getMenuEntries());
        model.addAttribute("orderitems", orders.getOrderItemsById(1L));
        model.addAttribute("totalprice", orders.getTotalPriceById(1L));
        return "index";
    }


}