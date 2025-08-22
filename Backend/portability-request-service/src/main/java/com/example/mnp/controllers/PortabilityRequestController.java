package com.example.mnp.controllers;

import com.example.mnp.model.PortabilityRequest;
import com.example.mnp.service.PortabilityRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/requests")
public class PortabilityRequestController {

    @Autowired
    private PortabilityRequestService service;

    /**
     * POST /requests
     * Create a new portability request
     */
    @PostMapping
    public ResponseEntity<PortabilityRequest> createRequest(@RequestBody PortabilityRequest request) {
        PortabilityRequest savedRequest = service.createRequest(request);
        return ResponseEntity.ok(savedRequest);
    }

    /**
     * GET /requests/{id}
     * Fetch a request by subscriber ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<PortabilityRequest> getRequest(@PathVariable Long id) {
        Optional<PortabilityRequest> requestOpt = service.getRequestById(id);
        return requestOpt
                .map(ResponseEntity::ok)   // Return 200 OK if found
                .orElseGet(() -> ResponseEntity.notFound().build()); // Return 404 if not found
    }
}
