
package com.proposalControlBackend.controller;

import com.proposalControlBackend.bean.ResultDTO;
import com.proposalControlBackend.entity.ProposalVersion;
import com.proposalControlBackend.service.ProposalVersionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/proposalVersion")
public class ProposalVersionController {
    
    @Autowired
    private ProposalVersionService proposalVersionservice;
    
    @GetMapping("/getProposalByIdProposal/{id}")
	public List<ProposalVersion> getProposalsById(@PathVariable("id") Long id) {
            System.err.println(":::  UserController.getUserById ::::::");
	return (List<ProposalVersion>) proposalVersionservice.getProposalsById(id);
	}
        
            
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String code) {
        System.out.println("delete "+ code);
        ResultDTO<?> responsePacket = null;
        try {
                    System.out.println("antes de result ");
            responsePacket = new ResultDTO<>(proposalVersionservice.deleteByCode(code),
                    "proposal deleted successfully !!", true);
                                System.out.println("despues ");
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("entra en catch");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
     
    }
    
}
