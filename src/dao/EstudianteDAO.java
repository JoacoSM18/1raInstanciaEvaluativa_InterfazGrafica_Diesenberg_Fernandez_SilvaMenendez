/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.*;
import modelo.Estudiante;
import modelo.Materia;
import modelo.InscripcionMateria;
/**
 *
 * @author Martina Diesenberg
 */
public class EstudianteDAO {

    private String archivo = "estudiante.txt";

    public void guardar(Estudiante estudiante) {
        Materia.limpiarCodigos();
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println(estudiante.toTexto());
            System.out.println("Guardando " + estudiante.getMaterias().size() + " materias");
            for (InscripcionMateria im : estudiante.getMaterias()) {
                System.out.println("Guardando: " + im.getMateria().getNombre() + " - " + im.getMateria().getCodigo());
                pw.println(im.toTexto());
            }
        } catch (IOException e) {
            System.out.println("Error guardando estudiante: " + e.getMessage());
        }
    }

    public Estudiante leer() {
        File f = new File(archivo);
        if (!f.exists()) return null;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea = br.readLine();
            if (linea != null && !linea.isEmpty()) {
                return Estudiante.fromTexto(linea);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo estudiante: " + e.getMessage());
        }
        return null;
    }
}
