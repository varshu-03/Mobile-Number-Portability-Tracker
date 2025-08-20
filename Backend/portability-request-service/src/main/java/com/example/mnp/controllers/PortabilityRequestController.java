package com.example.mnp.controllers;

import com.example.mnp.model.PortabilityRequest;
import com.example.mnp.service.PortabilityRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class PortabilityRequestController {

    @Autowired
    private PortabilityRequestService requestService;

    // 1️⃣ View all portability requests
    @GetMapping
    public List<PortabilityRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    // 2️⃣ View request by ID
    @GetMapping("/{id}")
    public PortabilityRequest getRequestById(@PathVariable Integer id) {
        return requestService.getRequestById(id);
    }

    // 3️⃣ Create new portability request
    @PostMapping
    public PortabilityRequest createRequest(@RequestBody PortabilityRequest request) {
        return requestService.createRequest(request);
    }

    // 4️⃣ Validate request
    @PostMapping("/{id}/validate")
    public String validateRequest(@PathVariable Integer id) {
        return requestService.validateRequest(id);
    }
}
