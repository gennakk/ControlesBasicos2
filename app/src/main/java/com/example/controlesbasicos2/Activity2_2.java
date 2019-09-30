package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2_2 extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnVolver;
    Boolean boolean_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_2);

        tvResultado = findViewById(R.id.tvResultado);
        btnVolver = findViewById(R.id.btnVolver);

        Bundle extras = getIntent().getExtras();
        int num1 = extras.getInt("num1");
        int num2 = extras.getInt("num2");
        int res = extras.getInt("res");

        String resultado;

        if(calcular(num1,num2,res)){
            resultado=getString(R.string.a02txtResultadoCorrecto);
            boolean_resultado=true;
        }else{
            resultado=getString(R.string.a02txtResultadoIcorrecto);
            boolean_resultado=false;
        }

        tvResultado.setText(resultado);


        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity2_2.this, Activity2_1.class);

                intent.putExtra("resultado",boolean_resultado);
                setResult(RESULT_OK,intent);
                finish();


            }
        });

    }

    private boolean calcular(int num1,int num2,int res){

        if(num1+num2==res)
            return true;
        return false;

    }
}
