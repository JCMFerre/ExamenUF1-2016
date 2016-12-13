package com.joancreus.examenuf1_2016.Controllers;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.joancreus.examenuf1_2016.R;

/**
 * Created by ALUMNEDAM on 13/12/2016.
 */

public class Escuchador implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private MainActivity mainActivity;
    private TestActivity testActivity;

    public Escuchador(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Escuchador(TestActivity testActivity) {
        this.testActivity = testActivity;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        mainActivity.findViewById(R.id.btn_comencar).setVisibility((position == 0) ? View.GONE : View.VISIBLE);
        mainActivity.findViewById(R.id.txt_info).setVisibility((position == 0) ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Obliga a implementar
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_comencar:
                lanzarIntent();
                break;
        }
    }

    private void lanzarIntent() {
        Intent intent = new Intent(mainActivity, TestActivity.class);
        intent.putExtra("nombre", getStringEt());
        intent.putExtra("num_preguntes", getNumPreguntes());
        intent.putExtra("tipus_preguntes", getTipusPreguntes());
        mainActivity.startActivity(intent);
    }

    private int getTipusPreguntes() {
        return ((Spinner) mainActivity.findViewById(R.id.sp_tipus)).getSelectedItemPosition();

    }

    private int getNumPreguntes() {
        int idSeleccionado = ((RadioGroup) mainActivity.findViewById(R.id.group_radio)).getCheckedRadioButtonId();
        RadioButton rd = (RadioButton) mainActivity.findViewById(idSeleccionado);
        return Integer.parseInt(rd.getText().toString());
    }

    private String getStringEt() {
        String cadena = ((EditText) mainActivity.findViewById(R.id.et_nom)).getText().toString();
        return (cadena == null ? "" : cadena);
    }
}
