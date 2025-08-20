package com.mnptracker.trigger.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "provider")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Long providerId;  // maps to provider_id in DB

    @Column(name = "provider_code", nullable = false, unique = true)
    private String providerCode;  // e.g., "VOD", "AIR"

    @Column(name = "provider_name", nullable = false)
    private String providerName;  // e.g., "Vodafone"

    @Column(name = "api_endpoint", nullable = false)
    private String apiEndpoint;  // Eureka service name, e.g., "vodafone-service"

    // Optional auth token or header if needed for provider API calls
    //private String authHeader;
}

