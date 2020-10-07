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

/**
 *
 * @author jaime
 */
public class Matricula extends Modelo{
    private String Dni;
    private String Cod_Asig;
    private ArrayList<Matricula> Matricula;

    public Matricula() {
        this.Dni = "";
        this.Cod_Asig = "";
        this.Matricula = new ArrayList<Matricula>();
    }
    
    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getCod_Asig() {
        return Cod_Asig;
    }

    public void setCod_Asig(String Cod_Asig) {
        this.Cod_Asig = Cod_Asig;
    }

    public ArrayList<Matricula> getMatricula() {
        return Matricula;
    }

    public void setMatricula(ArrayList<Matricula> Matricula) {
        this.Matricula = Matricula;
    }

    @Override
    public String toString() {
        return "Matricula {" + "Dni=" + Dni + ", Cod_Asig=" + Cod_Asig + '}';
    }
 
        public ArrayList<Matricula> pedirDatosMatric() throws SQLException{
            this.conectar();
            String seleccion = "SELECT * FROM MATRICULA ";
            try{
                Statement stmt = conex.createStatement();   
                ResultSet rs = stmt.executeQuery(seleccion);

                while(rs.next()) {
                    Matricula matric = new Matricula();
                    matric.setDni(rs.getString("dni"));
                    matric.setCod_Asig(rs.getString("cod_asig"));


                    this.getMatricula().add(matric);
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

            return Matricula;
        }
}
