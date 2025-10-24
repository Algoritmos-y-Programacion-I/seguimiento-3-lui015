package model;

import java.util.ArrayList;

public class Computador {
    private String serial;
    private int piso;
    private int columna;
    private ArrayList<Incidente> incidentes;

    public  Computador(String serial, int piso, int columna) {
        this.serial = serial;
        this.piso = piso;
        this.columna = columna;
        this.incidentes = new ArrayList<>();
    }

    public String getSerial() {
        return serial;
    }

    public int getPiso() {
        return piso;
    }

    public int getColumna() {
        return columna;
    }

    public ArrayList<Incidente> getIncidentes() {
        return incidentes;
    }

    public void agregarIncidente(String descripcion) {
        incidentes.add(new Incidente(descripcion));
    }

    public int cantidadIncidentes() {
        return incidentes.size();
    }

    @Override
    public String toString() {
        return "Serial: " + serial + " (Piso " + piso + ", Columna " + columna + ")";
    }

}
