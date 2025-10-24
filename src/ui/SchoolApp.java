package ui;

import java.util.Scanner;
import controller.SchoolController;
import model.Computer;

/**
 * SchoolApp.java
 * Interfaz de usuario por consola para la escuela Computaricemos.
 * Permite registrar computadores, incidentes y consultar el computador con más incidentes.
 */
public class SchoolApp {

    // Relación con el controlador
    private SchoolController controller;
    private Scanner input;

    // Constructor
    public SchoolApp() {
        input = new Scanner(System.in);
        controller = new SchoolController(); // Se crea el controlador
    }

    public static void main(String[] args) {
        SchoolApp ui = new SchoolApp();
        ui.menu();
    }

    // Menú principal
    public void menu() {
        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("0) Salir del sistema");
            System.out.print("Seleccione una opción: ");
            option = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. ¡Adiós!");
                    break;
                default:
                    System.out.println("\n Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);
    }

    // ================== RF1: Registrar computador ==================
    public void registrarComputador() {
        System.out.println("\n--- Registrar Computador ---");
        System.out.print("Ingrese el número serial del computador: ");
        String serial = input.nextLine();
        System.out.print("Ingrese el piso donde se ubicará (0 a 4): ");
        int piso = input.nextInt();
        input.nextLine();

        boolean agregado = controller.addComputer(serial, piso);

        if (agregado) {
            System.out.println(" Computador registrado exitosamente.");
        } else {
            System.out.println(" No se pudo registrar (serial repetido o sin espacio en ese piso).");
        }
    }

    // ================== RF2: Registrar incidente ==================
    public void registrarIncidenteEnComputador() {
        System.out.println("\n--- Registrar Incidente ---");
        System.out.print("Ingrese el número serial del computador: ");
        String serial = input.nextLine();
        System.out.print("Ingrese la descripción del incidente: ");
        String descripcion = input.nextLine();

        boolean registrado = controller.reportIncident(serial, descripcion);

        if (registrado) {
            System.out.println(" Incidente registrado correctamente.");
        } else {
            System.out.println(" No se encontró un computador con ese número serial.");
        }
    }

    // ================== RF3: Consultar computador con más incidentes ==================
    public void consultarComputadorConMasIncidentes() {
        System.out.println("\n--- Consultar Computador con Más Incidentes ---");
        Computer comp = controller.getComputerWithMostIncidents();

        if (comp != null) {
            System.out.println(" Computador con más incidentes:");
            System.out.println("Serial: " + comp.getSerial());
            System.out.println("Piso: " + comp.getFloor());
            System.out.println("Columna: " + comp.getColumn());
            System.out.println("Cantidad de incidentes: " + comp.getIncidents().size());
        } else {
            System.out.println(" No hay computadores registrados aún.");
        }
    }
}
