package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity1_2 extends AppCompatActivity implements View.OnClickListener {

    private Button btnAceptar,btnRechazar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_2);


        btnAceptar = findViewById(R.id.btnAceptar);
        btnRechazar = findViewById(R.id.btnRechazar);
        textView = findViewById(R.id.textView4);

        btnAceptar.setOnClickListener(this);
        btnRechazar.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellidos = extras.getString("apellidos");

        textView.setText(getString(R.string.a01txtHola) +" "+nombre+" "+apellidos+" "+getString(R.string.a01txtAceptas));
    }

    @Override
    public void onClick(View v) {

        boolean permiso=false;

        Intent intent = new Intent(Activity1_2.this, Activity1_1.class);

        if(btnAceptar.isPressed()){
            permiso=true;
        }
        if(btnRechazar.isPressed()){
            permiso=false;
        }


        intent.putExtra("permiso",permiso);
        setResult(RESULT_OK,intent);
        finish();
    }

    }
