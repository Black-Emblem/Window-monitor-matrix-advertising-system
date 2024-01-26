package com.example.windowmonitormatrix.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.windowmonitormatrix.database.dbconn.db_conn;

public class dbf {

    public static String getMonitorView(int monitor_ID) throws SQLException
    {
        String sqlStr = "select Current_listingID from monitors where monitor_ID = ?";
        PreparedStatement ps = db_conn().prepareStatement(sqlStr);
        ps.setInt(1, monitor_ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return String.valueOf(rs.getInt("Current_listingID"));
        }
        return "-1";
    }

}