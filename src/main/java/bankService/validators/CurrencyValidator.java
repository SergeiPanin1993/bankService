package bankService.validators;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CurrencyValidator {

    static String[] permittedTypesOfCurrencies;

    public static boolean validate(String typeOfCurrencies) {

        for(int i=0; i<permittedTypesOfCurrencies.length; i++){
            if(permittedTypesOfCurrencies[i].equalsIgnoreCase(typeOfCurrencies)){
                return true;
            }
        }
        return false;
    }

    public CurrencyValidator(@Value("${currency.permitCurrency}") String[] permittedTypesOfCurrencies) {
        this.permittedTypesOfCurrencies = permittedTypesOfCurrencies;
    }
}
