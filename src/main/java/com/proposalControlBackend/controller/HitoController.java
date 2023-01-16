
package com.proposalControlBackend.controller;

import com.proposalControlBackend.bean.ResultDTO;
import com.proposalControlBackend.entity.ApprovedProposal;
import com.proposalControlBackend.entity.Hito;
import com.proposalControlBackend.entity.Proposal;
import com.proposalControlBackend.repo.ApprovedProposalRepo;
import com.proposalControlBackend.repo.HitoRepo;
import com.proposalControlBackend.service.ApprovedProposalService;
import com.proposalControlBackend.service.HitoService;
import com.proposalControlBackend.service.ProposalService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/hito")
public class HitoController {
    
     @Autowired
    private ApprovedProposalService approvedProposalService;
       
        @Autowired
    private ApprovedProposalRepo approvedProposalrepo; 
        
    @Autowired
    private HitoService hitoService; 
    
    @Autowired
    private ProposalService proposalService;  
    
     

     @PostMapping("/{idProposal}")
    public Object createProposal(@PathVariable("idProposal") long id,
            @RequestBody Hito reqData) throws IOException{
        ResultDTO<?> responsePacket = null;
       
            try {
                ApprovedProposal approvedProposal = approvedProposalService.getProposalById(id);
        
        Hito hito = new Hito(reqData.getPercentage(), reqData.getDescription());
        
        hito.setApprovedProposal(approvedProposal);
        
        List<Hito> hitos = new ArrayList<>();
        
        hitos.add(hito);
        approvedProposal.getHitos().forEach(x -> {
          System.out.println("hitos"+ x.getPercentage());
            hitos.add(x);
        });
        approvedProposal.setHitos(hitos);
        
        approvedProposalrepo.save(approvedProposal);
        
        return true;
    
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }
    
    
}
