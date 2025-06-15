package com.cs492.frontend.apiclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cs492.frontend.apiclient.datatypes.MenuEntry;

// This service client interacts with the menu API to fetch menu entries.

@Service
public class MenuServiceClient {
    private final String apiUrl = "http://localhost:8080/pizza/menu/";

    public MenuEntry[] getMenuEntries() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, MenuEntry[].class);
    }

    public MenuEntry getMenuEntryById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/" + id;
        return restTemplate.getForObject(url, MenuEntry.class);
    }
}
    
    
    


