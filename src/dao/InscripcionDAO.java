/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.*;
import modelo.Materia;
import java.util.ArrayList;
import modelo.InscripcionMateria;
/**
 *
 * @author Martina Diesenberg
 */
public class InscripcionDAO {
    private String archivo = "inscripciones.txt";
    public ArrayList<InscripcionMateria> leerTodas(ArrayList<Materia> materias) {
        ArrayList<InscripcionMateria> inscripciones = new ArrayList<>();
        File f = new File(archivo);
        if (!f.exists()) return inscripciones;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    String codigoMateria = linea.split("\\|")[0];
                    Materia materia = buscarMateria(codigoMateria, materias);
                    if (materia != null) {
                        inscripciones.add(InscripcionMateria.fromTexto(linea, materia));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo inscripciones: " + e.getMessage());
        }
        return inscripciones;
    }

    public void guardarTodas(ArrayList<InscripcionMateria> inscripciones) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (InscripcionMateria im : inscripciones) {
                pw.println(im.toTexto());
            }
        } catch (IOException e) {
            System.out.println("Error guardando inscripciones: " + e.getMessage());
        }
    }

    public boolean eliminar(String codigoMateria, ArrayList<InscripcionMateria> inscripciones) {
        for (InscripcionMateria im : inscripciones) {
            if (im.getMateria().getCodigo().equalsIgnoreCase(codigoMateria)) {
                inscripciones.remove(im);
                guardarTodas(inscripciones);
                return true;
            }
        }
        return false;
    }

    private Materia buscarMateria(String codigo, ArrayList<Materia> materias) {
        for (Materia m : materias) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }
}

