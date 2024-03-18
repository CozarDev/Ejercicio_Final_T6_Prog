package com.example.ejercicio_final_t6_prog;

public class Lugar {
    private String nombre;
    private String descripcion;

    public Lugar(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
