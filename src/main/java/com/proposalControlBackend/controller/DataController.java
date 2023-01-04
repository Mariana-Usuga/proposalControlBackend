
package com.proposalControlBackend.controller;

import com.proposalControlBackend.bean.ResultDTO;
import com.proposalControlBackend.entity.Customer;
import com.proposalControlBackend.service.DataService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        
        /*@GetMapping("/getAllCustomerReference")
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
	}*/
        
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
        
        @PostMapping("/customer")
        public ResponseEntity<?> createCustomer(@RequestBody Customer customer) throws IOException{
        System.out.println("entra!!");
        ResultDTO<?> responsePacket = null;
        try {
             responsePacket = new ResultDTO<>(dataService.createCustomer(customer), 
                     "customer Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.println("entra en catchh ");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
        }
        
        /*@PostMapping("/customerReference")
        public ResponseEntity<?> createCustomer(@RequestBody CustomerReference customerReference) throws IOException{
        System.out.println("entra!!");
        ResultDTO<?> responsePacket = null;
        try {
             responsePacket = new ResultDTO<>(dataService.createCustomerReference(customerReference), 
                     "customer reference Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.println("entra en catchh ");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
        }*/
        
        
        @DeleteMapping("/customer/{id}")
        public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id) {
        System.out.println("delete");
        ResultDTO<?> responsePacket = null;
        try {
            //proposalVersionservice.getProposalsById(id);
            responsePacket = new ResultDTO<>(dataService.deleteCustomer(id), 
                    "proposal deleted successfully !!", true);
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("entra en catch");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
     
    }
        
        /*@DeleteMapping("/customerReference/{id}")
        public ResponseEntity<?> deleteCustomerReference(@PathVariable(value = "id") Long id) {
        System.out.println("delete");
        ResultDTO<?> responsePacket = null;
        try {
            //proposalVersionservice.getProposalsById(id);
            responsePacket = new ResultDTO<>(dataService.deleteCustomerRerefence(id), 
                    "proposal deleted successfully !!", true);
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("entra en catch");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
     
    }*/
        
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
