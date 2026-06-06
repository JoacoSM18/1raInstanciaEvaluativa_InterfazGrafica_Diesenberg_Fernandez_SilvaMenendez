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
public class MateriaDAO {
     private ArrayList<Materia> materias;

    public MateriaDAO() {
        materias = new ArrayList<>();
    }

    public void guardar(Materia materia) {
        materias.add(materia);
    }

    public ArrayList<Materia> listar() {
        return materias;
    }

    public Materia buscar(String busqueda) {

        for (Materia m : materias) {

            if (m.getCodigo().equalsIgnoreCase(busqueda)) {
                return m;
            }

        }
           return null;
    }
    public boolean eliminar(String codigo) {

        for (Materia m : materias) {

            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                materias.remove(m);
                return true;
            }

        }

        return false;
    }
}
