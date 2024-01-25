package com.example.windowmonitormatrix.database;

import java.sql.*;

import static java.lang.Class.*;

public class dbconn {
    static Connection conn = null;

    public static Connection db_conn() throws SQLException {
        final String DB_URL = "jdbc:mariadb://192.168.1.8:3306/MMdb";

        final String USER = "admin";
        final String PASS = "admin";

        try {
            //Creating a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            throw new RuntimeException("Connection with database failed", e);
        }

        return conn;
    }

    // Method to test connection with database
    public static String testConnection() {
        try {
            if(conn != null && !conn.isClosed()) {
                return "Connection with database is successful.";
            } else {
                return "No connection with database.";
            }
        } catch(SQLException e) {
            return "An error occurred while testing the database connection.";
        }
    }
}