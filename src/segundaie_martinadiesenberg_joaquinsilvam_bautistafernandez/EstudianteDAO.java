/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundaie_martinadiesenberg_joaquinsilvam_bautistafernandez;

import segundaie_martinadiesenberg_joaquinsilvam_bautistafernandez.Materia;
import java.util.ArrayList;
/**
 *
 * @author Martina Diesenberg
 */
public class EstudianteDAO {
    private ArrayList<Estudiante> estudiantes;

    public EstudianteDAO() {
        estudiantes = new ArrayList<>();
    }

    public void guardar(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public ArrayList<Estudiante> listar() {
        return estudiantes;
    }
}
