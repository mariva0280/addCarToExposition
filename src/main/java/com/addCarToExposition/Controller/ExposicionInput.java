package com.addCarToExposition.Controller;

public class ExposicionInput {
    private String nombre;
    private int codExpo;

    public ExposicionInput(String nombre, int codExpo) throws InvalidExpositionFieldException{
        if(nombre == null) throw new InvalidExpositionFieldException("The exposition name cannot be null");
        if(nombre.trim().isEmpty()) throw new InvalidExpositionFieldException("The exposition name cannot be empty");
        if(nombre.trim().length() < 1) throw new InvalidExpositionFieldException("The exposition name cannot have less than 1 of length");
        this.nombre = nombre;


        if(codExpo < 1 || codExpo > 999) throw new InvalidExpositionFieldException("The exposition code cannot be null");
        this.codExpo = codExpo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodExpo() {
        return codExpo;
    }
}
