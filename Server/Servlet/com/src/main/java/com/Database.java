package com;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
 
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
 
public class Database  {
 
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
 
    static
    {
        try
        {
            Class.forName(DRIVER_NAME).newInstance();
            System.out.println("*** Driver loaded");
        }
        catch(Exception e)
        {
            System.out.println("*** Error : "+e.toString());
            System.out.println("*** ");
            System.out.println("*** Error : ");
            e.printStackTrace();
        }
 
    }
 
    private static final String URL = "jdbc:mysql://localhost:8889/rental_car";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
 
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
 
   
}

