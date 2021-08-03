package bankService.dao;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class BankServiceDatabase {

    private static JdbcDataSource ds;

    public JdbcDataSource getDataSource() {
        return ds;
    }

    public static void createDB(){
        ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:~/test");
        ds.setUser("sa");
        ds.setPassword("sa");
        Connection conn;
        Statement stmt;
        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();

            createTables();
            addTestDataToDB();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void createTables() throws SQLException {
            Connection conn;
            Statement stmt;
            conn = ds.getConnection();
            stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS clients"); // for test
            stmt.execute("DROP TABLE IF EXISTS account"); // for test
            stmt.execute("CREATE TABLE IF NOT EXISTS clients (id int primary key auto_increment, last_name varchar(255), first_name varchar(255), patronymic varchar(255), document_type varchar(255), document_number varchar(255), date_of_birth varchar(255));");
            stmt.execute("CREATE TABLE IF NOT EXISTS account (id int primary key auto_increment, account_number varchar(255), currency varchar(255), client_id int, FOREIGN KEY (client_id)  REFERENCES clients (Id) ON DELETE CASCADE);");

            stmt.close();
            conn.close();

        }

    public static void addTestDataToDB() throws SQLException {
            Connection conn;
            Statement stmt;
            conn = ds.getConnection();
            stmt = conn.createStatement();

            stmt.execute("INSERT INTO clients (last_name, first_name, patronymic, document_type, document_number, date_of_birth) VALUES ('Ivanov', 'Ivan', 'Ivanovich', 'passport', '9379992', '01.01.1990');");
            stmt.execute("INSERT INTO account (account_number, currency, client_id) VALUES ('12345', 'RUB', 1);");


            stmt.execute("INSERT INTO clients (last_name, first_name, patronymic, document_type, document_number, date_of_birth) VALUES ('Petrov', 'Petr', 'Petrovich', 'passport', '45678', '01.01.1980');");
            stmt.execute("INSERT INTO account (account_number, currency, client_id) VALUES ('34567', 'RUB', 2);");


            stmt.execute("INSERT INTO clients (last_name, first_name, patronymic, document_type, document_number, date_of_birth) VALUES ('Sidorov', 'Sidor', 'Sidorovich', 'passport', '4246262', '01.01.1970');");
            stmt.execute("INSERT INTO account (account_number, currency, client_id) VALUES ('890', 'USD', 3);");

            stmt.close();
            conn.close();
    }
}
