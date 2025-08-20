package com.example.mnp.repository;

import com.example.mnp.model.PortabilityRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortabilityRequestRepository extends JpaRepository<PortabilityRequest, Integer> {
    // 👈 The ID type must match entity @Id type
}
