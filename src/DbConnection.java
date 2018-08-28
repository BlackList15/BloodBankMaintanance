/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashik
 */

import java.sql.*;
import javax.swing.*;

public class DbConnection {
     Connection conn=null;
    public static Connection ConnectDb()
            {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/bloodbank","root", "");
              //  JOptionPane.showMessageDialog(null,"connected to database");
                return conn;
                
                
           /* Class.forName("com.mysql.jdbc.Driver");
            String dbpath = "jdbc:mysql://localhost/SMS";
            conn = DriverManager.getConnection(dbpath, "root", "");
            */
            }
            catch(Exception e)
            {
            JOptionPane.showMessageDialog(null,e);
            return null;
            }
            
            }
}
