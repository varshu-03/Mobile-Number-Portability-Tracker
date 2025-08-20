package com.example.mnp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "subscribers")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id")
    private Integer subscriberId;

    @Column(name = "msisdn", nullable = false, unique = true)
    private Long msisdn;

    @Column(name = "imsi")
    private Long imsi;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "id_type", length = 50)
    private String idType;

    @Column(name = "id_number", length = 50)
    private String idNumber;

    @Column(name = "current_provider")
    private Integer currentProvider;

    @Column(name = "service_type", length = 20)
    private String serviceType;

    // Getters & Setters
    public Integer getSubscriberId() { return subscriberId; }
    public void setSubscriberId(Integer subscriberId) { this.subscriberId = subscriberId; }
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
    public Integer getCurrentProvider() { return currentProvider; }
    public void setCurrentProvider(Integer currentProvider) { this.currentProvider = currentProvider; }
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
}
