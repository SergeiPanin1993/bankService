package bankService.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "account", propOrder = {"id", "currency", "accountNumber"})
public class AccountDTO {

    private int id;

    private String currency;

    private String accountNumber;

    public AccountDTO(int id, String currency, String accountNumber) {
        this.id = id;
        this.currency = currency;
        this.accountNumber = accountNumber;
    }

    public AccountDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
