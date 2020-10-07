/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Asignaturas;

/**
 *
 * @author jaime
 */
public class AsignaturasControlador {
    private ArrayList<Asignaturas> Asignatura;

    public AsignaturasControlador() {
        this.Asignatura = new ArrayList<Asignaturas>();
    }

    public ArrayList<Asignaturas> getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(ArrayList<Asignaturas> Asignatura) {
        this.Asignatura = Asignatura;
    }
      
    public ArrayList<Asignaturas> PedirDatosAsig() throws SQLException{
        Asignaturas asig = new Asignaturas();
        setAsignatura(asig.pedirDatosAsig());
        return getAsignatura();
    }
    public ArrayList<Asignaturas>PedirAsignaturasDeAlumno(String NomAlum) throws SQLException{
        Asignaturas asig = new Asignaturas();
        setAsignatura(asig.pedirAsignaturasDeUnAlumno(NomAlum));
        return getAsignatura();
    }
}
