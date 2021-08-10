package bankService.validators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DocumentValidator {

    static String[] permittedTypesOfDocuments;


    public static boolean validate(String typeOfDocument) {

        for(int i=0; i<permittedTypesOfDocuments.length; i++){
            if(permittedTypesOfDocuments[i].equalsIgnoreCase(typeOfDocument)){
                return true;
            }
        }
        return false;
    }

    public DocumentValidator(@Value("${documents.permitTypes}") String[] permittedTypesOfDocuments ){
        this.permittedTypesOfDocuments = permittedTypesOfDocuments;
    }
}
