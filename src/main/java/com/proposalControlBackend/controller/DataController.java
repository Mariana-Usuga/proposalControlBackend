
package com.proposalControlBackend.controller;

import com.proposalControlBackend.bean.ResultDTO;
import com.proposalControlBackend.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/data")
public class DataController {
    
        @Autowired
        DataService dataService; 
    
    @GetMapping("/getAllCompany")
	public ResponseEntity<?> getAllCompany() {
            System.err.println(":::  UserController.getUserById ::::::");
        
        ResultDTO<?> responsePacket = null;
            try {
             responsePacket = new ResultDTO<>(dataService.getAllCompany(), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
	}
        
        @GetMapping("/getAllCustomer")
	public ResponseEntity<?> getAllCustomer() {
        
        ResultDTO<?> responsePacket = null;
            try {
             responsePacket = new ResultDTO<>(dataService.getAllCustomer(), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
	}
        
        @GetMapping("/getAllCustomerReference")
	public ResponseEntity<?> getAllCustomerReference() {
            System.err.println(":::  UserController.getUserById ::::::");
        
         System.err.println(":::  UserController.getUserById ::::::");
        
        ResultDTO<?> responsePacket = null;
            try {
             responsePacket = new ResultDTO<>(dataService.getAllCustomerReference(), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
	}
        
        @GetMapping("/getAllState")
	public ResponseEntity<?> getAllState() {        
        ResultDTO<?> responsePacket = null;
            try {
             responsePacket = new ResultDTO<>(dataService.getAllState(), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
	}
        
        @GetMapping("/getAllTypeOfService")
	public ResponseEntity<?> getAllTypeOfService() {
            System.err.println(":::  UserController.getUserById ::::::");
        ResultDTO<?> responsePacket = null;
            try {
             responsePacket = new ResultDTO<>(dataService.getAllTypeOfService(), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
        
	}
        
        /*@GetMapping("/getAllCurrency")
	public ResponseEntity<?> getAllCurrency() {
            System.err.println(":::  UserController.getUserById ::::::");
        ResultDTO<?> responsePacket = null;
            try {
             responsePacket = new ResultDTO<>(companyService.getAllCurrency(), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
        
	}*/
}
