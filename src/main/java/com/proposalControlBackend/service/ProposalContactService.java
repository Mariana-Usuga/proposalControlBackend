
package com.proposalControlBackend.service;

import com.proposalControlBackend.entity.ProposalContact;
import com.proposalControlBackend.repo.ProposalContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalContactService {
    
     @Autowired
    private ProposalContactRepo proposalContactRepo;
     
      public Object createContact(ProposalContact proposalContact){
        return  proposalContactRepo.save(proposalContact);
    }
       
     public ProposalContact getProposalById(Long id){
        return  proposalContactRepo.searchById(id);
    }
    
     public ProposalContact updateContact(ProposalContact proposal){
	return proposalContactRepo.save(proposal);
    }
    
     public ProposalContact delete(Long id){
        proposalContactRepo.deleteById(id);
        return null;
    }
     
     public ProposalContact deleteByCode(Long id){
        proposalContactRepo.deleteByCode(id);
        return null;
    }
}
