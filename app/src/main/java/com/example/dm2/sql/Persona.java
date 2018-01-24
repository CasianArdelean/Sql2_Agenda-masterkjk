package com.example.dm2.sql;

/**
 * Created by dm2 on 17/01/2018.
 */

public class Persona {
    String nombre, apellido, telefono;

    public Persona(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.apellido = apellido;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
