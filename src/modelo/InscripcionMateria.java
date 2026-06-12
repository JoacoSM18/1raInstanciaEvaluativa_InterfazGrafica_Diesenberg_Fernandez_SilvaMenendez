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
    private int clasesRegistradas;
    private ArrayList<Double> notas;

    public InscripcionMateria(Materia materia, int totalClases) {
        this.materia = materia;
        this.totalClases = totalClases;
        this.clasesAsistidas = 0;
        this.clasesRegistradas = 0;
        this.notas = new ArrayList<>();
    }

    public void registrarAsistencia(boolean presente) {
        this.clasesRegistradas++;
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
    if (this.clasesRegistradas == 0) {
        return 0;
    }
    return ((double) this.clasesAsistidas / this.clasesRegistradas) * 100;
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
    
    public void setClasesAsistidas(int clasesAsistidas) {
        this.clasesAsistidas = clasesAsistidas;
    }
    public int getClasesRegistradas() { return clasesRegistradas; }

    public void setClasesRegistradas(int clasesRegistradas) {
        this.clasesRegistradas = clasesRegistradas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }
    
   public String toTexto() {
        String notasTexto = "";
        for (int i = 0; i < notas.size(); i++) {
            notasTexto += notas.get(i);
            if (i < notas.size() - 1) {
                notasTexto += ",";
            }
        }
        return materia.getCodigo() + "|" + totalClases + "|" + clasesAsistidas + "|" + clasesRegistradas + "|" + notasTexto;
    }
    public int getClasesAsistidas() {
        return clasesAsistidas;
    }

    public int getTotalClases() {
        return totalClases;
    }

    public static InscripcionMateria fromTexto(String linea, Materia materia) {
        String[] partes = linea.split("\\|");
        int totalClases = Integer.parseInt(partes[1]);
        InscripcionMateria im = new InscripcionMateria(materia, totalClases);
        im.setClasesAsistidas(Integer.parseInt(partes[2]));
        im.setClasesRegistradas(Integer.parseInt(partes[3]));
        ArrayList<Double> notasArr = new ArrayList<>();
        if (partes.length > 4 && !partes[4].isEmpty()) {
            for (String n : partes[4].split(",")) {
                notasArr.add(Double.parseDouble(n));
            }
        }
        im.setNotas(notasArr);
        return im;
    }
}

