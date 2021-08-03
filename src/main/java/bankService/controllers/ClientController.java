package bankService.controllers;

import bankService.BankServiceApplication;
import bankService.dto.ClientListDTO;
import bankService.dto.DeleteClientDTO;
import bankService.dto.NewClientDTO;
import bankService.services.ClientService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    static final Logger log = BankServiceApplication.getLog();

    @PostMapping(value = "/newClient", consumes={"application/xml"})
    public ResponseEntity<String> createNewClient(@RequestBody NewClientDTO newClientDTO){
        log.info("ClientController: add New Client Request");
        if(!clientService.saveNewClientInDB(newClientDTO)){
            log.info("ClientController: client not add");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        log.info("ClientController: successfully adding New Client");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/clients", produces="application/xml")
    public ClientListDTO getAllClients(){
        log.info("ClientController: client List Request");
        try {
            log.info("ClientController: successfully client List");
            return clientService.listOfClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("ClientController: unsuccessfully client List");
        return null;
    }
    @PostMapping(value = "/deleteClient", consumes="application/xml")
    public ResponseEntity<String> deleteClient(@RequestBody DeleteClientDTO deleteClientDTO) throws Exception{
        log.info("ClientController: delete client Request");
        if(!clientService.deleteClient(deleteClientDTO.getId())){
            log.info("ClientController: unsuccessfully delete client");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        log.info("ClientController: successfully delete client");
        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
