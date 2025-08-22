package com.mnptracker.trigger.controller;


import com.mnptracker.trigger.dto.AckRequest;

import com.mnptracker.trigger.dto.NotifyRequest;

import com.mnptracker.trigger.dto.ProviderResponse;

import com.mnptracker.trigger.service.APIClientService;

import io.swagger.v3.oas.annotations.Operation;
import com.mnptracker.trigger.service.ResponseHandlerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider")
public class ProviderCommController {
  private final APIClientService apiClientService;
  private final ResponseHandlerService responseHandlerService;

  public ProviderCommController(APIClientService apiClientService, ResponseHandlerService responseHandlerService) {
    this.apiClientService = apiClientService;
    this.responseHandlerService = responseHandlerService;
  }

  @Operation(summary = "Trigger request to target provider")
  @PostMapping("/notify")
  public ResponseEntity<ProviderResponse> notify(@RequestBody NotifyRequest req) {
    return ResponseEntity.ok(apiClientService.notifyProvider(req));
  }

  @Operation(summary = "Receive acknowledgment from provider")
  @PostMapping("/ack")
  public ResponseEntity<String> ack(@RequestBody AckRequest req) {
    responseHandlerService.handleAck(req);
    return ResponseEntity.ok("ACK_RECEIVED");
  }
}

