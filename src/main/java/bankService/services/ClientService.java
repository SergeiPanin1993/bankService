package bankService.services;

import bankService.dao.BankServiceDatabaseRepository;
import bankService.dto.ClientDTO;
import bankService.dto.ClientListDTO;
import bankService.dto.NewClientDTO;
import bankService.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientService {

    @Autowired
    BankServiceDatabaseRepository bankServiceDatabaseRepository;

    public boolean saveNewClientInDB(NewClientDTO newClientDTO){
        try {
            Client client = new Client(
                    -1,
                    newClientDTO.getLastName(),
                    newClientDTO.getFirstName(),
                    newClientDTO.getPatronymic(),
                    newClientDTO.getDocumentType(),
                    newClientDTO.getDocumentNumber(),
                    newClientDTO.getDateOfBirth());

            return bankServiceDatabaseRepository.addNewClient(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ClientListDTO listOfClient() throws Exception{
        List<Client> listFromDB = bankServiceDatabaseRepository.getListOfClients();
        List<ClientDTO> result = new ArrayList<>();
        for(Client client : listFromDB){
            result.add(new ClientDTO(
                    client.getId(),
                    client.getLastName(),
                    client.getFirstName(),
                    client.getPatronymic(),
                    client.getDocumentType(),
                    client.getDocumentNumber(),
                    client.getDateOfBirth()));
        }
        ClientListDTO clientListDTO = new ClientListDTO(result);
        return clientListDTO;
    }
    public boolean deleteClient(int id) throws Exception{
        Client client = bankServiceDatabaseRepository.getClientById(id);
        return bankServiceDatabaseRepository.deleteClient(client);
    }
}
