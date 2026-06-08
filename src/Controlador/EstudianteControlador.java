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
    private MateriaDAO materiaDAO;
    private InscripcionDAO inscripcionDAO;

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
}
