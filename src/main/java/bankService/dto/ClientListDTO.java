package bankService.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@JacksonXmlRootElement(localName = "clients")
public class ClientListDTO {

    @JacksonXmlElementWrapper(localName = "listOfClients")
    @XmlElement(name="name")
    List<ClientDTO> client;

    public List<ClientDTO> getClient() {
        return client;
    }

    public void setClient(List<ClientDTO> client) {
        this.client = client;
    }

    public ClientListDTO(List<ClientDTO> listOfClients) {
        this.client = listOfClients;
    }
}
