
package com.proposalControlBackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String businessName;
    private String RUC;
    private String legalRepresentative;
    private String fieldToWhichItIsDedicated;
    private Integer telephone1;
    private Integer telephone2;
    private String email1;
    private String direction;

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getFieldToWhichItIsDedicated() {
        return fieldToWhichItIsDedicated;
    }

    public void setFieldToWhichItIsDedicated(String fieldToWhichItIsDedicated) {
        this.fieldToWhichItIsDedicated = fieldToWhichItIsDedicated;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(Integer telephone1) {
        this.telephone1 = telephone1;
    }

    public Integer getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(Integer telephone2) {
        this.telephone2 = telephone2;
    }

    
   
    
    
    
}
