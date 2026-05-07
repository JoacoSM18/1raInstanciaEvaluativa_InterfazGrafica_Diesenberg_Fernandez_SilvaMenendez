/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primeraie_martinadiesenberg_joaquinsilvam_bautistafernandez;

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

        System.out.print("Nombre: ");
        m.setNombre(sc.nextLine());

        System.out.print("Codigo: ");
        m.setCodigo(sc.nextLine());

        System.out.print("Cuatrimestre (1 o 2): ");
        m.setCuatrimestre(sc.nextInt());

        System.out.print("Año: ");
        m.setAnio(sc.nextInt());
        sc.nextLine();

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

