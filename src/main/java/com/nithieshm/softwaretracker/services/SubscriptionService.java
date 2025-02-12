package com.nithieshm.softwaretracker.services;

import com.nithieshm.softwaretracker.entities.Projects;
import com.nithieshm.softwaretracker.entities.Subscriptions;
import com.nithieshm.softwaretracker.entities.Users;
import com.nithieshm.softwaretracker.repositories.ProjectsRepository;
import com.nithieshm.softwaretracker.repositories.SubscriptionsRepository;
import com.nithieshm.softwaretracker.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubscriptionService {

    private final SubscriptionsRepository subscriptionsRepository;
    private UserRepository userRepository;
    private ProjectsRepository projectsRepository;

    SubscriptionService(SubscriptionsRepository subscriptionsRepository, UserRepository userRepository, ProjectsRepository projectsRepository) {
        this.subscriptionsRepository = subscriptionsRepository;
        this.userRepository = userRepository;
        this.projectsRepository = projectsRepository;
    }

    public ResponseEntity<?> subscribeUser(Users user, Projects project) {
            if(subscriptionsRepository.findByUserAndProject(user, project).isPresent()) {
                String message = "User with email " + user.getEmail() + " is already subscribed to project with name " + project.getName();
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
            }
            Subscriptions subscription = new Subscriptions(user, project,LocalDateTime.now());
            Subscriptions savedSub = subscriptionsRepository.save(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSub);
    }
}
