package com.mnptracker.trigger.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "api_request_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIRequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String direction;  // "OUTBOUND" or "INBOUND"

    @Column(nullable = false)
    private String url;  // Called URL or service name

    @Column(columnDefinition = "jsonb")
    private String requestBody;  // JSON payload sent

    @Column(columnDefinition = "jsonb")
    private String responseBody;  // JSON response received

    @Column(name = "http_status")
    private Integer httpStatus;  // HTTP status code

    @Column(nullable = false, length = 50)
    private String correlationId;  // Links request & response

    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id")
    private Provider provider;  // FK to Provider table

    @Column(nullable = false)
    private OffsetDateTime createdAt;
}

