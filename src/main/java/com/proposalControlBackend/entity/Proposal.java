package com.proposalControlBackend.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "proposal")
public class Proposal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String company;
    private String customer;
    private String customerReference;
    private Integer version;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateVersion;
    private String servicioConcept;
    private String typeOfService;
    private String currency;
    private Integer baseAmount;
    private Integer totalAmount;
    private String stateP;
    private String wayToPay;
    private Integer wayToPayDays;
    private String creatorUser;
    private String folder;
    private String editorUser;
    private String rejectionUser;
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Date rejectionDate;
    private String rejectionComments;
    private String comments;
    private String innerDuoCommercial;
    private String innerDuoPresale;
    private Date proposalSubmissionDeadline;
    
    public Proposal(){ }

    public Proposal(String code, String company, String customer, String customerReference, Integer version, Date dateVersion, String servicioConcept, String typeOfService, String currency, Integer baseAmount, Integer totalAmount, String stateP, String wayToPay, Integer wayToPayDays, String creatorUser, String folder, String editorUser, String rejectionUser, Date rejectionDate, String comments, String reasonForRejection, Date proposalSubmissionDate, Date dateOfDelivery, String innerDuoCommercial, String innerDuoPresale) {
        this.code = code;
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
        this.wayToPay = wayToPay;
        this.wayToPayDays = wayToPayDays;
        this.creatorUser = creatorUser;
        this.folder = folder;
        this.editorUser = editorUser;
        this.rejectionUser = rejectionUser;
        this.rejectionDate = rejectionDate;
        this.comments = comments;
        this.innerDuoCommercial = innerDuoCommercial;
        this.innerDuoPresale = innerDuoPresale;
    }

    public String getRejectionComments() {
        return rejectionComments;
    }

    public void setRejectionComments(String rejectionComments) {
        this.rejectionComments = rejectionComments;
    }

    public Date getProposalSubmissionDeadline() {
        return proposalSubmissionDeadline;
    }

    public void setProposalSubmissionDeadline(Date proposalSubmissionDeadline) {
        this.proposalSubmissionDeadline = proposalSubmissionDeadline;
    }

    
    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInnerDuoCommercial() {
        return innerDuoCommercial;
    }

    public void setInnerDuoCommercial(String innerDuoCommercial) {
        this.innerDuoCommercial = innerDuoCommercial;
    }

    public String getInnerDuoPresale() {
        return innerDuoPresale;
    }

    public void setInnerDuoPresale(String innerDuoPresale) {
        this.innerDuoPresale = innerDuoPresale;
    }
    
    
    
    

    public String getRejectionUser() {
        return rejectionUser;
    }

    public void setRejectionUser(String rejectionUser) {
        this.rejectionUser = rejectionUser;
    }

    public Date getRejectionDate() {
        return rejectionDate;
    }

    public void setRejectionDate(Date rejectionDate) {
        this.rejectionDate = rejectionDate;
    }
    

    public String getEditorUser() {
        return editorUser;
    }

    public void setEditorUser(String editorUser) {
        this.editorUser = editorUser;
    }

    public String getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(String creatorUser) {
        this.creatorUser = creatorUser;
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

    public Integer getWayToPayDays() {
        return wayToPayDays;
    }

    public void setWayToPayDays(Integer wayToPayDays) {    
        this.wayToPayDays = wayToPayDays;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
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


}

