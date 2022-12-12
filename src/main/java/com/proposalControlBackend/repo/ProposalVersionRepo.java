
package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.ProposalVersion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalVersionRepo extends JpaRepository<ProposalVersion, Long>{
    
     //@Query("SELECT p FROM ProposalVersion p WHERE p.proposalId =?1")
     
    //List<ProposalVersion> searchByPropuesta(@Param("id") Long id);
    
     
    @Query("SELECT p FROM ProposalVersion p WHERE p.proposalId =?1")
    List<ProposalVersion> searchById(@Param("id") Long id);
    
}
