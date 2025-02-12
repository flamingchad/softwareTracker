package com.nithieshm.softwaretracker.Repositories;

import com.nithieshm.softwaretracker.entities.Notifications;
import com.nithieshm.softwaretracker.entities.Projects;
import com.nithieshm.softwaretracker.entities.Users;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
    List<Notifications> findByUser(Users user);
    List<Notifications> findByProject(Projects project);
    List<Notifications> findByUserAndProject(Users user, Projects project);
}
