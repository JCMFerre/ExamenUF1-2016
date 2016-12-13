package com.joancreus.examenuf1_2016.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.joancreus.examenuf1_2016.Model.Pregunta;
import com.joancreus.examenuf1_2016.Model.Test;
import com.joancreus.examenuf1_2016.R;

import java.util.List;

public class TestActivity extends AppCompatActivity {

    private TextView aciertos;
    private TextView errores;
    private Button boton;
    private int numPreguntes;
    private int indexPreguntesArray;
    private List<Pregunta> preguntes;
    private int preguntaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nombre");
        numPreguntes = intent.getIntExtra("num_preguntes", 0);
        indexPreguntesArray = intent.getIntExtra("tipus_preguntes", -1);
        crearTest();
        ((TextView) findViewById(R.id.test_info)).setText(getString(R.string.txt_test) + " (" + tipoPreguntes(indexPreguntesArray) + ")");
        findViews();
        mostrarPregunta();
        Log.i("Intent", "Nom: " + nom + ", Num preguntes: " + numPreguntes + ", indexArray: " + indexPreguntesArray);
    }

    private void crearTest() {
        Test test = new Test(numPreguntes, indexPreguntesArray);
        preguntes = test.getPreguntes();
        preguntaActual = 0;
    }

    private void actualizarPregunta() {
        preguntaActual++;
    }
    private void mostrarPregunta(){
        ((TextView) findViewById(R.id.pregunta_actual)).setText(preguntes.get(preguntaActual).getEnunciado());
    }

    private void findViews() {
        aciertos = (TextView) findViewById(R.id.num_aciertos);
        errores = (TextView) findViewById(R.id.num_errores);
        boton = (Button) findViewById(R.id.btn_test);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Double.parseDouble(((EditText) findViewById(R.id.et_resultat)).getText().toString()) == preguntes.get(preguntaActual).getResultado()){
                    incrementarTextView(aciertos);
                } else{
                    incrementarTextView(errores);
                }
                actualizarPregunta();
                // TODO habria que recuperar de la clase Test la llista de preguntes
                // EX
                mostrarPregunta();
                // TODO hay que comparar resultados (getResultados).
                // TODO Tot aixo tindria que anar al lloc adecuat, depenent de la pregunta per la que vas,
                // si es desde l'ultima pregunta (size() -1) mostrar el boton el text finalitzar.
            }
        });
    }

    private void incrementarTextView(TextView textView) {
        int num = Integer.parseInt(textView.getText().toString());
        num++;
        textView.setText(num);
    }


    private String tipoPreguntes(int index) {
        String[] preguntes;
        preguntes = getResources().getStringArray(R.array.preguntas);
        return preguntes[index];
    }
}
