package com.addCarToExposition.Controller;

public class ExposicionOutput {
    private int codExpo;
    private String nombre;
    public ExposicionOutput(int codExpo) {
        this.codExpo = codExpo;
        this.nombre = nombre;
    }
    public int getCodExpo() {
        return codExpo;
    }

    public void setCodExpo(int codExpo) {
        this.codExpo = codExpo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
