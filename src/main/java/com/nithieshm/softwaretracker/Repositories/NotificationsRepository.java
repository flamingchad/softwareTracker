package com.nithieshm.softwaretracker.Repositories;

import com.nithieshm.softwaretracker.entities.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
}
