package controller;

import java.util.ArrayList;
import model.Computador;
import model.Edificio;

/**
 * Controlador principal del sistema.
 * Gestiona la creación, registro de incidentes y consultas sobre los computadores.
 */
public class Controller {
    private Edificio edificio;
    private ArrayList<String> serialesRegistrados;

    public Controller() {
        edificio = new Edificio(5, 10);
        serialesRegistrados = new ArrayList<>();
    }

    /**
     * RF1: Agrega un computador al edificio.
     * @param serial Número serial único del computador.
     * @param piso Piso donde se ubica (0-4).
     * @return true si fue agregado correctamente, false si el serial existe o no hay espacio.
     * @pre El número serial no debe existir previamente.
     * @post El computador queda registrado en la primera columna disponible del piso indicado.
     */
    public boolean agregarComputador(String serial, int piso) {
        if (serialesRegistrados.contains(serial)) {
            return false;
        }

        for (int col = 0; col < 10; col++) {
            if (edificio.getComputadores()[piso][col] == null) {
                Computador nuevo = new Computador(serial, piso, col);
                edificio.getComputadores()[piso][col] = nuevo;
                serialesRegistrados.add(serial);
                return true;
            }
        }
        return false;
    }

    /**
     * RF2: Registra un incidente para un computador específico.
     * @param serial Número serial del computador.
     * @param descripcion Descripción del incidente.
     * @return true si el incidente fue registrado correctamente, false si no se encontró el computador.
     * @pre El computador con el número serial debe existir en el edificio.
     * @post El incidente queda agregado a la lista del computador correspondiente.
     */
    public boolean registrarIncidente(String serial, String descripcion) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Computador comp = edificio.getComputadores()[i][j];
                if (comp != null && comp.getSerial().equals(serial)) {
                    comp.agregarIncidente(descripcion);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * RF3: Consulta el computador con más incidentes.
     * @return Computador con más incidentes registrados, o null si no hay computadores.
     * @pre Debe haber al menos un computador registrado.
     * @post Retorna el computador con mayor cantidad de incidentes.
     */
    public Computador computadorConMasIncidentes() {
        Computador mayor = null;
        int max = -1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Computador c = edificio.getComputadores()[i][j];
                if (c != null && c.cantidadIncidentes() > max) {
                    max = c.cantidadIncidentes();
                    mayor = c;
                }
            }
        }
        return mayor;
    }

    public Edificio getEdificio() {
        return edificio;
    }
}
