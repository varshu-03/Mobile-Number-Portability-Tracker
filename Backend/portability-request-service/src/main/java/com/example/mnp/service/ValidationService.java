package com.example.mnp.service;

import com.example.mnp.model.Subscriber;
import com.example.mnp.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private final SubscriberRepository subscriberRepo;

    public ValidationService(SubscriberRepository subscriberRepo) {
        this.subscriberRepo = subscriberRepo;
    }

    public boolean validate(Long msisdn, Long imsi, String idType, String idNumber) {
        Subscriber sub = subscriberRepo.findByMsisdn(msisdn);
        if (sub == null) return false;
        if (!sub.getImsi().equals(imsi)) return false;
        if (!sub.getIdType().equalsIgnoreCase(idType)) return false;
        if (!sub.getIdNumber().equalsIgnoreCase(idNumber)) return false;
        return true;
    }
}
