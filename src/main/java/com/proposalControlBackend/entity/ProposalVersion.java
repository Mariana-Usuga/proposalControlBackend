package com.proposalControlBackend.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "proposalVersion")
public class ProposalVersion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private long proposalId;
    private String company;
    private String customer;
    private String customerReference;
    private Integer version;
    private Date dateVersion;
    private String servicioConcept;
    private String typeOfService;
    private String currency;
    private Integer baseAmount;
    private Integer totalAmount;
    private String stateP;
    private String wayToPay;
    private String wayToPayDays;
    private String creatorUser;
    private String folder;
    private String editorUser;
    
    public ProposalVersion() {}

    public ProposalVersion(Long id,String company, String customer, String customerReference, 
            Integer version, Date dateVersion, String servicioConcept, String typeOfService, 
            String currency, Integer baseAmount, Integer totalAmount, String stateP, 
            String folder, Long proposalId) {
        this.id = id;
        this.company = company;
        this.customer = customer;
        this.customerReference = customerReference;
        this.version = version;
        this.dateVersion = dateVersion;
        this.servicioConcept = servicioConcept;
        this.typeOfService = typeOfService;
        this.currency = currency;
        this.baseAmount = baseAmount;
        this.totalAmount = totalAmount;
        this.stateP = stateP;
        this.folder = folder;
        this.proposalId = proposalId;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWayToPay() {
        return wayToPay;
    }

    public void setWayToPay(String wayToPay) {
        this.wayToPay = wayToPay;
    }

    public String getWayToPayDays() {
        return wayToPayDays;
    }

    public void setWayToPayDays(String wayToPayDays) {
        this.wayToPayDays = wayToPayDays;
    }

    public String getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(String creatorUser) {
        this.creatorUser = creatorUser;
    }
    
    public long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }
    
   
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getDateVersion() {
        return dateVersion;
    }

    public void setDateVersion(Date dateVersion) {
        this.dateVersion = dateVersion;
    }

    public String getServicioConcept() {
        return servicioConcept;
    }

    public void setServicioConcept(String servicioConcept) {
        this.servicioConcept = servicioConcept;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Integer baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStateP() {
        return stateP;
    }

    public void setStateP(String stateP) {
        this.stateP = stateP;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}