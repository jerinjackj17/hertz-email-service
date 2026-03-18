package com.hertz.emailservice.service;

import com.hertz.emailservice.dto.EmailRequestDTO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.mail.internet.MimeMessage;

import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    private static final Logger logger =
            LoggerFactory.getLogger(EmailServiceImpl.class);

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /*
     * Birthday Email
     */
    @Override
    public void sendBirthdayEmail(EmailRequestDTO request) {

        try {

            logger.info("Preparing birthday email for {}", request.getEmail());

            String subject = "Happy Birthday";

            ClassPathResource resource =
                    new ClassPathResource("templates/birthday-email.html");

            String htmlContent =
                    new String(resource.getInputStream().readAllBytes(),
                    StandardCharsets.UTF_8);

            // replace name and email placeholders in birthday template
            htmlContent = htmlContent.replace("{{customerName}}", request.getCustomerName());
            htmlContent = htmlContent.replace("{{email}}", request.getEmail());

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(request.getEmail());
            helper.setSubject(subject);
            helper.setText(htmlContent, true);

            mailSender.send(message);

            logger.info("Birthday email sent successfully to {}", request.getEmail());

        } catch (Exception ex) {

            logger.error("Failed to send birthday email", ex);

            throw new RuntimeException("Email sending failed");
        }
    }

    /*
     * Vehicle Not Available Email
     */
    @Override
    public void sendVehicleNotAvailableEmail(EmailRequestDTO request) {

        try {

            logger.info("Preparing VEHICLE_NOT_AVAILABLE email for {}", request.getEmail());

            String subject = "Vehicle Not Available";

            ClassPathResource resource =
                    new ClassPathResource("templates/vehicle-not-available.html");

            String htmlContent =
                    new String(resource.getInputStream().readAllBytes(),
                    StandardCharsets.UTF_8);

            // replace customer and search info placeholders
            htmlContent = htmlContent.replace("{{customerName}}", request.getCustomerName());
            htmlContent = htmlContent.replace("{{email}}", request.getEmail());
            htmlContent = htmlContent.replace("{{searchCriteria}}", request.getSearchCriteria());

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(request.getEmail());
            helper.setSubject(subject);
            helper.setText(htmlContent, true);

            mailSender.send(message);

            logger.info("Vehicle not available email sent to {}", request.getEmail());

        } catch (Exception ex) {

            logger.error("Failed to send VEHICLE_NOT_AVAILABLE email", ex);

            throw new RuntimeException("Email sending failed");
        }
    }

    /*
     * Vehicle Reservation Confirmation Email
     */
    @Override
    public void sendVehicleReservationEmail(EmailRequestDTO request) {

        try {

            logger.info("Preparing VEHICLE_RESERVATION_EVENT email for {}", request.getEmail());

            String subject = "Vehicle Reservation Confirmation";

            ClassPathResource resource =
                    new ClassPathResource("templates/vehicle-reservation.html");

            String htmlContent =
                    new String(resource.getInputStream().readAllBytes(),
                    StandardCharsets.UTF_8);

            // replace customer info placeholders
            htmlContent = htmlContent.replace("{{customerName}}", request.getCustomerName());
            htmlContent = htmlContent.replace("{{email}}", request.getEmail());

            // replace all product detail placeholders so nothing shows as raw {{placeholder}}
            htmlContent = htmlContent.replace("{{vehicleCategory}}", request.getVehicleCategory());
            htmlContent = htmlContent.replace("{{vehicleRentalType}}", request.getVehicleType());
            htmlContent = htmlContent.replace("{{vehicleSize}}", request.getVehicleSize());
            htmlContent = htmlContent.replace("{{vehicleDriveType}}", request.getVehicleDriveType());
            htmlContent = htmlContent.replace("{{vehicleDurationType}}", request.getVehicleDuration());
            htmlContent = htmlContent.replace("{{vehiclePrice}}", request.getVehiclePrice());
            htmlContent = htmlContent.replace("{{availableFrom}}", request.getValidFrom());
            htmlContent = htmlContent.replace("{{availableTo}}", request.getValidTo());

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(request.getEmail());
            helper.setSubject(subject);
            helper.setText(htmlContent, true);

            mailSender.send(message);

            logger.info("Vehicle reservation confirmation sent to {}", request.getEmail());

        } catch (Exception ex) {

            logger.error("Failed to send VEHICLE_RESERVATION email", ex);

            throw new RuntimeException("Email sending failed");
        }
    }
}