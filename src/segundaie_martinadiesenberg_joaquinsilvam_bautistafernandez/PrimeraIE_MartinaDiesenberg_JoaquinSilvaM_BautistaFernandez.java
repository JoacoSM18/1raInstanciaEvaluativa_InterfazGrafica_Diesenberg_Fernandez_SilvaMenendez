/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package segundaie_martinadiesenberg_joaquinsilvam_bautistafernandez;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Martina Diesenberg
 */
public class PrimeraIE_MartinaDiesenberg_JoaquinSilvaM_BautistaFernandez {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Materia> materias = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Gestion de materias");
            System.out.println("2. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    menuMaterias();
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 2);
    }

    public static void menuMaterias() {
        int op;

        do {
            System.out.println("\n--- GESTION DE MATERIAS ---");
            System.out.println("1. Inscribirse");
            System.out.println("2. Darse de baja");
            System.out.println("3. Listar materias");
            System.out.println("4. Buscar materia");
            System.out.println("5. Volver");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    inscribirMateria();
                    break;
                case 2:
                    eliminarMateria();
                    break;
                case 3:
                    listarMaterias();
                    break;
                case 4:
                    buscarMateria();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (op != 5);
    }

    // ---------------- FUNCIONES ----------------

    public static void inscribirMateria() {
        Materia m = new Materia();
        String nombre;
        do {
            System.out.print("Nombre: ");
            nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío");
            }   
        } 
        while (nombre.isEmpty());
        m.setNombre(nombre);
        String codigo;
        do 
        {
            System.out.print("Codigo: ");
            codigo = sc.nextLine().trim();
            if (codigo.length() < 3 || codigo.length() > 10) {
                System.out.println("El codigo debe tener entre 3 y 10 caracteres");
                codigo = "";
            } else if (Materia.codigos.contains(codigo)) {
                System.out.println("Ese codigo ya existe, ingrese otro");
                codigo = "";
            }
        } 
        while (codigo.isEmpty());
        m.setCodigo(codigo);
        int cuatrimestre;
        do {
            System.out.print("Cuatrimestre (1 o 2): ");
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número válido");
                sc.nextLine();
            }
            cuatrimestre = sc.nextInt();
            if (cuatrimestre != 1 && cuatrimestre != 2) {
                System.out.println("El cuatrimestre debe ser 1 o 2");
            }
        } 
        while (cuatrimestre != 1 && cuatrimestre != 2);
            sc.nextLine();
            m.setCuatrimestre(cuatrimestre);
            int anio;
        do {
            System.out.print("Año: ");
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número válido");
                sc.nextLine();
            }
            anio = sc.nextInt();
            if (anio < 1 || anio > 5) {
                System.out.println("El año debe estar entre 1 y 5");
            }
        } 
        while (anio < 1 || anio > 5);
        sc.nextLine();
        m.setAnio(anio);
        materias.add(m);
        System.out.println("Materia agregada");
    }

    public static void eliminarMateria() {
        System.out.print("Ingrese codigo a eliminar: ");
        String cod = sc.nextLine();

        for (int i = 0; i < materias.size(); i++) {
            if (materias.get(i).codigo.equals(cod)) {
                materias.remove(i);
                System.out.println("Materia eliminada");
                return;
            }
        }

        System.out.println("No se encontro la materia");
    }

    public static void listarMaterias() {
        if (materias.isEmpty()) {
            System.out.println("No hay materias");
            return;
        }

        for (Materia m : materias) {
            System.out.println("-----------");
            m.mostrarResumen();
        }
    }

    public static void buscarMateria() {
        System.out.print("Ingrese codigo o nombre: ");
        String busqueda = sc.nextLine().toLowerCase();

        boolean encontrada = false;

        for (Materia m : materias) {
            if (m.codigo.toLowerCase().contains(busqueda) ||
                m.nombre.toLowerCase().contains(busqueda)) {

                m.mostrarResumen();
                System.out.println("-----------");
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontraron resultados");
        }
    }  
}

