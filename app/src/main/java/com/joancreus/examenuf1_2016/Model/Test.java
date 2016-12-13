package com.joancreus.examenuf1_2016.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALUMNEDAM on 13/12/2016.
 */

public class Test {

    private int tipoPregunta;
    private int numPreguntes;
    private List<Pregunta> preguntes;

    public Test(int numPreguntes, int tipoPregunta) {
        this.numPreguntes = numPreguntes;
        this.tipoPregunta = tipoPregunta;
        preguntes = new ArrayList<>();
    }

    public int getNumPreguntes() {
        return numPreguntes;
    }

    public void setNumPreguntes(int numPreguntes) {
        this.numPreguntes = numPreguntes;
    }

    public List<Pregunta> getPreguntes() {
        for (int i = 0; i < numPreguntes; i++) {
            preguntes.add(new Pregunta(tipoPregunta));
        }
        return preguntes;
    }

    public void setPreguntes(List<Pregunta> preguntes) {
        this.preguntes = preguntes;
    }
}
