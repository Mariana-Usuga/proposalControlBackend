
package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.Hito;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HitoRepo extends JpaRepository<Hito, Long>{
    
    
}
