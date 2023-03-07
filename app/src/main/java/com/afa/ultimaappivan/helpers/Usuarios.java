package com.afa.ultimaappivan.helpers;

import java.io.Serializable;

public class Usuarios implements Serializable {
    private String nombre;
    private String dni;
    private String password;

    public Usuarios(String nombre, String dni, String password) {
        this.nombre = nombre;
        this.dni = dni;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
