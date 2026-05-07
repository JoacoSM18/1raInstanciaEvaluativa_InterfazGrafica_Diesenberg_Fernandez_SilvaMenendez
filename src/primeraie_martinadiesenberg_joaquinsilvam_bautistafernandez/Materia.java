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
public class Materia implements Consultable, Evaluable {
    //3 Clase Materia
    
    String nombre;
    String codigo;
    int cuatrimestre;
    int anio;
    
    static ArrayList<String> codigos = new ArrayList<>();

    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
    
    public void setCodigo(String codigo) {
        if (codigo.length() < 3 || codigo.length() > 10){
            System.out.println("Error: el codigo debe tener entre 3 y 10 caracteres");
            return;
        }

        if (codigos.contains(codigo)) {
            System.out.println("Error: codigo repetido");
        } else {
            this.codigo = codigo;
            codigos.add(codigo);
        }
    }
    
    public void setCuatrimestre(int cuatrimestre) {
        if (cuatrimestre == 1 || cuatrimestre == 2){
            this.cuatrimestre = cuatrimestre;
        } else {
            System.out.println("Error, el cuatrimestre debe ser 1 o 2");
        } 
    }
    
    
    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Materia: " + nombre);
        System.out.println("Codigo: " + codigo);
        System.out.println("Cuatrimestre: " + cuatrimestre);
        System.out.println("Anio: " + anio);
    }
    
    @Override
    public String getCondicion() {
        return "Regular"; // podés cambiarlo después
    }

    @Override
    public double getPromedio() {
        return 0; // placeholder por ahora
    }
    
    public String getCodigo() {
    return this.codigo;
}

    @Override
    public boolean estaAprobada() {
        return getPromedio() >= 6;
    }
}
      

