package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2_1 extends AppCompatActivity {

    private EditText edNum1,edNum2,edRes;
    private Button btnComprobar;
    private TextView tvCorrectas,tvIncorrectas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_1);

        edNum1 = findViewById(R.id.edNum1);
        edNum2 = findViewById(R.id.edNum2);
        generarAleatorios();

        edRes = findViewById(R.id.edRes);

        btnComprobar = findViewById(R.id.btnComprobar);
        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = edNum1.getText().toString();
                String num2 = edNum2.getText().toString();
                String res = edRes.getText().toString();

                Intent intent = new Intent(Activity2_1.this,Activity2_2.class);

                intent.putExtra("num1",Integer.parseInt(num1));
                intent.putExtra("num2",Integer.parseInt(num2));
                intent.putExtra("res",Integer.parseInt(res));

                startActivityForResult(intent,1234);
            }
        });

        tvCorrectas = findViewById(R.id.tvCorrectas);
        tvCorrectas.setText(0+"");
        tvIncorrectas = findViewById(R.id.tvIncorrectas);
        tvIncorrectas.setText(0+"");


    }


    private void generarAleatorios(){

        edNum1.setText(((int)(Math.random()*101))+"");
        edNum2.setText(((int)(Math.random()*101))+"");

    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK) {

            Boolean boolean_resultado;

            boolean_resultado = data.getExtras().getBoolean("resultado");

            if(boolean_resultado)
                tvCorrectas.setText(Integer.parseInt(tvCorrectas.getText().toString())+1+"");
            else{
                tvIncorrectas.setText(Integer.parseInt(tvIncorrectas.getText().toString())+1+"");
            }


        }
    }
}
