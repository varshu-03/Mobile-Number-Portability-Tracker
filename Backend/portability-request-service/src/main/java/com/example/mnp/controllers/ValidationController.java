package com.example.mnp.controllers;

import com.example.mnp.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    // POST /validate/{requestId}
    @PostMapping("/{requestId}")
    public String validateRequest(@PathVariable Integer requestId) {
        return validationService.validateRequest(requestId);
    }
}
