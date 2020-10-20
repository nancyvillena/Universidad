/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import universidad.entidades.Alumno;
import universidad.modelo.AlumnoData;
import universidad.modelo.Conexion;
/**
 *
 * @author pascu
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Conexion c=new Conexion();
        
        Alumno juan = new Alumno("Juan Perez",LocalDate.of(1983, Month.APRIL, 8),true);
        AlumnoData ad=new AlumnoData(c);
        ad.guardarAlumno(juan);
        
    }
    
}
