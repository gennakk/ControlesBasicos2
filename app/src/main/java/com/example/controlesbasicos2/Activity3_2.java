package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity3_2 extends AppCompatActivity {

    TextView tvNombre,tvApellidos,tvSexo,tvAficiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_2);


        tvNombre = findViewById(R.id.tvNombre);
        tvApellidos = findViewById(R.id.tvApellidos);
        tvSexo = findViewById(R.id.tvSexo);
        tvAficiones = findViewById(R.id.tvAficiones);

        Bundle extras = getIntent().getExtras();

        String nombre = extras.getString("nombre");
        String apellidos = extras.getString("apellidos");
        String radio = extras.getString("radio");
        String strCheck = extras.getString("check");

        tvNombre.setText("Nombre: "+nombre);
        tvApellidos.setText("Apellidos: "+apellidos);
        tvSexo.setText("Sexo: "+radio);
        tvAficiones.setText("Aficiones: "+  strCheck);


    }
}
