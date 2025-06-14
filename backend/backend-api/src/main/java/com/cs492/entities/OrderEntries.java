package com.cs492.entities;

import java.util.ArrayList;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class OrderEntries {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private ArrayList<Long> items = new ArrayList<>();
    private Long totalPrice=0L; // Default total price is 0
    private String status = OrderStatus.PENDING; // Default status is PENDING

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;        
    }

    public Long getTotalPrice(){
        return totalPrice;
    }



    public ArrayList<Long> getItems(){
        if (items == null) {
            items = new ArrayList<>();
        }

        return items;
    }

    public void addItem(Long item,Long price){
        this.totalPrice += price;        
        this.items.add(item);        
    }

    public void removeItem(Long item,Long price){

        if (this.items.size() == 0) {
            System.out.println("No items to remove.");
            return;
        }
        if (!this.items.contains(item)) {
            System.out.println("Item not found in the order.");
            return;
        }
        this.totalPrice -= price;
        this.items.remove(item);
    }




    public String getStatus(){
        return status;
    }
    
    public void setStatusComplete(Integer status) {
        this.status = OrderStatus.COMPLETED;        
    }

    public void setStatusPending(Integer status) {
        this.status = OrderStatus.PENDING;        
    }

    public void setStatusCanceled(Integer status) {
        this.status = OrderStatus.CANCELED;        
    }


}



