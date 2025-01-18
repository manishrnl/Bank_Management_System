package bank.management.system;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connect_wit_database {
    Connection connections;
    Statement statement;

    public connect_wit_database() {
        try {
            //Connecting with Mysql database
            connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankSystem", "root", "Manish@2009");
            statement = connections.createStatement();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
    }

    public static class MiniStatement {
    }
}
