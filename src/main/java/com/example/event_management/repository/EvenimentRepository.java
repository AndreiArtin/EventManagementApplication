package com.example.event_management.repository;

import com.example.event_management.Eveniment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenimentRepository extends JpaRepository<Eveniment, Long> {
}
