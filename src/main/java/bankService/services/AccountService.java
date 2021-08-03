package bankService.services;

import bankService.dao.BankServiceDatabaseRepository;
import bankService.dto.AccountDTO;
import bankService.dto.InfoAboutClientAccountsReqDTO;
import bankService.dto.InfoAboutClientAccountsRespDTO;
import bankService.dto.NewAccountDTO;
import bankService.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountService {

    @Autowired
    BankServiceDatabaseRepository bankServiceDatabaseRepository;

    public boolean addNewAccountToDB(NewAccountDTO newAccountDTO) throws Exception{
        Account account = new Account(newAccountDTO.getCurrency(), newAccountDTO.getAccountNumber());
        return bankServiceDatabaseRepository.newAccount(account, newAccountDTO.getClientId());
    }

    public InfoAboutClientAccountsRespDTO getInfoAboutClientAccounts(InfoAboutClientAccountsReqDTO infoAboutClientAccountsReqDTO) throws Exception{
        List<Account> listAccountsFromDB = bankServiceDatabaseRepository.infoAboutClientAccount(infoAboutClientAccountsReqDTO.getId());
        List<AccountDTO> accounts = new ArrayList<>();
        for(Account account : listAccountsFromDB){
            accounts.add(new AccountDTO(account.getId(), account.getCurrency(), account.getNumber()));
        }
        return new InfoAboutClientAccountsRespDTO(infoAboutClientAccountsReqDTO.getId(), accounts);
    }

    public boolean deleteAccount(int id, String accountNumber) throws Exception {
        return bankServiceDatabaseRepository.deleteAccount(id, accountNumber );
    }


}
