package com.conversorDeMonedas.modelos;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class Moneda {
    @SerializedName("amount")
    private double cantidad;
    @SerializedName("base")
    private String primerPais;
    @SerializedName("rates")
    private Map<String, Double> tasas;

    public String getPrimerPais() { return primerPais; }
    public Map<String, Double> getTasas() { return tasas; }
    public double getCantidad() { return cantidad; }
    public void setPrimerPais(String primerPais) { this.primerPais = primerPais; }
    public void setTasas(Map<String, Double> tasas) { this.tasas = tasas; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
}