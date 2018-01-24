/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndlinh
 */
public class EmployeeManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String URL = "jdbc:odbc:apt";
        String URL = "jdbc:jtds:sqlserver://localhost/EmployeeManagement;instance=SQLEXPRESS"; // ko can dat port 1433
        //String URL = "jdbc:sqlserver://localhost;databaseName=EmployeeManagement"; // can dat port 1433
        //String URL = "jdbc:sqlserver://localhost;databaseName=EmployeeManagement;user=sa;password=ducminhvu7101996;"; // can dat port 1433
        //String URL = "jdbc:sqlserver://localhost:1433;databaseName=EmployeeManagement";
        
        Connection con = null;
        PreparedStatement stm = null;
        //Statement stm = null;
        ResultSet rs = null;
        try {
            //con = DriverManager.getConnection(URL,"sa","ducminhvu7101996");
            con = DriverManager.getConnection(URL,"sa","ducminhvu7101996");
            //con = DriverManager.getConnection(URL,"sa","ducminhvu7101996");
            //con = DriverManager.getConnection(URL);
            //con = DriverManager.getConnection(URL,"HDMV","ducminhvu7101996");
            
            stm = con.prepareStatement("SELECT * FROM EMPLOYEE ");
            rs = stm.executeQuery();
            //stm = con.createStatement();
            //rs = stm.executeQuery("SELECT * FROM EMPLOYEE ");
            while(rs.next()){
                String name = rs.getString("NAME");
                String address = rs.getString("ADDRESS");
                String phone = rs.getString("PHONE");
                System.out.println("Name:" + name);
                System.out.println("Address:" + address);
                System.out.println("Phone:" + phone);
                System.out.println("************************");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
