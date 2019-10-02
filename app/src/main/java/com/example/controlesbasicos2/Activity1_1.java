package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1_1 extends AppCompatActivity {

    private EditText edNombre,edApellidos;
    private Button btnVerificar,btnVolver;
    private TextView tvCondiciones;
    private Boolean boolean_permiso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        tvCondiciones = findViewById(R.id.tvCondiciones);

        edNombre = findViewById(R.id.edMail);
        edApellidos = findViewById(R.id.edApellido);

        btnVerificar = findViewById(R.id.btnVerificar);
        btnVolver = findViewById(R.id.btnVolver);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1_1.this, Activity1_2.class);

                intent.putExtra("nombre",edNombre.getText().toString());
                intent.putExtra("apellidos",edApellidos.getText().toString());

                startActivityForResult(intent,1234);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK) {

            String permiso;

            boolean_permiso = data.getExtras().getBoolean("permiso");

            if(boolean_permiso)
                permiso = "ACEPTADO";
            else{
                permiso = "RECHAZADO";
            }

            tvCondiciones.setText(getString(R.string.a01txtCondiciones)+" "+permiso);
        }
    }
}
