package bankService.model;

import bankService.exception.DocumentTypeValidationException;
import bankService.validators.DocumentValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String documentType;
    private String documentNumber;
    private String dateOfBirth;

    public Client(int id, String lastName, String firstName, String patronymic, String documentType, String documentNumber,
                  String dateOfBirth) throws Exception {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.documentNumber = documentNumber;
        this.dateOfBirth = dateOfBirth;

        if(DocumentValidator.validate(documentType)){
            this.documentType = documentType;
        }else{
            throw new DocumentTypeValidationException();
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirthAsDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = format.parse(dateOfBirth);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setDateOfBirthInDate(Date dateOfBirth) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String date = new SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth);
        this.dateOfBirth = date;
    }

    public int getId() {
        return id;
    }
}
