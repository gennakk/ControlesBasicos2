package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity4_2 extends AppCompatActivity {

    TextView tvNombre,tvEmail,tvPuntuacion;

    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4_2);

        tvNombre = findViewById(R.id.tvNombre);
        tvEmail = findViewById(R.id.tvEmail);
        tvPuntuacion = findViewById(R.id.tvPuntuacion);
        btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();

        tvNombre.setText("Nombre: "+extras.getString("nombre"));
        tvEmail.setText("E-mail: "+extras.getString("mail"));
        float puntuacion = extras.getFloat("puntuacion");

        tvPuntuacion.setText("Has dado una puntuación = "+puntuacion +" estrellas.");

    }
}
