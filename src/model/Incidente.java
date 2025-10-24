package model;

import java.time.LocalDateTime;

public class Incident {
    private String descripcion;
    private LocalDateTime fecha;

    public Incident(String descripcion) {
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Incidente: " + descripcion + " | Fecha: " + fecha;
    }
}
