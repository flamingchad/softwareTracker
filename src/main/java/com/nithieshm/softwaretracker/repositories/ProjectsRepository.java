package com.nithieshm.softwaretracker.repositories;

import com.nithieshm.softwaretracker.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
    Optional<Projects> findByName(String name);
    Optional<Projects> findByPackageName(String packageName);
}
