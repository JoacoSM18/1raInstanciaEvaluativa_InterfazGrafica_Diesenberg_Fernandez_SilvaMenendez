package primeraie_martinadiesenberg_joaquinsilvam_bautistafernandez;

import java.util.ArrayList;

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
        if (presente == true) {
            this.clasesAsistidas++; 
        }
        
        double porcentaje = this.getPorcentajeAsistencia();
        System.out.println("Asistencia actualizada: " + porcentaje + "%");
        
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
        if (this.getPorcentajeAsistencia() >= 75) {
            return "Regular";
        } else {
            return "Libre";
        }
    }

    @Override
    public double getPromedio() {
        if (this.notas.size() == 0) {
            return 0;
        }
        
        double suma = 0;
        for (double n : this.notas) {
            suma = suma + n;
        }
        return suma / this.notas.size();
    }

    @Override
    public boolean estaAprobada() {
        if (this.getPromedio() >= 6 && this.getCondicion().equals("Regular")) {
            return true;
        } else {
            return false;
        }
    }

    public Materia getMateria() {
        return this.materia;
    }
}