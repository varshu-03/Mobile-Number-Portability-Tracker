package com.example.mnp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "portability_request")
public class PortabilityRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long msisdn;
    private Long imsi;
    private String name;

    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "current_provider_id")
    private Integer currentProviderId;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "request_reference_id")
    private String requestReferenceId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMsisdn() { return msisdn; }
    public void setMsisdn(Long msisdn) { this.msisdn = msisdn; }

    public Long getImsi() { return imsi; }
    public void setImsi(Long imsi) { this.imsi = imsi; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIdType() { return idType; }
    public void setIdType(String idType) { this.idType = idType; }

    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    public Integer getCurrentProviderId() { return currentProviderId; }
    public void setCurrentProviderId(Integer currentProviderId) { this.currentProviderId = currentProviderId; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getRequestReferenceId() { return requestReferenceId; }
    public void setRequestReferenceId(String requestReferenceId) { this.requestReferenceId = requestReferenceId; }
}
