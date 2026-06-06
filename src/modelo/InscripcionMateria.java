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
public class InscripcionMateria implements Evaluable {
    
    private Materia materia;
    private int totalClases;
    private int clasesAsistidas;
    private ArrayList<Double> notas;

    public InscripcionMateria(Materia materia, int totalClases) {
        this.materia = materia;
        this.totalClases = totalClases;
        this.clasesAsistidas = 0;
        this.notas = new ArrayList<>();
    }

    public void registrarAsistencia(boolean presente) {
        if (presente) {
            this.clasesAsistidas++;
        }

        double porcentaje = this.getPorcentajeAsistencia();

        if (porcentaje < 75) {
            System.out.println("Perdiste la regularidad.");
        } else if (porcentaje < 80) {
            System.out.println("Asistencia en zona de riesgo.");
        }
    }

    public double getPorcentajeAsistencia() {
        if (this.totalClases == 0) {
            return 0;
        }
        return ((double) this.clasesAsistidas / this.totalClases) * 100;
    }

    public void agregarNota(double nota) {
        if (this.notas.size() >= 5) {
            System.out.println("Error: No se pueden cargar mas de 5 notas.");
            return;
        }

        if (nota >= 0 && nota <= 10) {
            this.notas.add(nota);
        } else {
            System.out.println("Error: La nota ingresada no es valida.");
        }
    }

    @Override
    public String getCondicion() {
        return getPorcentajeAsistencia() >= 75 ? "Regular" : "Libre";
    }

    @Override
    public double getPromedio() {
        if (notas.isEmpty()) {
            return 0;
        }

        double suma = 0;
        for (double n : notas) {
            suma += n;
        }

        return suma / notas.size();
    }

    @Override
    public boolean estaAprobada() {
        return getPromedio() >= 6 && getCondicion().equals("Regular");
    }

    public Materia getMateria() {
        return materia;
    }
   
}

