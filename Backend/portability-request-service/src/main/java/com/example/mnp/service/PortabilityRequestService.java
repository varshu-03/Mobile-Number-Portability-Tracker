package com.example.mnp.service;

import com.example.mnp.model.PortabilityRequest;
import com.example.mnp.model.Subscriber;
import com.example.mnp.repository.PortabilityRequestRepository;
import com.example.mnp.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PortabilityRequestService {

    @Autowired
    private PortabilityRequestRepository requestRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;

    // 1. Get all requests
    public List<PortabilityRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    // 2. Get request by ID
    public PortabilityRequest getRequestById(Integer id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found with ID: " + id));
    }

    // 3. Create new portability request
    public PortabilityRequest createRequest(PortabilityRequest request) {
        request.setRequestRefId(UUID.randomUUID().toString());
        request.setStatus("Pending");
        return requestRepository.save(request);
    }

    // 4. Validate request
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
