package com.example.mnp.service;

import com.example.mnp.model.PortabilityRequest;
import com.example.mnp.model.Subscriber;
import com.example.mnp.repository.PortabilityRequestRepository;
import com.example.mnp.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    @Autowired
    private PortabilityRequestRepository requestRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;

    public String validateRequest(Integer requestId) {
        PortabilityRequest req = requestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        Subscriber sub = subscriberRepository.findById(req.getSubscriberId())
                .orElseThrow(() -> new RuntimeException("Subscriber not found"));

        // Rule 1: IMSI format (15 digits)
        if (String.valueOf(sub.getImsi()).length() != 15) {
            req.setStatus("Rejected");
            requestRepository.save(req);
            return "Validation failed: Invalid IMSI";
        }

        // Rule 2: ID type format
        if (!sub.getIdType().matches("(?i)(Aadhar|Passport|VoterID)")) {
            req.setStatus("Rejected");
            requestRepository.save(req);
            return "Validation failed: Invalid ID Type";
        }

        req.setStatus("Validated");
        requestRepository.save(req);
        return "Validation successful";
    }
}
