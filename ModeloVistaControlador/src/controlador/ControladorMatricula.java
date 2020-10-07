/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Matricula;

/**
 *
 * @author jaime
 */
public class ControladorMatricula {
    public ArrayList<Matricula> Matricula;

    public ControladorMatricula() {
        this.Matricula = new ArrayList<Matricula>();
    }
    public ArrayList<Matricula> getMatricula() {
        return Matricula;
    }

    public void setMatricula(ArrayList<Matricula> Matricula) {
        this.Matricula = Matricula;
    }

    public ArrayList<Matricula> PedirDatosMatric() throws SQLException{
        Matricula matricu = new Matricula();
        setMatricula(matricu.pedirDatosMatric());
        return getMatricula();
    }
}
