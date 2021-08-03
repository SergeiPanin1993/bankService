package bankService.dao;

import bankService.model.Account;
import bankService.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BankServiceDatabaseRepository {

    @Autowired
    BankServiceDatabase bankServiceDatabase;

    public Client getClientById(int id) throws Exception {
        Connection conn = null;
        try {
            conn = bankServiceDatabase.getDataSource().getConnection();
            PreparedStatement prstmt = conn.prepareStatement("SELECT * FROM clients WHERE id = ?");
            prstmt.setString(1, String.valueOf(id));
            ResultSet rsClient = prstmt.executeQuery();
            if(rsClient.next()){
                Client client = new Client(
                        rsClient.getInt("id"),
                        rsClient.getString("last_name"),
                        rsClient.getString("first_name"),
                        rsClient.getString("patronymic"),
                        rsClient.getString("document_type"),
                        rsClient.getString("document_number"),
                        rsClient.getString("date_of_birth"));
                conn.close();
                return client;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public int getClientIdByDocument(String documentType, String documentNumber){
        Connection conn = null;
        try {
            conn = bankServiceDatabase.getDataSource().getConnection();
            PreparedStatement prstmt = conn.prepareStatement("SELECT id FROM clients WHERE document_type = ? AND document_number = ?");
            prstmt.setString(1, documentType);
            prstmt.setString(2, documentNumber);
            ResultSet rsClient = prstmt.executeQuery();
            if(rsClient.next()){
                conn.close();
                return Integer.parseInt(rsClient.getString("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;
    }

    public boolean addNewClient(Client client){
        Connection conn = null;
        try {
            conn = bankServiceDatabase.getDataSource().getConnection();
            PreparedStatement prstmt = conn.prepareStatement(
               "INSERT INTO clients (last_name, first_name, patronymic, document_type, document_number, date_of_birth) VALUES (?, ?, ?, ?, ?, ?)");
            prstmt.setString(1, client.getLastName());
            prstmt.setString(2, client.getFirstName());
            prstmt.setString(3, client.getPatronymic());
            prstmt.setString(4, client.getDocumentType());
            prstmt.setString(5, client.getDocumentNumber());
            prstmt.setString(6, client.getDateOfBirth());
            int result = prstmt.executeUpdate();
            conn.close();
            if (result == 1){return true;}

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public List<Client> getListOfClients() throws Exception {
        Connection conn = null;
        List<Client> resultList = new ArrayList<>();
        try {
            conn = bankServiceDatabase.getDataSource().getConnection();
            PreparedStatement prstmt = conn.prepareStatement("SELECT * FROM clients;");
            ResultSet rsClient = prstmt.executeQuery();
            while(rsClient.next()){
                Client client = new Client(
                        rsClient.getInt("id"),
                        rsClient.getString("last_name"),
                        rsClient.getString("first_name"),
                        rsClient.getString("patronymic"),
                        rsClient.getString("document_type"),
                        rsClient.getString("document_number"),
                        rsClient.getString("date_of_birth"));
                resultList.add(client);
            }
            conn.close();
            return resultList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public boolean deleteClient(Client client) throws Exception {
        Connection conn = null;
        if(client != null){
            conn = bankServiceDatabase.getDataSource().getConnection();
            PreparedStatement prstmt = conn.prepareStatement("DELETE FROM clients WHERE id = ?;");
            prstmt.setInt(1, client.getId());
            int result = prstmt.executeUpdate();
            conn.close();
            if(result == 1){
                return true;
            }
        }
        return false;
    }
    public boolean newAccount(Account account, int clientId) throws Exception {
        Connection conn = null;
        conn = bankServiceDatabase.getDataSource().getConnection();
        PreparedStatement prstmt = conn.prepareStatement("INSERT INTO account (account_number, currency, client_id) VALUES (?, ?, ?)");
        prstmt.setString(1, account.getNumber());
        prstmt.setString(2, account.getCurrency());
        prstmt.setInt(3, clientId);
        int result = prstmt.executeUpdate();
        conn.close();
        if(result == 1){
            return true;
        }
        return false;
    }
    public List<Account> infoAboutClientAccount(int id) throws Exception{
        Connection conn = null;
        List<Account> result = new ArrayList<>();
        conn = bankServiceDatabase.getDataSource().getConnection();
        PreparedStatement prstmt = conn.prepareStatement("SELECT * FROM account WHERE client_id = ?");
        prstmt.setInt(1, id);
        ResultSet rs = prstmt.executeQuery();
        while (rs.next()){
            Account account = new Account(rs.getInt("id"), rs.getString("currency"), rs.getString("account_number"));
            result.add(account);
        }

        conn.close();
        return result;
    }
    public boolean deleteAccount(int clientId, String accountNumber) throws Exception{
        Connection conn = null;
        conn = bankServiceDatabase.getDataSource().getConnection();
        PreparedStatement prstmt = conn.prepareStatement("DELETE FROM account WHERE client_id = ? AND account_number = ?");
        prstmt.setInt(1, clientId);
        prstmt.setString(2, accountNumber);
        int result = prstmt.executeUpdate();
        conn.close();
        if(result == 1){
            return true;
        }

        return false;
    }

}
