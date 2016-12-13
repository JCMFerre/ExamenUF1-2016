package com.joancreus.examenuf1_2016.Controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.joancreus.examenuf1_2016.R;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerTipus;
    private Button botonComencar;
    private Escuchador escuchador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        escuchador = new Escuchador(this);
        findViews();
        confSpinner();
        asignarEventoBoton();
    }

    private void asignarEventoBoton() {
        botonComencar.setOnClickListener(escuchador);
    }

    private void findViews() {
        spinnerTipus = (Spinner) findViewById(R.id.sp_tipus);
        botonComencar = (Button) findViewById(R.id.btn_comencar);
    }

    private void confSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.preguntas,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipus.setAdapter(adapter);
        spinnerTipus.setOnItemSelectedListener(escuchador);
    }
}
