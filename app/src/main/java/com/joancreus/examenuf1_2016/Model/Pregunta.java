package com.joancreus.examenuf1_2016.Model;

import java.util.Random;

/**
 * Created by ALUMNEDAM on 13/12/2016.
 */

public class Pregunta {

    private int tipoPregunta;
    private double resultado;
    private String enunciado;

    public Pregunta(int tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getEnunciado() {
        //TODO Aquí es tindria que filtra per el tipo de pregunta i realitzar les operacions pertinents.
        int num1 = new Random().nextInt(), num2 = new Random().nextInt();
        resultado = num1 + num2;
        return num1 + " + " + num2;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
