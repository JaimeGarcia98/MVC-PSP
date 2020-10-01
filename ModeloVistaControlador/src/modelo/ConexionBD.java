/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jaime
 */


public class ConexionBD {

    private Connection conex;
    private String url = "jdbc:mysql://localhost:3306/alumno?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "jaime1998";
    
    public void conectar () throws SQLException {
        try{
            conex = DriverManager.getConnection(url,username,password);
            System.out.println("Conectado a la base de datos");
        }
        catch(SQLException e){
            System.out.println("Fallo1!");
            e.printStackTrace();
        }
        
    }
}
   
