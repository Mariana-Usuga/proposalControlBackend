
package com.proposalControlBackend.service;

import com.proposalControlBackend.entity.ProposalVersion;
import com.proposalControlBackend.repo.ProposalVersionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalVersionService {
    
    @Autowired
    private ProposalVersionRepo proposalVersionrepo;
    
    public Object createProposal(ProposalVersion proposal){
        return  proposalVersionrepo.save(proposal);
    }
    
      public List<ProposalVersion> getProposalsById(Long id) {
        return proposalVersionrepo.searchById(id);
    }
    
      public ProposalVersion delete(Long id){
       proposalVersionrepo.deleteById(id);
        return null;
    }
      
      public ProposalVersion deleteByCode(String code){
                                          System.out.println("in service " + code);
          proposalVersionrepo.deleteByCode(code);
          return null;
      }
              
}
