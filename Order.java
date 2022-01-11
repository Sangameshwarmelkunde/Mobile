package com.model;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
//pojo class with required attributes,getters and setters
public class Order {
    @NotBlank(message = "{error.customerName.blank}")
    private String customerName;
    @NotBlank(message = "{error.contactNumber.blank}")
    private String contactNumber;
    private String productName;
    @Positive(message = "{error.quantity.negative}")
    private int quantity;
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
