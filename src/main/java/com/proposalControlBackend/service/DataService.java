
package com.proposalControlBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.proposalControlBackend.repo.CompanyRepo;
import com.proposalControlBackend.repo.CurrencyRepo;
import com.proposalControlBackend.repo.CustomerReferenceRepo;
import com.proposalControlBackend.repo.CustomerRepo;
import com.proposalControlBackend.repo.StateRepo;
import com.proposalControlBackend.repo.TypeOfServiceRepo;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    
    @Autowired
    private CompanyRepo companyRepo;
    
    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
    private CustomerReferenceRepo customerReferenceRepo;
    
    @Autowired
    private StateRepo stateRepo;
     
    @Autowired
    private TypeOfServiceRepo typeOfServiceRepo;
    
    @Autowired
    private CurrencyRepo currencyRepo;

    public Object getAllCompany(){
        return companyRepo.findAll();
    }
    
     public Object getAllCustomer(){
        return customerRepo.findAll();
    }
     
    public Object getAllCustomerReference(){
        return customerReferenceRepo.findAll();
    }
    
    public Object getAllState(){
        return stateRepo.findAll();
    }
    
    
    public Object getAllTypeOfService(){
        return typeOfServiceRepo.findAll();
    }
    
    public Object getAllCurrency(){
        return currencyRepo.findAll();
    }
}
