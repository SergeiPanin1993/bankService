package bankService.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlElement;
@JacksonXmlRootElement(localName = "deleteAccount")
public class DeleteAccountDTO {

    @XmlElement(name="clientId")
    private int clientId;

    @XmlElement(name="accountNumber")
    private String accountNumber;

    public DeleteAccountDTO(int id, String accountNumber) {
        this.clientId = id;
    }

    public DeleteAccountDTO() {
    }

    public int getClientId() {
            return clientId;
        }

    public void setClientId(int clientId) {
            this.clientId = clientId;
        }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
