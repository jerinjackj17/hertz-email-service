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

    // product id for reservation email
    private String vehicleId;

    // search criteria for not available email
    private String searchCriteria;

    // all product fields needed to fill the email template placeholders
    private String vehicleCategory;
    private String vehicleSize;
    private String vehicleType;
    private String vehicleDriveType;
    private String vehicleDuration;
    private String vehiclePrice;
    private String validFrom;
    private String validTo;

    public EmailRequestDTO() {}

    // used by birthday email flow — keep this intact
    public EmailRequestDTO(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
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

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleDriveType() {
        return vehicleDriveType;
    }

    public void setVehicleDriveType(String vehicleDriveType) {
        this.vehicleDriveType = vehicleDriveType;
    }

    public String getVehicleDuration() {
        return vehicleDuration;
    }

    public void setVehicleDuration(String vehicleDuration) {
        this.vehicleDuration = vehicleDuration;
    }

    public String getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(String vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }
}