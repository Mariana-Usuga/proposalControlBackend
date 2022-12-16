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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        //builder.append(System.getProperty("user.home"));
        builder.append("C:\\Users\\Mariana\\Desktop\\dataProposal");
        builder.append(File.separator);
        //builder.append("upload-proposal");
        //builder.append("spring-boot-proposal");
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
        System.out.println("entra!!");
        ResultDTO<?> responsePacket = null;
        try {
        int year = LocalDate.now().getYear();
        
        List<Proposal> list = new ArrayList<Proposal>(); 
        
        list = (List<Proposal>) proposalservice.getAllProposal();
       
            int j = 0;
            String max = "0000";
            System.out.println("antes de whilw");
            while (j < list.size()) {   
                            System.out.println("repite");
            String[] parts = list.get(j).getCode().split("-");
            max = parts[1]; 
            j++;  
        }
                    System.out.println("entra!!2");

        int number = Integer.parseInt(max) + 1;
                System.out.println("entra!!3");
        String format = String.format("%04d", number);
                System.out.println("entra!!4");
        String code = year + "-" + 0000;
                System.out.println("entra!!5");

        if(list.isEmpty() || "9999".equals(format)){
        System.out.println("entra!!6");
            //code = year + "-" + 0000;
            reqData.setCode(code);
        }else{
            code = year + "-" + format;
            reqData.setCode(code);
        }
                System.out.println("entra!!4");

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
  
}



          
       