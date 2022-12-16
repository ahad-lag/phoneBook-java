package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String Db_name = "PhoneBook.db";
    private static final String ConnectionString = "jdbc:sqlite:C:\\Users\\avajang_pc\\IdeaProjects\\PhoneBook" + Db_name;
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public boolean OpenDB(){
        try {
            connection = DriverManager.getConnection(ConnectionString);
            return true;
        } catch (SQLException e) {
            System.out.println("Error Connect To Database" + e.getMessage());
            return false;
        }
    }

    public boolean CloseDB(){
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error Close Database" + e.getMessage());
            return false;
        }
    }


}
