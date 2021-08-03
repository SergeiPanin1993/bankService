package bankService.validators;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class CurrencyValidator {

    public static boolean validate(String typeOfCurrencies) {

        String[] permittedTypesOfDocuments = getProperty();

        for(int i=0; i<permittedTypesOfDocuments.length; i++){
            if(permittedTypesOfDocuments[i].equalsIgnoreCase(typeOfCurrencies)){
                return true;
            }
        }
        return false;
    }
    public static String[] getProperty(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream("application.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String permitDocs = properties.getProperty("currency.permitCurrency");
        String[] result = permitDocs.split(",");
        return result;
    }
}
