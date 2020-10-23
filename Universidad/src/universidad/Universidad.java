/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author nancy
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
         
    
       
    /* Alumno a1 = new Alumno();
      
      a1.setNombre_alumno("Fernanda Gomez");
      a1.setFn_alumno(LocalDate.of(2010,Month.DECEMBER, 12));
      a1.setActivo(true);*/
     
      
      Conexion con= new Conexion();
        

      
    /*AlumnoData ad= new AlumnoData(con);
      ad.guardarAlumno(a1);*/
      // a1= ad.buscarAlumno(3);        
                        
       // ad.actualizarAlumno(a2);
      
    Materia m1= new Materia();
    
           m1.setNombreMateria("Matematica");
          
        
     MateriaData md=new MateriaData(con);
     md.guardarMateria(m1);
    //m1= md.buscarMateria(2);
        
       
       /* Materia m2= new Materia();
        m2.setNombre("Programacion 1");
     
        
    //   MateriaData md=new MateriaData(con);
      // md.guardarMateria(m2);*/
       
    
       
    }
    
    }
    

