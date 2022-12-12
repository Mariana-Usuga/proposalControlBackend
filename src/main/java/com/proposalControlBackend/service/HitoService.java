
package com.proposalControlBackend.service;

import com.proposalControlBackend.entity.Hito;
import com.proposalControlBackend.repo.HitoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HitoService {
    
      @Autowired
    private HitoRepo hitorepo;
      
        public Object createHito(Hito hito){
        return  hitorepo.save(hito);
    }
    
}
