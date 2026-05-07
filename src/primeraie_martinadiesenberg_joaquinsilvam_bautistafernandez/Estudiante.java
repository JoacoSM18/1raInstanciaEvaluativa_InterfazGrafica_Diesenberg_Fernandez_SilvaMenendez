/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primeraie_martinadiesenberg_joaquinsilvam_bautistafernandez;
import java.util.ArrayList;

/**
 *
 * @author Martina Diesenberg
 */
public class Estudiante extends PersonaAcademica {
    String carrera;
    int anioIngreso;
    ArrayList <InscripcionMateria> materias;
   
    public Estudiante (String nombre, String legajo, String carrera, int anioIngreso){
        super(nombre,legajo);
        this.carrera = carrera;
        this.anioIngreso = anioIngreso;
        this.materias = new ArrayList<>();
    }
    @Override
    public void MostrarResumen() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Legajo: " + getLegajo());
        System.out.println("Carrera: " + carrera);
        System.out.println("Año de ingreso: " + anioIngreso);
    }
    public void Inscribirse (){
   
    }
    public void DardeBaja (){
   
    }
    public void getInscripcion (){
   
    }
    public void getPromedioGeneral (){
   
    }
    public void getMateriasCriticas (){
       
    }
}

