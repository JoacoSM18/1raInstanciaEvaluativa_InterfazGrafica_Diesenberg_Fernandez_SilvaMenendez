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
    private ArrayList<Materia> materias;
    
    public MateriaControlador() {
        dao = new MateriaDAO();
        materias = dao.leerTodas();
    }

    public void agregarMateria(String nombre, String codigo, int cuatrimestre, int anio) {
        Materia m = new Materia();
        m.setNombre(nombre);
        m.setCodigo(codigo);
        m.setCuatrimestre(cuatrimestre);
        m.setAnio(anio);
        materias.add(m);
        dao.guardarTodas(materias);
    }

    public ArrayList<Materia> listarMaterias() {
        return materias;
    }

    public Materia buscarMateria(String codigo) {
        return dao.buscar(codigo);
    }

    public boolean eliminarMateria(String codigo) {
        return dao.eliminar(codigo);
    }
}
