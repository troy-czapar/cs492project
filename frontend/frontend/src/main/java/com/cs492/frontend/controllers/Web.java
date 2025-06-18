package com.cs492.frontend.controllers;

import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    
    // The following are routes that users can access in the web application.
    @GetMapping("/")
    public String home(Model model) {
        // Home page
        return "index";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        // Menu page
        // Fetch the menu entries from the MenuServiceClient and add them to the model
        model.addAttribute("pizzamenu", menu.getMenuEntries());
        return "menu";
    }

    @GetMapping("/cart")
    public String cart(Model model, @AuthenticationPrincipal OidcUser principal) {
        // Cart page
        // Fetch the cart ID from the user's claims and retrieve the order items and total price
        Map<String, String> claims = Utilities.getClaims(principal);
        Long cartId = Long.parseLong(claims.get("cartId"));
        System.out.println("Cart ID: " + cartId);
        model.addAttribute("orderitems", orders.getOrderItemsById(cartId));
        model.addAttribute("totalprice", orders.getTotalPriceById(cartId));
        return "cart";
    }

    @GetMapping(path = "/token_details")
    // This endpoint displays the details of the user's token.
    // This is just for testing purposes and should not be used in production.
    public String tokenDetails(Model model, @AuthenticationPrincipal OidcUser principal) {
        Map<String, String> claims = Utilities.getClaims(principal);
        
        model.addAttribute("claims", claims);

        return "tokendetails";
    }

    @GetMapping("/cart/addCartItem/{id}")
    @PreAuthorize("hasAuthority('APPROLE_customer') || hasAuthority('APPROLE_manager')")
    public String AddTocart(Model model, @AuthenticationPrincipal OidcUser principal,@PathVariable("id") Long id) {
        // This method adds an item to the cart.
        // It retrieves the cart ID from the user's claims and adds the item to the order.
        // Then it updates the model with the order items and total price.
        // The @PreAuthorize annotation ensures that only users with the specified roles can access this method

        Map<String, String> claims = Utilities.getClaims(principal);
        Long cartId = Long.parseLong(claims.get("cartId"));
        System.out.println("Cart ID: " + cartId);
        orders.addOrderItem(id,cartId);
        model.addAttribute("orderitems", orders.getOrderItemsById(cartId));
        model.addAttribute("totalprice", orders.getTotalPriceById(cartId));
        return "cart";
    }

    @GetMapping("/cart/removeCartItem/{id}")
    @PreAuthorize("hasAuthority('APPROLE_customer') || hasAuthority('APPROLE_manager')")
    public String RemoveFromcart(Model model, @AuthenticationPrincipal OidcUser principal,@PathVariable("id") Long id) {

        // This method removes an item from the cart.
        // It retrieves the cart ID from the user's claims and removes the item from the order.
        // Then it updates the model with the order items and total price.
        // The @PreAuthorize annotation ensures that only users with the specified roles can access this method
        
        Map<String, String> claims = Utilities.getClaims(principal);
        Long cartId = Long.parseLong(claims.get("cartId"));
        System.out.println("Cart ID: " + cartId);
        orders.removeOrderItem(id,cartId);
        model.addAttribute("orderitems", orders.getOrderItemsById(cartId));
        model.addAttribute("totalprice", orders.getTotalPriceById(cartId));
        return "cart";
    }

}