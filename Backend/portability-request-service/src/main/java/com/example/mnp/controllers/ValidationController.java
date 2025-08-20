package com.example.mnp.controllers;

import com.example.mnp.service.ValidationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class ValidationController {
    private final ValidationService validationService;

    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping("/validate")
    public String validateRequest(@RequestParam Long msisdn,
                                  @RequestParam Long imsi,
                                  @RequestParam String idType,
                                  @RequestParam String idNumber) {
        boolean isValid = validationService.validate(msisdn, imsi, idType, idNumber);
        return isValid ? "Validation Passed" : "Validation Failed";
    }
}
