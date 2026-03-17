package com.hertz.emailservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/*
 * Request body used by Email API
 */
public class EmailRequestDTO {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    // vehicle id for reservation email
    private String vehicleId;

    // search criteria for not available email
    private String searchCriteria;

    // vehicle name for reservation email
    private String vehicleName;

    // vehicle type for reservation email
    private String vehicleType;

    public EmailRequestDTO() {}

    public EmailRequestDTO(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
    }

    public EmailRequestDTO(String customerName, String email,
                           String vehicleId, String searchCriteria) {
        this.customerName = customerName;
        this.email = email;
        this.vehicleId = vehicleId;
        this.searchCriteria = searchCriteria;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}