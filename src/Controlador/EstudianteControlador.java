/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import dao.EstudianteDAO;
import dao.InscripcionDAO;
import dao.MateriaDAO;
import modelo.Estudiante;
import modelo.InscripcionMateria;
import modelo.Materia;
import java.util.ArrayList;
/**
 *
 * @author joako
 */
public class EstudianteControlador {
    private Estudiante estudiante;
    private ArrayList<Materia> materias;
    private ArrayList<InscripcionMateria> inscripciones;
    private EstudianteDAO estudianteDAO;
    public MateriaDAO materiaDAO;
    public InscripcionDAO inscripcionDAO;
    public EstudianteControlador(Estudiante estudiante) {
        this.estudianteDAO = new EstudianteDAO();
        this.materiaDAO = new MateriaDAO();
        this.inscripcionDAO = new InscripcionDAO();
        this.estudiante = estudiante;
        this.materias = materiaDAO.leerTodas();
        this.inscripciones = inscripcionDAO.leerTodas(materias);
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public ArrayList<InscripcionMateria> getInscripciones() {
        return inscripciones;
    }
    public void inscribirMateria(String nombre, String codigo, int cuatrimestre, int anio, int totalClases) {
        Materia m = new Materia();
        m.setNombre(nombre);
        m.setCodigo(codigo);
        m.setCuatrimestre(cuatrimestre);
        m.setAnio(anio);
        materias.add(m);
        materiaDAO.guardarTodas(materias);
        InscripcionMateria im = new InscripcionMateria(m, totalClases);
        inscripciones.add(im);
        inscripcionDAO.guardarTodas(inscripciones);
    }
    public boolean darDeBaja(String codigo) {
        materias.removeIf(m -> m.getCodigo().equalsIgnoreCase(codigo));
        materiaDAO.guardarTodas(materias);
        boolean eliminado = inscripciones.removeIf(im -> im.getMateria().getCodigo().equalsIgnoreCase(codigo));
        inscripcionDAO.guardarTodas(inscripciones);
        return eliminado;
    }
    public boolean registrarAsistencia(String codigo, boolean presente) {
        for (InscripcionMateria im : inscripciones) {
            if (im.getMateria().getCodigo().equalsIgnoreCase(codigo)) {
                im.registrarAsistencia(presente);
                inscripcionDAO.guardarTodas(inscripciones);
                return true;
            }
        }
        return false;
    }
    public boolean registrarNota(String codigo, double nota) {
        for (InscripcionMateria im : inscripciones) {
            if (im.getMateria().getCodigo().equalsIgnoreCase(codigo)) {
                im.agregarNota(nota);
                inscripcionDAO.guardarTodas(inscripciones);
                return true;
            }
        }
        return false;
    }
    public ArrayList<InscripcionMateria> getAlertas() {
        ArrayList<InscripcionMateria> alertas = new ArrayList<>();
        for (InscripcionMateria im : inscripciones) {
            double asistencia = im.getPorcentajeAsistencia();
            if (asistencia >= 75 && asistencia <= 85) {
                alertas.add(im);
            }
        }
        return alertas;
    }
    public String getReporteSituacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante: ").append(estudiante.getNombre()).append("\n");
        sb.append("Carrera: ").append(estudiante.getCarrera()).append("\n");
        sb.append("Promedio general: ").append(estudiante.getPromedioGeneral()).append("\n");
        sb.append("Materias inscriptas: ").append(inscripciones.size()).append("\n");
        return sb.toString();
    }

    public ArrayList<InscripcionMateria> getMateriasEnRiesgoOrdenadas() {
        ArrayList<InscripcionMateria> riesgo = new ArrayList<>();
        for (InscripcionMateria im : inscripciones) {
            double asistencia = im.getPorcentajeAsistencia();
            if (asistencia >= 75 && asistencia <= 85) {
                riesgo.add(im);
            }
        }
        riesgo.sort((a, b) -> Double.compare(
            a.getPorcentajeAsistencia(),
            b.getPorcentajeAsistencia()
        ));
        return riesgo;
    }


    public double[] getEstadisticasAprobadas() {
        ArrayList<Double> promedios = new ArrayList<>();
        for (InscripcionMateria im : inscripciones) {
            if (im.estaAprobada()) {
                promedios.add(im.getPromedio());
            }
        }
        if (promedios.isEmpty()) return new double[]{0, 0, 0};
        double max = promedios.get(0);
        double min = promedios.get(0);
        double suma = 0;
        for (double p : promedios) {
            if (p > max) max = p;
            if (p < min) min = p;
            suma += p;
        }
        return new double[]{max, min, suma / promedios.size()};
    }

    public int buscarMateria(String texto) {
        String textoBusqueda = texto.toLowerCase();
        for (int i = 0; i < inscripciones.size(); i++) {
            InscripcionMateria im = inscripciones.get(i);
            String nombre = im.getMateria().getNombre().toLowerCase();
            String codigo = im.getMateria().getCodigo().toLowerCase();
            if (nombre.contains(textoBusqueda) || codigo.contains(textoBusqueda)) {
                return i;
            }
        }
        return -1;
    }
}