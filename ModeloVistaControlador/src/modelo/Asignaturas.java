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
public class Asignaturas extends Modelo{
      private String Cod_Asig;
      private String Nombre_Asig;
      private ArrayList<Asignaturas> Asignatura;

    public Asignaturas() {
        this.Cod_Asig = "";
        this.Nombre_Asig = "";
        this.Asignatura = new ArrayList<Asignaturas>();
    }

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
        public ArrayList<Asignaturas> getAsignatura() {
            return Asignatura;
        }

        public void setAsignatura(ArrayList<Asignaturas> Asignatura) {
            this.Asignatura = Asignatura;
        }

    @Override
        public String toString() {
            return "Asignaturas{" + "Cod_Asig=" + Cod_Asig + ", Nombre_Asig=" + Nombre_Asig + '}';
        }
                    

        public ArrayList<Asignaturas> pedirDatosAsig() throws SQLException{
            this.conectar();
            String seleccion = "SELECT * FROM ASIGNATURAS ";
            try{
                Statement stmt = conex.createStatement();   
                ResultSet rs = stmt.executeQuery(seleccion);

                while(rs.next()) {
                    Asignaturas asig = new Asignaturas();
                    asig.setCod_Asig(rs.getString("cod_asig"));
                    asig.setNombre_Asig(rs.getString("Nombre_Asig"));


                    this.getAsignatura().add(asig);
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

            return Asignatura;
        }
        public ArrayList<Asignaturas> pedirAsignaturasDeUnAlumno(String NomAlum) throws SQLException{
            this.conectar();
            String seleccion = "SELECT * FROM ALUMNO, MATRICULA, ASIGNATURAS WHERE nombre ='" + NomAlum + "' AND ALUMNO.DNI = matricula.DNI AND matricula.cod_asig = ASIGNATURAS.cod_asig; ";
            try{
                Statement stmt = conex.createStatement();   
                ResultSet rs = stmt.executeQuery(seleccion);

                while(rs.next()) {
                    Asignaturas asig = new Asignaturas();
                    asig.setCod_Asig(rs.getString("cod_asig"));
                    asig.setNombre_Asig(rs.getString("Nombre_Asig"));


                    this.getAsignatura().add(asig);
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

            return Asignatura;
        }
}
