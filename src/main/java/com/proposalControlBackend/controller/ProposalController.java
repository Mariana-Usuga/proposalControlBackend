package com.proposalControlBackend.controller;

import com.proposalControlBackend.bean.ResultDTO;
import com.proposalControlBackend.service.ProposalService;
import com.proposalControlBackend.entity.Proposal;
import com.proposalControlBackend.entity.ProposalVersion;
import com.proposalControlBackend.repo.ProposalRepo;
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
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
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
    
    @Autowired
    private ProposalRepo proposalrepo;
    
   // @Autowired
  //FilesStorageService storageService;
    
    @GetMapping
	public List<Proposal> getAll() {
      return (List<Proposal>) proposalservice.getAll();
	}
    
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
    
    @GetMapping("/files/{code}")
    public ResponseEntity<?> getFile(@PathVariable(value = "code") String code) throws IOException{
        ResultDTO<?> responsePacket = null;
        try{
            List<String> results = new ArrayList<String>();
            //File[] files = new File("C:\\Users\\Mariana\\Desktop\\dataProposal\\"+ code).listFiles();
            //File[] files = new File("/opt/tomcat/webapps/archivospropuesta/"+ code).listFiles();
            File[] files = new File("/home/wilmar/projectsMariana/archivosPropuestas/"+ code).listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    results.add(file.getName());
                }
            }
                       responsePacket = new ResultDTO<>(results, 
                                "Proposal Created Successfully", true); 
                       return new ResponseEntity<>(responsePacket, HttpStatus.OK);

        }catch (Exception e) {
            System.out.print("entra en catch");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }
    
        
    @PostMapping("/{id}/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile fileOrigin, 
            @PathVariable(value = "id") Long id,
            RedirectAttributes attributes) 
            throws IOException{
                     System.out.println(":::id " + id);
                                  System.out.println(":::file " + fileOrigin.getOriginalFilename());
        ResultDTO<?> responsePacket = null;
        System.out.println("entra");
        try{
             if(fileOrigin == null){
            responsePacket = new ResultDTO<>("Archivo null", false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
            StringBuilder builder = new StringBuilder();

             Proposal proposal = proposalservice.getById(id);
             System.out.println(":::code" + proposal.getCode());
         
              //String fileName = "/opt/tomcat/webapps/archivospropuesta/"+ proposal.getCode() + "/";
              String fileName = "/home/wilmar/projectsMariana/archivosPropuestas/" + proposal.getCode();
                          System.out.println(":::FILENAME " + fileName);
             Path pathFolder = Paths.get(fileName);
                          System.out.println("pathFolder " + pathFolder);
             if (!Files.exists(pathFolder)) {
                 //Files.createDirectory(pathFolder);
                 Files.createDirectories(pathFolder);
                 System.out.println("New Directory created !  ");
             } else {
                 System.out.println("Directory already exists");
             }
                 
                 System.out.println("FILE in list " +fileOrigin.getOriginalFilename());
          //builder.append("/opt/tomcat/webapps/archivospropuesta/"+ proposal.getCode()+"/");
          builder.append("/home/wilmar/projectsMariana/archivosPropuestas/" + proposal.getCode() + "/");

              System.out.println("despues de ruta");
        builder.append(File.separator);
                         System.out.println("despues de separador ");
        builder.append(fileOrigin.getOriginalFilename());
                 System.out.println("despues de get original name ");

		 byte[] fileBytes = fileOrigin.getBytes();
                  Path path = Paths.get(builder.toString());
                  Files.write(path, fileBytes);
                  responsePacket = new ResultDTO<>(builder.toString(), true);
                  proposal.setFolder("/home/wilmar/projectsMariana/archivosPropuestas/" + proposal.getCode());
                      //proposal.setFolder("C:\\\Mariana\\Desktop\\dataProposal\\" + proposal.getCode());
                      //proposal.setFolder("/opt/tomcat/webapps/archivospropuesta/" + proposal.getCode());
                      proposalservice.updateProposal(proposal);
                       System.out.println("responsePacket" + responsePacket.getMessage());
                       return new ResponseEntity<>(responsePacket, HttpStatus.OK);

        }catch (Exception e) {
            System.out.print("entra en catch ");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> createProposal(@RequestBody Proposal reqData,
    Exception exception,
      HttpStatus httpStatus,
      WebRequest request
    ) throws IOException{
         System.out.println("entra!!");
        ResultDTO<?> responsePacket = null;
       
      try {
        int year = LocalDate.now().getYear();
        
                    System.out.println("antes de la lista proposal ");
        List<Proposal> list = new ArrayList<Proposal>(); 

        list = (List<Proposal>) proposalservice.getAllProposal();
        
           int j = 0;
            String max = "1";
            Integer m = 1;
            while (j < list.size()) {
            String[] parts = list.get(j).getCode().split("-");
            int number = Integer.parseInt(parts[1]);
                  
            if(list.get(j).getCode().equals(reqData.getCode())){
                responsePacket = new ResultDTO<>("code " +reqData.getCode() + " already exists", false);
                return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
            }
            if(number > m){
                m = number;    
            }
            j++;  
        }

        int number = m + 1;
            System.out.println("number "+ number);
        String format = String.format("%04d", number);
        String code = year + "-" + format;


        if(list.isEmpty() || "9999".equals(m)){
        String formatEmpty = String.format("%04d", 1);
        String codeEmpty = year + "-" + formatEmpty;
            reqData.setCode(codeEmpty);
        }else{
            Proposal proposal = proposalservice.getById(reqData.getId());
            if(reqData.getCode().equals("")){
                 System.out.println("entra if!!! ");
                reqData.setCode(code);
            }else{
                String url = "/home/wilmar/projectsMariana/archivosPropuestas/"+ reqData.getCode();
                String TARGET_FILE = "/home/wilmar/projectsMariana/archivosPropuestas/"+ proposal.getCode();
                File fileToMove = new File(TARGET_FILE);
                fileToMove.renameTo(new File(url));
                reqData.setFolder("/home/wilmar/projectsMariana/archivosPropuestas/" + reqData.getCode());
                reqData.setCode(reqData.getCode());
            }
        }

             responsePacket = new ResultDTO<>(proposalservice.createProposal(reqData), 
                     "Proposal Created Successfully", true);  
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
           } catch (DataIntegrityViolationException e) {
            System.out.println("entra en catchh ");
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
            responsePacket = new ResultDTO<>(proposalservice , 
                    "proposal deleted successfully !!", true);
            return new ResponseEntity<>(responsePacket, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("entra en catch");
            responsePacket = new ResultDTO<>(e.getMessage(), false);
            return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
        }
     
    }
  
}



          
     

