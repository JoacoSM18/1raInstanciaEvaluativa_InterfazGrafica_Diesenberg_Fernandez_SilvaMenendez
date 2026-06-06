/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Martina Diesenberg
 */
public abstract class PersonaAcademica {
    String nombre;
    String legajo;
    public PersonaAcademica (String Nombre, String Legajo){
        this.nombre = Nombre;
        this.legajo = Legajo;
    }
    abstract void mostrarResumen();
    public String getNombre (){
        if (nombre.equals("")){
            System.out.print("Nombre Invalido, Por Favor Vuelva a Escribirlo");
        }
        return nombre;
    }
    public String getLegajo (){
        if (legajo == null){
            System.out.print("Legajo Invalido, Por Favor Vuelva a Escribirlo");
        }
        return legajo;
    }
}
