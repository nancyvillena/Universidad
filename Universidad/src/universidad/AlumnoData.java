/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nancy
 */
public class AlumnoData {
     private Connection con;


    public AlumnoData (Conexion conexion) {
      con= conexion.getConnection();//obtengo la coneccion a la base de datos 
    
    }  
    public void guardarAlumno(Alumno alumno){
          
         try{            
         String sql="INSERT INTO alumno (nombreAlumno, fechaNacimiento, activo) VALUES(?, ?, ?);";
        //La variable PreparedStatement sirve para hacer cualquier operacion en la base de datos
        
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ps.setString(1,alumno.getNombre_alumno());
        ps.setDate(2, Date.valueOf(alumno.getFn_alumno()));//valueOf tranforma el Localdate que devuelve el getFecNac al tipo Date que la BD entiende
        ps.setBoolean(3, alumno.isActivo());
            
            
            int filas = ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();           
               
               
             
            if (rs.next()) {
                alumno.setId_alumno(rs.getInt(1));//recupero el id
            } else {
                JOptionPane.showMessageDialog(null,"No puedo obtener id");
            }
       
        con.close();
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null,"Error al guardar Alumno");
        }
       
}

 public void borrarAlumno(int id_alumno){
    
     
        try {
            
            String sql = "DELETE FROM alumno  WHERE idAlumno=?;";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_alumno);
            ps.executeUpdate();
            ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
          JOptionPane.showMessageDialog(null,"Error al Borrar Alumno");
          
        }
    
   
   public void actualizarAlumno(Alumno alumno){
       
       
        try {
            String sql = "UPDATE alumno SET  nombreAlumno=?,  fechaNacimiento=? , activo=? WHERE idAlumno=?;";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, alumno.getNombre_alumno());
            ps.setDate(2, Date.valueOf(alumno.getFn_alumno()));
            ps.setBoolean(3, alumno.isActivo());
            ps.setInt(4, alumno.getId_alumno());
                  
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"El alumno se actualizó correctamente");
           
             
         /* ResultSet rs = ps.getGeneratedKeys();//recorre la base de datos para dar el id
            
           if (rs.next()){
            
            alumno.setId(rs.getInt(1)); //recupero el id
             
          }
          else {
               System.out.println("Error al actualizar Alumno "); 
           }*/
        ps.close();
                    
           
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }   
       
   }


public Alumno buscarAlumno(int id){
    
 Alumno alumno = null;
        try {
            
           String sql = "SELECT * FROM alumno  WHERE idAlumno=?;";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();//no modifica la BD solo saca informacion
            
            
            while(resultSet.next()){//el while recorre toda la BD
                
                alumno = new Alumno();
                alumno.setId_alumno(resultSet.getInt("idAlumno"));
                alumno.setNombre_alumno(resultSet.getString("nombreAlumno"));
                alumno.setFn_alumno(resultSet.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(resultSet.getBoolean("activo"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return alumno;
}

public List<Alumno> obtenerAlumnos(){
 
    List<Alumno> alumnos = new ArrayList<Alumno>();
            
        try {
           
            String sql = "SELECT * FROM alumno;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Alumno alumno;
            
            while(resultSet.next()){
                
                alumno = new Alumno();
                alumno.setId_alumno(resultSet.getInt("idAlumno"));
                alumno.setNombre_alumno(resultSet.getString("nombreAlumno"));
                alumno.setFn_alumno(resultSet.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(resultSet.getBoolean("activo"));               
                
                alumnos.add(alumno);
            }  
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }  
return alumnos;
}
}


    

