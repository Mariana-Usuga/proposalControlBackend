
package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.ApprovedProposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApprovedProposalRepo extends JpaRepository<ApprovedProposal , Long> {
        
    @Query("SELECT p FROM ApprovedProposal p WHERE p.id =?1")
    ApprovedProposal searchById(@Param("id") Long id);
    
    @Query("SELECT p FROM ApprovedProposal p WHERE p.proposalId =?1")
    ApprovedProposal searchByProposalId(@Param("id") Long id);
}
