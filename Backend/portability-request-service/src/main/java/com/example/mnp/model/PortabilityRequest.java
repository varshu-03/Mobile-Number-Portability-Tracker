package com.example.mnp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "portability_requests")
public class PortabilityRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer requestId;

    @Column(name = "subscriber_id", nullable = false)
    private Integer subscriberId;

    @Column(name = "old_provider")
    private String oldProvider;

    @Column(name = "new_provider")
    private String newProvider;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "request_date")
    private LocalDateTime requestDate = LocalDateTime.now();

    @Column(name = "request_ref_id", unique = true, length = 50)
    private String requestRefId;

    // Getters & Setters
    public Integer getRequestId() { return requestId; }
    public void setRequestId(Integer requestId) { this.requestId = requestId; }
    public Integer getSubscriberId() { return subscriberId; }
    public void setSubscriberId(Integer subscriberId) { this.subscriberId = subscriberId; }
    public String getOldProvider() { return oldProvider; }
    public void setOldProvider(String oldProvider) { this.oldProvider = oldProvider; }
    public String getNewProvider() { return newProvider; }
    public void setNewProvider(String newProvider) { this.newProvider = newProvider; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }
    public String getRequestRefId() { return requestRefId; }
    public void setRequestRefId(String requestRefId) { this.requestRefId = requestRefId; }
}
