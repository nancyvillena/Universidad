/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author nancy
 */

public class Conexion {
    
    private final String base = "ulp";
    private final String url="jdbc:mysql://localhost:3306/"+base;
    private final String user="root";
    private final String pass="";
    private Connection con;
    
    

    
    public Connection getConnection()
    {
        if(con==null)
        {
            try
            {
                 Class.forName("org.mariadb.jdbc.Driver");
         
                con = (Connection)DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");
            }
            catch (SQLException |ClassNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, "Error al conectarse");
            }
        }
                return con;
    }

}