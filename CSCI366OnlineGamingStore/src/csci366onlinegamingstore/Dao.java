/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csci366onlinegamingstore;
import java.sql.*;
/**
 *
 * @author jmcmo
 */
public class Dao {
    static String jdbcURL = "jdbc:postgresql://localhost:5432/CSCI 366 Final Project";
    static String username = "postgres";
    static String password = "Donkeyjpandbeans";
    
    private static Connection conn;
    
    public static void connectToDatabase(){
        try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(jdbcURL, username, password);
            } catch (ClassNotFoundException e) {
            System.err.println("Failed to load PostgreSQL driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to database");
            e.printStackTrace();
        }   
    }
    public static void closeConnection () throws SQLException{
        if(conn != null){
            conn.close();
        }
    }
    public static Connection getConnection(){
        if (conn == null) {
            connectToDatabase();
        }
        return conn;
    }
}