/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import modelo.Matricula;
import modelo.Asignaturas;
import modelo.Alumno;
import java.sql.Connection;
import controlador.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author jaime
 */
public class Vista {

    public void ImprimirTablaAlumnos() throws SQLException{
        AlumnoControlador controlador_Alum = new AlumnoControlador();
        ArrayList<Alumno> Alumnos = new ArrayList<Alumno>();
        Alumnos = controlador_Alum.PedirDatosAlum();
        for(int i = 0; i < Alumnos.size() ; i++){
            System.out.println(Alumnos.get(i));
        }
    }
    
    public void ImprimirTablaAsig() throws SQLException{
        AsignaturasControlador controlador_Asig = new AsignaturasControlador();
        ArrayList<Asignaturas> Asigs = new ArrayList<Asignaturas>();
        Asigs = controlador_Asig.PedirDatosAsig();
        for (int i = 0; i < Asigs.size(); i++){
            System.out.println(Asigs.get(i));
        }
    }
    public void ImprimirTablaMatric() throws SQLException{
        ControladorMatricula controlador_matr = new ControladorMatricula();
        ArrayList<Matricula> matrics = new ArrayList<Matricula>();
        matrics = (controlador_matr.PedirDatosMatric());
        for (int i = 0; i < matrics.size(); i++){
            System.out.println(matrics.get(i));
        }
    }
    public void ImprimirAsigAlumno(String NomAlum) throws SQLException{
        AsignaturasControlador controlador_Asig = new AsignaturasControlador();
        ArrayList<Asignaturas> Asigs = new ArrayList<Asignaturas>();
        Asigs = controlador_Asig.PedirAsignaturasDeAlumno(NomAlum);
        for (int i = 0; i < Asigs.size(); i++){
            System.out.println(Asigs.get(i));
        }
    }
    public void DemostrarTeoriaArray() throws SQLException{
        AlumnoControlador controlador_Alum = new AlumnoControlador();
        ArrayList<Alumno> Alumnos = new ArrayList<Alumno>();
        ArrayList<Alumno> Alumnos2 = new ArrayList<Alumno>();
        
        Alumnos = controlador_Alum.DemostrarTeoriaArray();
        
        Alumnos.remove(1);
        System.out.println("Demostración Array en Vista");
        for (int i = 0; i < Alumnos.size(); i++){
            System.out.println(Alumnos);
        }
        Alumnos2 = controlador_Alum.DemostrarTeoriaArray();
    }
    public void menu() throws SQLException{
        Scanner sc = new Scanner(System.in);
        int opcion =0;
        boolean inter = false;
        while (inter == false){
            System.out.println("SELECCIONA UNA OPCIÓN");

            System.out.println("1.Mostrar Alumnos");

            System.out.println("2.Mostrar Asignaturas");

            System.out.println("3.Mostrar Asignaturas de un Alumno");
            
            System.out.println("4.Demostrar la teoría de los Arrays");
            
            System.out.println("5.Salir");

            opcion =  sc.nextInt();
            switch (opcion){

                case 1: 
                    System.out.println("Has seleccionado Mostrar Alumnos...");
                    ImprimirTablaAlumnos();

                break;

                case 2:
                    System.out.println("Has seleccionado Mostrar Asignaturas...");
                    ImprimirTablaAsig();
                break;

                case 3:
                    System.out.println("Has seleccionado Mostrar Asignaturas de un Alumno, introduce el nombre completo del alumno");
                    Scanner NomAlum = new Scanner(System.in);
                    String NombAlumno = NomAlum.nextLine();
                    ImprimirAsigAlumno(NombAlumno);

                break;
                
                case 4:
                     System.out.println("Has seleccionado Demostrar los Arrays...");
                     DemostrarTeoriaArray();
                break;
                
                case 5:
                    inter = true;
                 
                break;
                
                default:
                    System.out.println("Incorrecto!!");
                break;
            } 
        }
    }
    
}
