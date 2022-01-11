package com.controller;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.model.Order;
import com.service.BillService;
//use appropriate annotation to configure BillController as Controller
@Controller
public class BillController {
    @Autowired
    BillService service;
    @ModelAttribute("productList")
    public Map < String, String > populateProductType() {
        Map < String, String > serviceMap = new HashMap < String, String > ();
        serviceMap.put("HeadPhone", "HeadPhone");
        serviceMap.put("TravelAdapter", "TravelAdapter");
        serviceMap.put("MemoryCard", "MemoryCard");
        serviceMap.put("PenDrive", "PenDrive");
        serviceMap.put("USBCable", "USBCable");
        return serviceMap;
    }
    @GetMapping("/showPage")
    public String showPage(@ModelAttribute("order") Order order) {
        return "showpage";
    }
    // invoke the service class - calculateTotalCost method.
    @PostMapping("/billDesk")
    public String calculateTotalCost(@Valid @ModelAttribute("order") Order order,
        BindingResult result,
        ModelMap model) {
        // fill the code here
        if (result.hasErrors()) {
            return "showpage";
        } else {
            double totalCost = service.calculateTotalCost(order);
            model.put("customerName", order.getCustomerName());
            model.put("totalCost", totalCost);
            return "billdesk";
        }
    }
}