/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jaime
 */
public class Modelo {
        public Connection conex;
        private String url;
        private String username;
        private String password;

    public Modelo() {
        this.conex = null;
        this.url = null;
        this.username = null;
        this.password = null;

    }

    public Connection getConex() {
        return conex;
    }

    public void setConex(Connection conex) {
        this.conex = conex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
        
        public Connection conectar () throws SQLException {
            setUrl ("jdbc:mysql://localhost:3306/alumno?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            setUsername ("root");
            setPassword("jaime1998");
            try{
                setConex(DriverManager.getConnection(getUrl(),getUsername(),getPassword()));
                System.out.println("Conectado a la base de datos");
            }
            catch(SQLException e){
                System.out.println("Fallo1!");
                e.printStackTrace();
            }
            
            return getConex();
        }
        public Connection cortarConexion(){
            try{
                conex.close();
                setConex(conex);
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            return getConex();
        }
}
