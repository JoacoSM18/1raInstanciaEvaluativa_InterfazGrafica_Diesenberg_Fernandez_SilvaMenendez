/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.*;
import java.util.ArrayList;
import modelo.Materia;
/**
 *
 * @author Martina Diesenberg
 */
public class MateriaDAO {
    private String archivo = "materias.txt";
    public ArrayList<Materia> leerTodas() {
        ArrayList<Materia> materias = new ArrayList<>();
        File f = new File(archivo);
        if (!f.exists()) return materias;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    materias.add(Materia.fromTexto(linea));
                }
            }
        }catch (IOException e) {
            System.out.println("Error leyendo materias: " + e.getMessage());
        }
        return materias;
    }

    
    public void guardarTodas(ArrayList<Materia> materias) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Materia m : materias) {
                pw.println(m.toTexto());
            }
        } catch (IOException e) {
            System.out.println("Error Guardando Materias: " + e.getMessage());
        }
    }

    public Materia buscar(String codigo) {
        for (Materia m : leerTodas()) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }

    public boolean eliminar(String codigo) {
        ArrayList<Materia> materias = leerTodas();
        for (Materia m : materias) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                materias.remove(m);
                guardarTodas(materias);
                return true;
            }
        }
        return false;
    }
}
