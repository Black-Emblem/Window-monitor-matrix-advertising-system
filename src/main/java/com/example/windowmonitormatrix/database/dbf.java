package com.example.windowmonitormatrix.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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

    public static Boolean getMonitorState(int monitor_ID) throws SQLException
    {
        String sqlStr = "select monitor_state from monitors where monitor_ID = ?";
        PreparedStatement ps = db_conn().prepareStatement(sqlStr);
        ps.setInt(1, monitor_ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getInt("monitor_state") == 1){
                return true;
            } else if (rs.getInt("monitor_state") == 0){
                return false;
            }
            {
                return false;
            }
        }
        return false;
    }

    public static String getMonitorheartbeat(int monitor_ID) throws SQLException
    {
        String sqlStr = "select heartbeat from monitors where monitor_ID = ?";
        PreparedStatement ps = db_conn().prepareStatement(sqlStr);
        ps.setInt(1, monitor_ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return String.valueOf(rs.getTimestamp("heartbeat"));
        }
        return "Null";
    }

    public static void updateMonitorView(int monitor_ID, int listing_ID) throws SQLException {
        String sqlStr = "update monitors set Current_listingID = ? where monitor_ID = ?";
        PreparedStatement ps = db_conn().prepareStatement(sqlStr);
        ps.setInt(1, listing_ID);
        ps.setInt(2, monitor_ID);
        ps.executeUpdate();
    }

    public static void setMonitorState(int monitor_ID, int state) throws SQLException
    {
        String sqlStr = "update monitors set monitor_state = ? where monitor_ID = ?";
        PreparedStatement ps = db_conn().prepareStatement(sqlStr);
        ps.setInt(1, state);
        ps.setInt(2, monitor_ID);
        ps.executeUpdate();
    }

    public static int getNumberOfentrys(String tablename) throws SQLException {
        String sqlStr = "select count(*) from "+tablename;
        PreparedStatement ps = db_conn().prepareStatement(sqlStr);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public static String getStringfromtable(int ID, String tableName, String columnName) throws SQLException {
        String sqlStr = "select " + columnName + " from " + tableName + " where ID = ?";
        PreparedStatement ps = db_conn().prepareStatement(sqlStr);
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getString(columnName);
        }
        return null;
    }

    public static int getIntfromtable(int ID, String tableName, String columnName) throws SQLException {
        String sqlStr = "select " + columnName + " from " + tableName + " where ID = ?";
        PreparedStatement ps = db_conn().prepareStatement(sqlStr);
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(columnName);
        }
        return Integer.parseInt(null);
    }
}