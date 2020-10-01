/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.ConexionBD;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jaime
 */
public class Controlador {
    
    public class Alumno{
        private String Dni;
        private String Nombre;
        private String Apellidos;

        public String getDni() {
            return Dni;
        }

        public void setDni(String Dni) {
            this.Dni = Dni;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public String getApellidos() {
            return Apellidos;
        }

        public void setApellidos(String Apellidos) {
            this.Apellidos = Apellidos;
        }
        
        
        
    }
    
    public class Asignaturas{
        private String Cod_Asig;
        private String Nombre_Asig;

        public String getCod_Asig() {
            return Cod_Asig;
        }

        public void setCod_Asig(String Cod_Asig) {
            this.Cod_Asig = Cod_Asig;
        }

        public String getNombre_Asig() {
            return Nombre_Asig;
        }

        public void setNombre_Asig(String Nombre_Asig) {
            this.Nombre_Asig = Nombre_Asig;
        }
        
        
    }
    
    private ArrayList<Alumno> Alumnos;
    private ArrayList<Asignaturas> Asignaturas;
    
    private final String seleccion = "SELECT * ALUMNO FROM";

    public ArrayList<Alumno> getAlumnos() {
        return Alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> Alumnos) {
        this.Alumnos = Alumnos;
    }

    public ArrayList<Asignaturas> getAsignaturas() {
        return Asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignaturas> Asignaturas) {
        this.Asignaturas = Asignaturas;
    }
    
    public String getSeleccion(){
        return this.seleccion;
    }
    
    
    public ArrayList<Alumno> printAlumno() throws SQLException{
        ConexionBD conects = new ConexionBD();
        
        Statement stmt = null;
        
        ResultSet rs = null;
        
        Alumno alum = new Alumno();
        
        try{
            
            stmt = conects.conectar();
            
            rs = stmt.executeQuery(seleccion);
            
            while(rs.next()) {
                
                alum.setDni(rs.getString("dni"));
                alum.setNombre(rs.getString("Nombre"));
                alum.setApellidos(rs.getString("Apellidos"));
                
                this.getAlumnos().add(alum);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return Alumnos;
    }
}
