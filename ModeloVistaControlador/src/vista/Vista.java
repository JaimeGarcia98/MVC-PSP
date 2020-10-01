/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.Controlador.Alumno;
import controlador.Controlador.Asignaturas;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author jaime
 */
public class Vista {
    
    public void ImprimirTablaAlumnos(ArrayList<Alumno> alumnos){
        
        for(Alumno alum : alumnos){
            System.out.println("DNI: " + alum.getDni());
            System.out.println("NOMBRE: " + alum.getNombre());
            System.out.println("APELLIDOS: " + alum.getApellidos());
        }
    }
    
    public void menu(){
        System.out.println("SELECCIONA UNA OPCIÓN");

        System.out.println("1.Mostrar Alumnos");

        System.out.println("2.Mostrar Asignaturas");

        System.out.println("3.Mostrar Asignaturas de un Alumno");

        Scanner sc = new Scanner(System.in);

        int opcion = sc.nextInt();

        switch (opcion){

            case 1: 
                System.out.println("Has seleccionado Mostrar Alumnos...");
                ArrayList<Alumno> ListaAlums = null;
                this.ImprimirTablaAlumnos(ListaAlums);
                
            break;


            case 2:
                System.out.println("Has seleccionado Mostrar Asignaturas...");
            break;

            case 3:
                System.out.println("");
            break;

            default:
                System.out.println("Incorrecto!!");
            break;
        } 
    }
    
}
