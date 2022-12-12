package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.CustomerReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReferenceRepo extends JpaRepository<CustomerReference, Long>{
    
}
