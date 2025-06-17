package com.cs492.frontend.controllers;

import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cs492.frontend.apiclient.MenuServiceClient;
import com.cs492.frontend.apiclient.OrdersServiceClient;
import com.cs492.frontend.Utilities;

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

    @GetMapping(path = "/token_details")
    public String tokenDetails(Model model, @AuthenticationPrincipal OidcUser principal) {
        Map<String, String> claims = Utilities.filterClaims(principal);
        
        model.addAttribute("claims", claims);

        return "tokendetails";
    }


}