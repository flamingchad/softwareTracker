package com.nithieshm.softwaretracker.Repositories;

import com.nithieshm.softwaretracker.entities.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Integer> {
}
