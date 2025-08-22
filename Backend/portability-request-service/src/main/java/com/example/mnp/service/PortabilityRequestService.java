package com.example.mnp.service;

import com.example.mnp.model.PortabilityRequest;
import com.example.mnp.repository.PortabilityRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PortabilityRequestService {

    @Autowired
    private PortabilityRequestRepository repository;

    /**
     * Create a new portability request
     * Generates a unique requestReferenceId and sets default status
     *
     * @param request PortabilityRequest object from controller
     * @return saved PortabilityRequest object
     */
    public PortabilityRequest createRequest(PortabilityRequest request) {
        // Generate a unique reference ID for the request
        request.setRequestReferenceId(UUID.randomUUID().toString());

        // Set default status to "pending" if not provided
        if (request.getStatus() == null || request.getStatus().isEmpty()) {
            request.setStatus("pending");
        }

        // Set default reason code as empty if not provided
        if (request.getReasonCode() == null) {
            request.setReasonCode("");
        }

        // Save the request in the database
        return repository.save(request);
    }

    /**
     * Get a portability request by subscriber ID
     *
     * @param id Subscriber ID
     * @return Optional containing the request if found
     */
    public Optional<PortabilityRequest> getRequestById(Long id) {
        return repository.findById(id);
    }
}
