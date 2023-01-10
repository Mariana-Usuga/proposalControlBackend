
package com.proposalControlBackend.service;

import com.proposalControlBackend.repo.ProposalRepo;
import com.proposalControlBackend.entity.Proposal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {
       
    @Autowired
    private ProposalRepo proposalrepo;
    
     public Object getProposalByFilters(Proposal proposal, Date startDate, Date endDate){
         return proposalrepo.search(proposal.getCompany(), proposal.getCustomer(),
                 proposal.getCustomerReference(),
                 proposal.getServicioConcept(),proposal.getTypeOfService(),
                 proposal.getCurrency(),proposal.getBaseAmount(),
                 proposal.getTotalAmount(), proposal.getStateP(),proposal.getWayToPay(),
                 proposal.getFolder(),proposal.getWayToPayDays(), proposal.getCreatorUser(),
                 proposal.getVersion(), proposal.getCode(), startDate, endDate);
    }
     
     public Object searchDate(Date startDate, Date endDate){
         return proposalrepo.searchDate(startDate, endDate);
     }

    
     public Proposal getProposalById(Long id){
        return  proposalrepo.searchByProposalId(id);
    }
     
     public List<Proposal> getAll(){
        return proposalrepo.findAll();
     }
    
    
    public Object createProposal(Proposal proposal){
        return  proposalrepo.save(proposal);
    }
    
    public Proposal updateProposal(Proposal proposal){
	return proposalrepo.save(proposal);
    }
    
    public Proposal delete(Long id){
        proposalrepo.deleteById(id);
        return null;
    }
    
    public Proposal getById(Long id){
        return proposalrepo.getOne(id);
    }
    
    public Object getAllProposal(){
        return proposalrepo.findAll();
    } 
   
}

    

