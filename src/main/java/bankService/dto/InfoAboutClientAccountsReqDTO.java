package bankService.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlElement;
@JacksonXmlRootElement(localName = "clientInfo")
public class InfoAboutClientAccountsReqDTO {

    @XmlElement(name="id")
    private int id;

    public InfoAboutClientAccountsReqDTO(int id) {
        this.id = id;
    }

    public InfoAboutClientAccountsReqDTO() {
    }

    public int getId() {
            return id;
        }

    public void setId(int id) {
        this.id = id;
     }
}
