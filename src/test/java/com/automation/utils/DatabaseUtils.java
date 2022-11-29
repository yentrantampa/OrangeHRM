//package com.automation.utils;
//
//import java.sql.*;
//
////to connect project to the database
////ResultSet - class that stores results from query
////Statement - The object used for executing a static SQL statement and returning the results it produces.
//
//public class DatabaseUtils {
//    Static Connection con;
//
//    public static void initDatabase() throws Exception {
//        //Connect to database
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb", "root", "tr4nh4iy3n");
//    }
//
//    public static ResultSet executeQuery() throws Exception {
//        //Query to database
//        Statement statement = con.createStatement();
//        ResultSet result = statement.executeQuery("select first_name from employees;");
//        return result;
//
//        //Print result to console
//        while (result.next()) {
//            System.out.println(result.getString(1));
//        }
//        public static void closeConnection () throws Exception {
//            con.close();
//        }
//    }
//}
