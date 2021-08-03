package bankService.controllers;

import bankService.BankServiceApplication;
import bankService.dto.DeleteAccountDTO;
import bankService.dto.InfoAboutClientAccountsReqDTO;
import bankService.dto.InfoAboutClientAccountsRespDTO;
import bankService.dto.NewAccountDTO;
import bankService.services.AccountService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {

    static final Logger log = BankServiceApplication.getLog();

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/newAccount", consumes={"application/xml"})
    public ResponseEntity<String> createNewAccount(@RequestBody NewAccountDTO newAccountDTO) throws Exception {
        log.info("AccountController: add New Account Request");
        if(!accountService.addNewAccountToDB(newAccountDTO)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping(value = "/aboutAccounts", consumes={"application/xml"}, produces="application/xml")
    public InfoAboutClientAccountsRespDTO getInfoAboutClientAccounts(@RequestBody InfoAboutClientAccountsReqDTO infoAboutClientAccountsDTO) throws Exception {
       return accountService.getInfoAboutClientAccounts(infoAboutClientAccountsDTO);
    }

    @PostMapping(value = "/deleteAccount", consumes={"application/xml"})
    public ResponseEntity<String> deleteAccount(@RequestBody DeleteAccountDTO deleteAccountDTO) throws Exception {
        if(!accountService.deleteAccount(deleteAccountDTO.getClientId(), deleteAccountDTO.getAccountNumber())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
