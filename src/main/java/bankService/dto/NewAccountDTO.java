package bankService.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlElement;

@JacksonXmlRootElement(localName = "newAccount")
public class NewAccountDTO {

    @XmlElement(name="clientId")
    private int clientId;

    @XmlElement(name="currency")
    private String currency;

    @XmlElement(name="accountNumber")
    private String accountNumber;

    public NewAccountDTO(int clientId, String currency, String accountNumber) {
        this.clientId = clientId;
        this.currency = currency;
        this.accountNumber = accountNumber;
    }

    public NewAccountDTO() {
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
