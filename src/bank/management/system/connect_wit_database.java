/*  Write this code to run on Local MYSQL System
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
*/

//  Use this to run on Online server using  MYSQL. All the table is same as in local Machine
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
            String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12758451";
            String user = "sql12758451";
            String password = "YHcSXW42B5";
            connections = DriverManager.getConnection(url, user, password);
            statement = connections.createStatement();
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }
    }

    public static void main(String[] args) {
        new bank.management.system.connect_wit_database();
    }
}
