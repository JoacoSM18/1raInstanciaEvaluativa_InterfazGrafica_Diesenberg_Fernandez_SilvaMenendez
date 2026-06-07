/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import modelo.InscripcionMateria;
/**
 *
 * @author Martina Diesenberg
 */
public class InscripcionDAO {
    private ArrayList<InscripcionMateria> inscripciones;

    public InscripcionDAO() {
        inscripciones = new ArrayList<>();
    }

    public void guardar(InscripcionMateria inscripcion) {
        inscripciones.add(inscripcion);
    }

    public ArrayList<InscripcionMateria> listar() {
        return inscripciones;
    }

    public InscripcionMateria buscar(String codigoMateria) {

        for (InscripcionMateria i : inscripciones) {

            if (i.getMateria().getCodigo().equalsIgnoreCase(codigoMateria)) {
                return i;
            }

        }
        return null;
    }

    public boolean eliminar(String codigoMateria) {

        for (InscripcionMateria i : inscripciones) {

            if (i.getMateria().getCodigo().equalsIgnoreCase(codigoMateria)) {
                inscripciones.remove(i);
                return true;
            }

        }

        return false;
    }
}

