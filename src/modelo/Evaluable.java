/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author Martina Diesenberg
 */
public interface Evaluable {
    String getCondicion();
    double getPromedio();
    boolean estaAprobada();

    default void mostrarEstadoAcademico(){
        System.out.println("Condicion: " + getCondicion());
        System.out.println("Promedio: " + getPromedio()); 
    }
}
