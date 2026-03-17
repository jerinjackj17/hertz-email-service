package com.hertz.emailservice.controller;

import com.hertz.emailservice.dto.EmailRequestDTO;
import com.hertz.emailservice.service.EmailService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // Birthday email
    @PostMapping("/birthday")
    public ResponseEntity<String> sendBirthdayEmail(
            @Valid @RequestBody EmailRequestDTO request) {

        emailService.sendBirthdayEmail(request);

        return ResponseEntity.ok("Birthday email sent");
    }

    // Vehicle NOT AVAILABLE email
    @PostMapping("/vehicle/not-available")
    public ResponseEntity<String> sendVehicleNotAvailableEmail(
            @Valid @RequestBody EmailRequestDTO request) {

        emailService.sendVehicleNotAvailableEmail(request);

        return ResponseEntity.ok("Vehicle not available email sent");
    }

    // Vehicle RESERVATION email
    @PostMapping("/vehicle/reservation")
    public ResponseEntity<String> sendVehicleReservationEmail(
            @Valid @RequestBody EmailRequestDTO request) {

        emailService.sendVehicleReservationEmail(request);

        return ResponseEntity.ok("Vehicle reservation email sent");
    }
}