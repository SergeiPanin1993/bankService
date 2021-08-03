package bankService;

import bankService.dao.BankServiceDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BankServiceApplication {
    static final Logger log = LoggerFactory.getLogger(BankServiceApplication.class);
    public static void main(String[] args) throws Exception{

        SpringApplication.run(BankServiceApplication.class, args);
        BankServiceDatabase.createDB();
        BankServiceDatabase.createTables();
        BankServiceDatabase.addTestDataToDB();

    }

    public static Logger getLog() {
        return log;
    }
}
