
package com.proposalControlBackend.controller;

import com.proposalControlBackend.bean.ResultDTO;
import com.proposalControlBackend.entity.ApprovedProposal;
import com.proposalControlBackend.service.ApprovedProposalService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/approvedProposal")
public class ApprovedProposalController {
    
    @Autowired
    private ApprovedProposalService approvedProposalService;
    
    @PostMapping
    public ResponseEntity<?> createProposal(@RequestBody ApprovedProposal reqData) throws IOException{
        System.out.println(":::  UserController.createUser :::::" );
        ResultDTO<?> responsePacket = null;
       
            try {
             responsePacket = new ResultDTO<>(approvedProposalService.createApprovedProposal(reqData), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getApprovedProposalById(@PathVariable("id") Long id) {
    ResultDTO<?> responsePacket = null;
    
    responsePacket = new ResultDTO<>(approvedProposalService.getProposalById(id), 
                     "Proposal Created Successfully", true);  

    return new ResponseEntity<>(responsePacket, HttpStatus.OK);

     }
 
}
