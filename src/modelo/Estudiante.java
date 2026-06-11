/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;


/**
 *
 * @author Martina Diesenberg
 */
public class Estudiante extends PersonaAcademica {
     private String carrera;
    private int anioIngreso;
    private ArrayList <InscripcionMateria> materias;
   
    public Estudiante (String nombre, String legajo, String carrera, int anioIngreso){
        super(nombre,legajo);
        this.carrera = carrera;
        this.anioIngreso = anioIngreso;
        this.materias = new ArrayList<>();
    }
    
    @Override
    public void mostrarResumen() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Legajo: " + getLegajo());
        System.out.println("Carrera: " + carrera);
        System.out.println("Año de ingreso: " + anioIngreso);
    }
    public void inscribirse(Materia m, int totalClases) {
        InscripcionMateria nueva = new InscripcionMateria(m, totalClases);
        materias.add(nueva);
    }

    public void darDeBaja(String nombreMateria) {
        for (int i = 0; i < materias.size(); i++) {
        if (materias.get(i).getMateria().getNombre().equals(nombreMateria)) {
            materias.remove(i);
            break;
        }
    }
    }

    public InscripcionMateria getInscripcion(String codigoMateria) {
        for (int i = 0; i < materias.size(); i++) {
            InscripcionMateria inscripcion = materias.get(i);
            if (inscripcion.getMateria().getCodigo().equals(codigoMateria)) {
                return inscripcion;
            }
        }
        return null;
    }

    public double getPromedioGeneral() {
        if (materias.isEmpty()) return 0.0;
            double suma = 0;
            for (InscripcionMateria im : materias) {
                suma += im.getPromedio();
            }
            return suma / materias.size();
    }   
      

    public ArrayList<InscripcionMateria> getMateriasCriticas() {
        ArrayList<InscripcionMateria> criticas = new ArrayList<>();
        for (InscripcionMateria im : materias) {
            double asistencia = im.getPorcentajeAsistencia();
            if (asistencia >= 75 && asistencia <= 85) {
                criticas.add(im);
            }
        }
        return criticas;
    }
    
    public ArrayList<InscripcionMateria> getMaterias() {
        return materias;
    }
    
    public String getCarrera() {
        return carrera;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }
    
    public String toTexto() {
        return getNombre() + "|" + getLegajo() + "|" + carrera + "|" + anioIngreso;
    }

    public static Estudiante fromTexto(String linea) {
        String[] partes = linea.split("\\|");
        return new Estudiante(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]));
    }
}

