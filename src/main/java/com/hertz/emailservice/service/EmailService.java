package com.hertz.emailservice.service;

import com.hertz.emailservice.dto.EmailRequestDTO;

/*
 * EmailService
 *
 * Defines operations for sending system emails.
 */
public interface EmailService {

    // birthday notification
    void sendBirthdayEmail(EmailRequestDTO request);

    // vehicle not available notification
    void sendVehicleNotAvailableEmail(EmailRequestDTO request);

    // reservation confirmation
    void sendVehicleReservationEmail(EmailRequestDTO request);
}