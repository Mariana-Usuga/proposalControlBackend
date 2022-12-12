
package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.ProposalContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalContactRepo extends JpaRepository<ProposalContact, Long>  {
    
    @Query("SELECT p FROM ProposalContact p WHERE p.idProposal =?1")
    ProposalContact searchById(@Param("id") Long id);
}
