package com.example.conversor;

import java.math.BigDecimal;

public class Moneda {
    private String pais;
    private String codigo;
    private BigDecimal tipoCambio;

    public Moneda(String nombre, String codigo, BigDecimal tipoCambio) {
        this.pais = nombre;
        this.codigo = codigo;
        this.tipoCambio = tipoCambio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    @Override
    public String toString() {
        return pais;
    }
// Resto del código de la clase Moneda
}


