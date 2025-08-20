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
     * Generates a unique requestReferenceId
     *
     * @param request PortabilityRequest object from controller
     * @return saved PortabilityRequest object
     */
    public PortabilityRequest createRequest(PortabilityRequest request) {
        // Generate a unique reference ID for the request
        request.setRequestReferenceId(UUID.randomUUID().toString());
        // Save the request in the database
        return repository.save(request);
    }

    /**
     * Retrieve a portability request by its ID
     *
     * @param id request ID
     * @return PortabilityRequest object if found, otherwise null
     */
    public PortabilityRequest getRequestById(Long id) {
        Optional<PortabilityRequest> request = repository.findById(id);
        return request.orElse(null); // Returns null if not found
    }
}
