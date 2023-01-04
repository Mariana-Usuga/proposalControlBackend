
package com.proposalControlBackend.service;

import com.proposalControlBackend.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import com.proposalControlBackend.repo.CompanyRepo;
import com.proposalControlBackend.repo.CurrencyRepo;
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
    
    public Object getAllState(){
        return stateRepo.findAll();
    }
    
    
    public Object getAllTypeOfService(){
        return typeOfServiceRepo.findAll();
    }
    
    public Object getAllCurrency(){
        return currencyRepo.findAll();
    }
    
    public Object createCustomer(Customer customer){
        return  customerRepo.save(customer);
    }
    
     public Customer deleteCustomer(Long id){
        customerRepo.deleteById(id);
        return null;
    }
     
       /*public CustomerReference deleteCustomerRerefence(Long id){
        customerReferenceRepo.deleteById(id);
        return null;
    }*/
}
