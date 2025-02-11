package com.nithieshm.softwaretracker.Repositories;

import com.nithieshm.softwaretracker.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
}
