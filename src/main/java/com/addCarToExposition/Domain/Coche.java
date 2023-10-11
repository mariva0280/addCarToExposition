package com.addCarToExposition.Domain;

import com.addCarToExposition.Controller.CarOutput;
import com.addCarToExposition.Controller.InvalidCarFieldException;

public class Coche {
    private String matricula;
    private String modelo;
    private String marca;
    private int anyo;

    public Coche(String matricula, String modelo, String marca, int anyo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.anyo = anyo;
    }


    public String getMatricula() {
        return matricula;
    }
    public static CarOutput getCarOutput(Coche coche) throws InvalidCarFieldException {
        return new CarOutput(coche.getMatricula(), coche.getModelo(),coche.getMarca(),coche.getAnyo());
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
}
