
package com.proposalControlBackend.service;

import com.proposalControlBackend.entity.ApprovedProposal;
import com.proposalControlBackend.repo.ApprovedProposalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovedProposalService {
    
    @Autowired
    private ApprovedProposalRepo approvedProposalrepo;
    
     public Object createApprovedProposal(ApprovedProposal proposal){
        return  approvedProposalrepo.save(proposal);
    }
    
     
     public ApprovedProposal getById(Long id){
        return  approvedProposalrepo.searchById(id);
    }
     
      public ApprovedProposal getProposalById(Long id){
        return  approvedProposalrepo.searchByProposalId(id);
    }
     
    
}
