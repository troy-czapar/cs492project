package com.cs492.frontend.apiclient;

import java.util.ArrayList;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cs492.frontend.apiclient.datatypes.MenuEntry;
import com.cs492.frontend.apiclient.datatypes.OrderEntry;

// This service client interacts with the orders API to fetch and manage orders.

@Service
public class OrdersServiceClient {
    private final String apiUrl = "http://localhost:8080/pizza/orders/";
    private final MenuServiceClient menuServiceClient = new MenuServiceClient();
    

    // public OrderEntry[] getOrders() {
    //     RestTemplate restTemplate = new RestTemplate();
    //     return restTemplate.getForObject(apiUrl, OrderEntry[].class);
    // }

    // public OrderEntry getOrderById(Long id) {
    //     RestTemplate restTemplate = new RestTemplate();
    //     String url = apiUrl + id;
    //     return restTemplate.getForObject(url, OrderEntry.class);
    // }

    public Long getTotalPriceById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + id;
        OrderEntry order = restTemplate.getForObject(url, OrderEntry.class);
        Long price = order.getTotalPrice();
        return price;
    }

    public MenuEntry[]  getOrderItemsById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + id;
        OrderEntry order = restTemplate.getForObject(url, OrderEntry.class);
        ArrayList<Long> items = order.getItems();
        
        if (items == null || items.isEmpty()) {
            return new MenuEntry[0]; // Return an empty array if there are no items
        }

        System.out.println("Number of items in order: " + items.size());

        MenuEntry[] itemsArray = new MenuEntry[items.size()];

        Integer index = 0;

        for (Long itemId : items)
        {
            
            MenuEntry menuItem = menuServiceClient.getMenuEntryById(itemId);
            if (menuItem != null) {
                System.out.println("Menu item with ID " + itemId);
                System.out.println("Name: " + menuItem.getName());
                itemsArray[index] = menuItem;
                index++;
            } else {
                // Handle the case where the menu item is not found
                System.out.println("Menu item with ID " + itemId + " not found.");
            }
        }
        
        return itemsArray;
    }

    public void addOrderItem(Long id, Long orderId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + orderId + "/add/" + id ;
        Object order = restTemplate.execute(url, HttpMethod.POST, null, response -> {
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to add order item: " + response.getStatusCode());
            }
        });
         
    }
    public void removeOrderItem(Long id, Long orderId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + orderId + "/remove/" + id ;
        Object order = restTemplate.execute(url, HttpMethod.POST, null, response -> {
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to remove order item: " + response.getStatusCode());
            }
        });
         
    }
    // public MenuEntry[]  getOrderItemsById(Long id) {
    //     RestTemplate restTemplate = new RestTemplate();
    //     String url = apiUrl + id;
    //     return restTemplate.getForObject(url, MenuEntry[].class);
    // }

    // public OrderEntry createOrder(OrderEntry order) {
    //     RestTemplate restTemplate = new RestTemplate();
    //     return restTemplate.postForObject(apiUrl, order, OrderEntry.class);
    // }
    
    
}
