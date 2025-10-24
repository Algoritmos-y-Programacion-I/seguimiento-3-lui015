package model;

import java.util.ArrayList;
import java.util.List;

public class SchoolController {

    private Computer[][] computers;
    private List<String> registeredSerials;
    private List<Incidente> incidentes;

    public SchoolController() {
        computers = new Computer[5][5]; // 5 pisos con 5 computadores cada uno
        registeredSerials = new ArrayList<>();
        incidentes = new ArrayList<>();
    }

    // RF1: Agrega un computador a un piso de la escuela.
    public boolean addComputer(String serial, int floor) {

        if (registeredSerials.contains(serial)) {
            return false; // Serial repetido
        }

        for (int col = 0; col < 10; col++) {
            if (computers[floor][col] == null) {
                computers[floor][col] = new Computer(serial, floor, col);
                registeredSerials.add(serial);
                return true;
            }
        }
        return false; // Piso lleno
    }

    // RF2: Registra un incidente en un computador.
    public boolean reportIncident(String serial, String description) {
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] != null && computers[i][j].getSerial().equals(serial)) {
                    incidentes.add(new Incidente(description));
                    return true;
                }
            }
        }
        return false; // No se encontro el computador
    }

    // Metodo para listar incidentes registrados
    public void listIncidents() {
        if (incidentes.isEmpty()) {
            System.out.println("No hay incidentes registrados.");
        } else {
            System.out.println("Lista de incidentes:");
            for (Incidente inc : incidentes) {
                System.out.println("- " + inc.getDescription());
            }
        }
    }
}
