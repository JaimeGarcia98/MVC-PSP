/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Alumno;

/**
 *
 * @author jaime
 */
public class AlumnoControlador {
        public ArrayList<Alumno> Alumnos;

    public AlumnoControlador() {
        this.Alumnos = new ArrayList <Alumno>();
    }


    public ArrayList<Alumno> getAlumnos() {
        return Alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> Alumnos) {
        this.Alumnos = Alumnos;
    }
    public ArrayList<Alumno> PedirDatosAlum() throws SQLException{
        Alumno alum = new Alumno();
        setAlumnos(alum.pedirDatosAlum());
        return getAlumnos();
    }
}
