package com.example.mnp.controllers;

import com.example.mnp.model.PortabilityRequest;
import com.example.mnp.service.PortabilityRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class PortabilityRequestController {

    @Autowired
    private PortabilityRequestService service;

    @PostMapping
    public ResponseEntity<PortabilityRequest> createRequest(@RequestBody PortabilityRequest request) {
        PortabilityRequest savedRequest = service.createRequest(request);
        return ResponseEntity.ok(savedRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortabilityRequest> getRequest(@PathVariable Long id) {
        PortabilityRequest request = service.getRequestById(id);
        return ResponseEntity.ok(request);
    }
}
