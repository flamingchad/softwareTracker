package com.nithieshm.softwaretracker.services;

import com.nithieshm.softwaretracker.entities.Notifications;
import com.nithieshm.softwaretracker.entities.Projects;
import com.nithieshm.softwaretracker.entities.Users;
import com.nithieshm.softwaretracker.repositories.NotificationsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationsRepository notificationsRepository;
    private final JavaMailSender emailSender;

    public NotificationService(NotificationsRepository notificationsRepository, JavaMailSender emailSender) {
        this.notificationsRepository = notificationsRepository;
        this.emailSender = emailSender;
    }

    public ResponseEntity<?> notifyUser(Users user, Projects project, String newVersion) {
        SimpleMailMessage message = templateSimpleMailMessage(user, project, newVersion);
        try {
            emailSender.send(message);
            notificationsRepository.save(new Notifications(user, project, newVersion));
            return new ResponseEntity<>("Notification sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send notification " + e.getMessage());
        }

    }

    private SimpleMailMessage templateSimpleMailMessage(Users user, Projects project, String newVersion) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("glennho16042001@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject(newVersion + project.getName() + " Has been released!!");
        message.setText("This is to inform you that a new version of " + project.getName() + " has been released!!");
        return message;
    }

}
