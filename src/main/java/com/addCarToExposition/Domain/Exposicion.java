package com.addCarToExposition.Domain;

import com.addCarToExposition.Controller.CarInput;

import java.util.HashMap;
import java.util.Map;

public class Exposicion {
    private int codExpo;
    private String nombre;
    private String localidad;
    private Map<Integer, CarInput> cochesExpo;

    public Exposicion(int codExpo, String nombre, String localidad, Map<Integer, CarInput> cochesExpo) {
        this.codExpo = codExpo;
        this.nombre = nombre;
        this.localidad = localidad;
        this.cochesExpo = cochesExpo;
    }

    public Exposicion(int codExpo, String nombre) {
        this.codExpo = codExpo;
        this.nombre = nombre;
        this.cochesExpo = new HashMap<>();
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Map<Integer, CarInput> getCoches() {
        return cochesExpo;
    }

    public void setCochesExpo(Map<Integer, CarInput> cochesExpo) {
        this.cochesExpo = cochesExpo;
    }
    public void addCocheExpo(int cocheId, CarInput carInput) {
        cochesExpo.put(cocheId, carInput);
    }
}
