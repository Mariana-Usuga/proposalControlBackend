
package com.proposalControlBackend.controller;

import com.proposalControlBackend.bean.ResultDTO;
import com.proposalControlBackend.entity.ProposalContact;
import com.proposalControlBackend.service.ProposalContactService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/contact")
public class ProposalContactController {
    
    @Autowired
    private ProposalContactService proposalContactService; 

    @PostMapping
    public ResponseEntity<?> createProposalContact(@RequestBody ProposalContact reqData) throws IOException{
        System.out.println("reqData.getFullName()" + reqData.getFullName());
        ResultDTO<?> responsePacket = null;
        try {
             responsePacket = new ResultDTO<>(proposalContactService.createContact(reqData), 
                "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }
    
     @PutMapping
    public ProposalContact  updateProposal(@RequestBody ProposalContact reqData){
        System.err.println(":::  UserController.updateUser :::");
        ResultDTO<?> responsePacket = null;

         return proposalContactService.updateContact(reqData);//actualiza la en la tabla proposal
    }
    
    @GetMapping("/{idProposal}")
    public Object getContactsById(@PathVariable("idProposal") Long id) {
            System.err.println(":::  UserController.getUserById ::::::");
	return proposalContactService.getProposalById(id);
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        System.out.println("delete");
        ResultDTO<?> responsePacket = null;
        try {
            responsePacket = new ResultDTO<>(proposalContactService.delete(id), 
                    "proposal deleted successfully !!", true);
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("entra en catch");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
     
    }
}
