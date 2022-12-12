package com.proposalControlBackend.controller;

import com.proposalControlBackend.bean.ResultDTO;
import com.proposalControlBackend.service.ProposalService;
import com.proposalControlBackend.entity.Proposal;
import com.proposalControlBackend.entity.ProposalVersion;
import com.proposalControlBackend.service.ProposalVersionService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/proposal")
public class ProposalController {

    @Autowired
    private ProposalService proposalservice; 
    
    @Autowired
    private ProposalVersionService proposalVersionservice;
    
    @PostMapping("/filter")
    public List<Proposal> getProposalByFilters(@RequestBody Proposal reqData,
            @RequestParam String startDate, @RequestParam String endDate) throws ParseException, ParseException{
         System.out.println("entra");
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        System.out.println("entra"+ startDate.getClass()+ "end" + endDate.getClass());
      return (List<Proposal>) proposalservice.getProposalByFilters(reqData, start, end);
    }
    
      @PostMapping("/date")
    public List<Proposal> getDateByFilters() throws ParseException, ParseException{
         System.out.println("entra");
        //System.out.println("entra" + startDate);
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse("");
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-30");
        System.out.println("entra"+ start+ "end" + end);
      return (List<Proposal>) proposalservice.searchDate(start, end);
    }
    
    /*@PostMapping("/filter")
    public List<Proposal> getProposalByFilters(@RequestBody Proposal reqData,
            @RequestParam Date startDate, @RequestParam Date endDate){
         System.out.println("entra" + reqData.getCompany());
      return (List<Proposal>) proposalservice.getProposalByFilters(reqData, startDate, endDate);
    }*/
    
    /*@GetMapping("/laptops/createdat")
    public List<Proposal> getLaptopsByCreatedDate (@RequestParam Date startDate, 
                @RequestParam Date endDate) {
																
            return List<Proposal> proposalservice.getFilterDate(startDate, endDate);
	}*/
        
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException{
        ResultDTO<?> responsePacket = null;
        System.out.println("entra");
        try{
             if(file == null){
            responsePacket = new ResultDTO<>("Archivo null", false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
             System.out.println(":::  UserController.createUser :::" + file);
        StringBuilder builder = new StringBuilder();
        builder.append(System.getProperty("user.home"));
        builder.append(File.separator);
        //builder.append("upload-proposal");
        builder.append("spring-boot-proposal");
        builder.append(File.separator);
        builder.append(file.getOriginalFilename());
        
        byte[] fileBytes = file.getBytes();
		Path path = Paths.get(builder.toString());
		Files.write(path, fileBytes);
        /*attributes.addFlashAttribute("message", "Archivo cargado correctamente ["+builder.toString()+"]");
        return "Archivo cargado correctamente ["+builder.toString()+"]";*/
         responsePacket = new ResultDTO<>(builder.toString(), true);
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        }catch (Exception e) {
            System.out.print("entra en catch");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> createProposal(@RequestBody Proposal reqData) throws IOException{
        System.out.println(":::  UserController.createUser :::" + reqData.getDateVersion());
        ResultDTO<?> responsePacket = null;
       
            try {
             responsePacket = new ResultDTO<>(proposalservice.createProposal(reqData), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }
    
        
    @PostMapping("version")
    public ResponseEntity<?> createProposalVersion(@RequestBody ProposalVersion reqData) throws IOException{
        System.out.println(":::  UserController.createUser :::" + reqData.getVersion());
        ResultDTO<?> responsePacket = null;
       
            try {
             responsePacket = new ResultDTO<>(proposalVersionservice.createProposal(reqData), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }
        
    @PutMapping
    public Proposal  updateProposal(@RequestBody Proposal reqData){
        System.err.println(":::  UserController.updateUser :::");
        ResultDTO<?> responsePacket = null;

         return proposalservice.updateProposal(reqData);//actualiza la en la tabla proposal
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        System.out.println("delete");
        ResultDTO<?> responsePacket = null;
        try {
            proposalVersionservice.getProposalsById(id);
            responsePacket = new ResultDTO<>(proposalservice.delete(id), 
                    "proposal deleted successfully !!", true);
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("entra en catch");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
     
    }
 
    
    /*@GetMapping("/company")
	public List<Proposal> getAllCompany(@PathVariable("id") Integer id) {
            System.err.println(":::  UserController.getUserById ::::::");
	return (List<Proposal>) proposalservice.getProposalsById(id);
	}*/
  
}
/*
package com.proposalControl.controller;

import com.proposalControl.bean.ResultDTO;
import com.proposalControl.entity.ProposedVersion;
import com.proposalControl.service.ProposedVersionService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/proposalVersion")
public class proposedVersionController {
    
    @Autowired
    private ProposedVersionService proposedVersionService ;  
    
    @PostMapping
    public ResponseEntity<?> createProposal(@RequestBody ProposedVersion reqData) throws IOException{
        System.out.println(":::  UserController.createUser :::" + reqData.getYearP());
        ResultDTO<?> responsePacket = null;
                 
        try {
            responsePacket = new ResultDTO<>(proposedVersionService .createNewVersion(reqData), "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }
    
}

*/

 /*}else{
            try {
                System.out.println("!= 1" + reqData.getVersion());
            var ver = reqData.getVersion() + 1;
            Proposal pro = new Proposal(reqData.getCompany(), reqData.getCustomer(),
                    reqData.getCustomerReference(), reqData.getYearP(), 
                    reqData.getMonthP(), 1, reqData.getDateVersion(),
                    reqData.getServicioConcept(), reqData.getTypeOfService(), 
                    reqData.getCurrency(),reqData.getBaseAmount(), 
                    reqData.getTotalAmount(), reqData.getStateP(), 
                    reqData.getWarranty(), reqData.getFolder(), reqData.getProposalId());
            
            //Eliminar la anterior
            //proposalservice.delete(pro.getProposalId());
            
            ProposalVersion proVersion = new ProposalVersion(reqData.getCompany(), reqData.getCustomer(),
                    reqData.getCustomerReference(), reqData.getYearP(), 
                    reqData.getMonthP(), ver, reqData.getDateVersion(),
                    reqData.getServicioConcept(), reqData.getTypeOfService(), 
                    reqData.getCurrency(),reqData.getBaseAmount(), 
                    reqData.getTotalAmount(), reqData.getStateP(), 
                    reqData.getWarranty(), reqData.getFolder(), reqData.getProposalId());

            
            //List<ProposalVersion> versiones = new ArrayList<>();
            
            //proVersion.setProposal(pro);
       
            //versiones.add(proVersion);
            
            //pro.setProposalVersion(versiones);
            
            //proposalrepo.save(pro);
            proposalVersionservice.createProposal(proVersion);
            responsePacket = new ResultDTO<>(proposalrepo.save(pro), 
                    "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
            }catch (Exception e){
                 System.out.print("entra en catchh");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
            }*/