package bankService.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlElement;

@JacksonXmlRootElement(localName = "deleteClient")
public class DeleteClientDTO {

    @XmlElement(name="id")
    private int id;

    public DeleteClientDTO(int id) {
        this.id = id;
    }

    public DeleteClientDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
