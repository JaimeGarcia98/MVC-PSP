/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Modelo;

/**
 *
 * @author jaime
 */
public class Alumno extends Modelo{
     private String Dni;
     private String Nombre;
     private String Apellidos;
     private ArrayList<Alumno> Alumnos;

    public Alumno() {
        this.Dni = "";
        this.Nombre = "";
        this.Apellidos = "";
        this.Alumnos = new ArrayList<Alumno>();
    }

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

        public ArrayList<Alumno> getAlumnos() {
            return Alumnos;
        }

        public void setAlumnos(ArrayList<Alumno> Alumnos) {
            this.Alumnos = Alumnos;
        }
        
        @Override
        public String toString() {
            return "Alumno{" + "Dni=" + Dni + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + '}';
        }
        
        public ArrayList<Alumno> pedirDatosAlum() throws SQLException{
            this.conectar();
            String seleccion = "SELECT * FROM ALUMNO ";
            try{
                Statement stmt = getConex().createStatement();   
                ResultSet rs = stmt.executeQuery(seleccion);

                while(rs.next()) {
                    Alumno alum = new Alumno();
                    alum.setDni(rs.getString("dni"));
                    alum.setNombre(rs.getString("Nombre"));
                    alum.setApellidos(rs.getString("Apellidos"));

                    this.getAlumnos().add(alum);
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }

            return Alumnos;
        }
}
