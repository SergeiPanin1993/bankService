package bankService.model;

import bankService.exception.CurrencyValidationException;
import bankService.validators.CurrencyValidator;

public class Account {
    private int id;
    private String currency;
    private String number;

    public Account(String currency, String number) throws Exception {
        this.id = -1;
        this.number = number;
        if(CurrencyValidator.validate(currency)) {
            this.currency = currency;
        }else{
            throw new CurrencyValidationException();
        }
    }

    public Account(int id, String currency, String number) throws Exception{
        this.id = id;
        this.number = number;
        if(CurrencyValidator.validate(currency)) {
            this.currency = currency;
        }else{
            throw new CurrencyValidationException();
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
