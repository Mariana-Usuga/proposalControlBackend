
package com.proposalControlBackend.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "approvedProposal")
public class ApprovedProposal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private Long proposalId;
    private String code;
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
    private String userApproved;
    private Date approvalDate;
    private String folder;
    private String comments;
    private String commentsProposalApproved;
    private String innerDuoCommercial;
    private String innerDuoPresale;
    private String editorUser;
    private Date proposalSubmissionDeadline;
        
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "approvedProposal", cascade = CascadeType.ALL)
    List<Hito> hitos;
     
     public ApprovedProposal() {}

    public ApprovedProposal(Long proposalId, String code, String company, String customer, String customerReference, Integer version, Date dateVersion, String servicioConcept, String typeOfService, String currency, Integer baseAmount, Integer totalAmount, String stateP, String wayToPay, String wayToPayDays, String creatorUser, String userApproved, Date approvalDate, String folder, String comments, String commentsProposalApproved, String innerDuoCommercial, String innerDuoPresale, String editorUser, List<Hito> hitos) {
        this.proposalId = proposalId;
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
        this.userApproved = userApproved;
        this.approvalDate = approvalDate;
        this.folder = folder;
        this.comments = comments;
        this.commentsProposalApproved = commentsProposalApproved;
        this.innerDuoCommercial = innerDuoCommercial;
        this.innerDuoPresale = innerDuoPresale;
        this.editorUser = editorUser;
        this.hitos = hitos;
    }

    public Date getProposalSubmissionDeadline() {
        return proposalSubmissionDeadline;
    }

    public void setProposalSubmissionDeadline(Date proposalSubmissionDeadline) {
        this.proposalSubmissionDeadline = proposalSubmissionDeadline;
    }

    public String getCommentsProposalApproved() {
        return commentsProposalApproved;
    }

    public void setCommentsProposalApproved(String commentsProposalApproved) {
        this.commentsProposalApproved = commentsProposalApproved;
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
    
    

    public String getEditorUser() {
        return editorUser;
    }

    public void setEditorUser(String editorUser) {
        this.editorUser = editorUser;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getUserApproved() {
        return userApproved;
    }

    public void setUserApproved(String userApproved) {
        this.userApproved = userApproved;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }
    
    public List<Hito> getHitos() {
        return hitos;
    }

    public void setHitos(List<Hito> hitos) {
        this.hitos = hitos;
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
