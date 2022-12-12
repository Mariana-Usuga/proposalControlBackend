
package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.Hito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HitoRepo extends JpaRepository<Hito, Long>{
    
}
