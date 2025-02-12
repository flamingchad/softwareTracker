package com.nithieshm.softwaretracker.repositories;

import com.nithieshm.softwaretracker.entities.Projects;
import com.nithieshm.softwaretracker.entities.Subscriptions;
import com.nithieshm.softwaretracker.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Integer> {
    Optional<Subscriptions> findByUserAndProject(Users user, Projects project);
}
