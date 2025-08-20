package com.example.mnp.repository;

import com.example.mnp.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
    // 👈 The ID type must match entity @Id type
}
