
package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.TypeOfService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfServiceRepo extends JpaRepository<TypeOfService, Long>{
    
}
