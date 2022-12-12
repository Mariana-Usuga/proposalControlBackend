
package com.proposalControlBackend.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hito")
public class Hito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer percentage;
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idApprovedProposal")
    private ApprovedProposal approvedProposal;
    
    public Hito(){}

    public Hito(Integer percentage, String description) {
        this.percentage = percentage;
        this.description = description;
    }

    public ApprovedProposal getApprovedProposal() {
        return approvedProposal;
    }

    public void setApprovedProposal(ApprovedProposal approvedProposal) {
        this.approvedProposal = approvedProposal;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
