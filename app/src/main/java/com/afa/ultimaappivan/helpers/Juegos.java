package com.afa.ultimaappivan.helpers;

import java.io.Serializable;

public class Juegos implements Serializable {
    private String nombre;
    private int icono;

    public Juegos(String nombre, int icono) {
        this.nombre = nombre;
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "Juegos{" +
                "nombre='" + nombre + '\'' +
                ", icono=" + icono +
                '}';
    }
}
