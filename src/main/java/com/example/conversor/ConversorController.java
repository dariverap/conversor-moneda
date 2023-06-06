package com.example.conversor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;

public class ConversorController {

    @FXML
    private ComboBox<Moneda> cbPaises;
    @FXML
    private ComboBox<Moneda> cbPaises2;

    @FXML
    private TextField txtMonto;

    @FXML
    private Button btnCalcular;

    @FXML
    private TextField txtResultado;
    public void initialize() {
        System.out.println("Initializing controller...");
         cbPaises.getItems().addAll(ListaMonedas());
         cbPaises2.getItems().addAll(ListaMonedas());

    }

    private ArrayList<Moneda> ListaMonedas(){

        ArrayList<Moneda> paises = new ArrayList<>();
        Moneda MonedaEEUU = new Moneda("Estados Unidos", "USD", BigDecimal.ONE);
        Moneda MonedaEspana = new Moneda("España", "EUR", new BigDecimal("0.83"));
        Moneda MonedaInglaterra = new Moneda("Inglaterra", "GBP", new BigDecimal("0.72"));
        Moneda MonedaJapon = new Moneda("Japón", "JPY", new BigDecimal("109.85"));
        Moneda MonedaCoreaSur = new Moneda("Corea del Sur", "KRW", new BigDecimal("1116.57"));
        Moneda MonedaPeru = new Moneda("Perú", "PEN", new BigDecimal("3.93"));

        paises.add(MonedaPeru);
        paises.add(MonedaEEUU);
        paises.add(MonedaEspana);
        paises.add(MonedaInglaterra);
        paises.add(MonedaJapon);
        paises.add(MonedaCoreaSur);
        return paises;
    }



    @FXML
    public void calcularCambio() {
        Moneda pais1 = cbPaises.getValue();
        Moneda pais2 = cbPaises2.getValue();
        float monto = Float.parseFloat(txtMonto.getText());

        BigDecimal mp1 = pais1.getTipoCambio();
        BigDecimal mp2 = pais2.getTipoCambio();
        System.out.println(mp1);
        System.out.println(mp2);

        BigDecimal res = calcular(mp1,mp2,monto);

        String moneda = pais2.getCodigo();
        Currency currency = Currency.getInstance(moneda);
        String simbolo = currency.getSymbol();

        txtResultado.setText(res.toString()+" "+simbolo);
    }

    public BigDecimal calcular(BigDecimal pais1, BigDecimal pais2, float monto)
    {
        BigDecimal razon = pais2.divide(pais1, 2, RoundingMode.HALF_UP);
        BigDecimal m = BigDecimal.valueOf(monto);
        BigDecimal resultado = m.multiply(razon);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        return resultado;
    }

}