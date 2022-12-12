
package com.proposalControlBackend.repo;

import com.proposalControlBackend.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long>{
    
}
