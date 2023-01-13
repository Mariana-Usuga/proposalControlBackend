
package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.ProposalContact;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalContactRepo extends JpaRepository<ProposalContact, Long>  {
    
    @Query("SELECT p FROM ProposalContact p WHERE p.idProposal =?1")
    ProposalContact searchById(@Param("id") Long id);
    
    @Modifying
    @Transactional
    @Query("delete from ProposalContact b where b.idProposal = ?1")
    void deleteByCode(@Param("id") Long id);
}
