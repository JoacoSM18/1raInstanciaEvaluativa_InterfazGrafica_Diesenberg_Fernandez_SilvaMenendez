/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primeraie_martinadiesenberg_joaquinsilvam_bautistafernandez;
import java.util.ArrayList;

/**
 *
 * @author joako
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
    public void Inscribirse(Materia m,int totalClases) {
        InscripcionMateria nueva = new InscripcionMateria(m, totalClases);
        materias.add(nueva);
    }

    public void darDeBaja(String codigoMateria) {
        for (int i = 0; i < materias.size(); i++) {
            if (materias.get(i).getMateria().getCodigo().equals(codigoMateria)) {
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
        double suma = 0;
        for (InscripcionMateria im : materias) {
            suma += im.getPromedio();
        }
        if (materias.size() == 0) {
            return 0;
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
}

