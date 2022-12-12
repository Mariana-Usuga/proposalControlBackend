
package com.proposalControlBackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "proposalContact")
public class ProposalContact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private Integer phoneNumber;
    private Long idProposal;
    
    public ProposalContact() {}

    public ProposalContact(String fullName, String email, Integer phoneNumber, Long idProposal) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idProposal = idProposal;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   

    public Long getIdProposal() {
        return idProposal;
    }

    public void setIdProposal(Long idProposal) {
        this.idProposal = idProposal;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    
}
