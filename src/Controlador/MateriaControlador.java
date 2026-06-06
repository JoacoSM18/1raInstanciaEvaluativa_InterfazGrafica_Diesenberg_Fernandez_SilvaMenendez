/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.MateriaDAO;
import modelo.Materia;
import java.util.ArrayList;

/**
 *
 * @author Martina Diesenberg
 */
public class MateriaControlador {
    private MateriaDAO dao;

    public MateriaControlador() {
        dao = new MateriaDAO();
    }

    public void agregarMateria(String nombre, String codigo,
                               int cuatrimestre, int anio) {

        Materia m = new Materia();

        m.setNombre(nombre);
        m.setCodigo(codigo);
        m.setCuatrimestre(cuatrimestre);
        m.setAnio(anio);

        dao.guardar(m);
    }
    
    public ArrayList<Materia> listarMaterias() {
        return dao.listar();
    }

    public Materia buscarMateria(String codigo) {
        return dao.buscar(codigo);
    }

    public boolean eliminarMateria(String codigo) {
        return dao.eliminar(codigo);
    }
}
