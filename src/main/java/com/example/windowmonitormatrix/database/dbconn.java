package com.example.windowmonitormatrix.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbconn {
     static Connection conn = null;
    public static Connection dbconn() throws SQLException {


        try {
            //Creating a connection to the database
            conn = DriverManager.getConnection("jdbc:mariadb://192.168.1.8:3306/MMdb", "admin", "admin");

        } catch (SQLException e) {
            System.out.println("Connection with data base failed");
        }
        return conn;
    }
}