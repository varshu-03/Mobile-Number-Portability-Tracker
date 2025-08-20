package com.example.mnp.repository;

import com.example.mnp.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
    Subscriber findByMsisdn(Long msisdn);
}
