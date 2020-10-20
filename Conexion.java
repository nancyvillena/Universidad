/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pascu
 */
public class Conexion {
    
    private final String base = "universidad3";
    private final String url="jdbc:mysql://localhost:3306/"+base;
    private final String user="pascu";
    private final String pass="";
    private Connection con;
    
    public Connection getConnection()
    {
        if(con==null)
        {
            try
            {
                 Class.forName("org.mariadb.jdbc.Driver");
         
                con = (Connection)DriverManager.getConnection(url, user, pass);
            }
            catch (SQLException |ClassNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, "Error al conectarse");
            }
        }
                return con;
    }

}
