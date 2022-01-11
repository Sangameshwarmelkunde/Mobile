package com.service;
import org.springframework.stereotype.Service;
import com.model.Order;
//use appropriate annotation to configure BillService as a Service
@Service
public class BillService {
    // calculate the totalCost and return the cost
    public double calculateTotalCost(Order order) {
        double totalCost = 0.0;
        double cost = 0.0;
        int perProductPrice = 0;
        if (order.getProductName().equalsIgnoreCase("HeadPhone")) {
            perProductPrice = 450;
        } else if (order.getProductName().equalsIgnoreCase("TravelAdapter")) {
            perProductPrice = 1000;
        } else if (order.getProductName().equalsIgnoreCase("MemoryCard")) {
            perProductPrice = 300;
        } else if (order.getProductName().equalsIgnoreCase("PenDrive")) {
            perProductPrice = 650;
        } else if (order.getProductName().equalsIgnoreCase("USBCable")) {
            perProductPrice = 800;
        }
        cost = order.getQuantity() * perProductPrice;
        totalCost = cost + (cost * 3) / 100;
        // fill the code
        return totalCost;
    }
}