package bankService.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@JacksonXmlRootElement(localName = "ClientAccounts")
public class InfoAboutClientAccountsRespDTO {

    @XmlElement(name="clientId")
    int clientId;

    @JacksonXmlElementWrapper(localName = "listOfClients")
    @XmlElement(name="account")
    List<AccountDTO> account;

    public InfoAboutClientAccountsRespDTO(int clientId, List<AccountDTO> account) {
        this.clientId = clientId;
        this.account = account;
    }
}
