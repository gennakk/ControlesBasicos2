package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity3_1 extends AppCompatActivity {
    EditText edNombre,edApellidos;
    RadioGroup rdGroup;
    CheckBox[] checkArray;

    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_1);

        edNombre = findViewById(R.id.edMail);
        edApellidos = findViewById(R.id.edMail);

        rdGroup = findViewById(R.id.rdGroup);

        checkArray = new CheckBox[4];
        checkArray[0] = findViewById(R.id.ckMusica);
        checkArray[1]  = findViewById(R.id.ckLectura);
        checkArray[2]  = findViewById(R.id.ckDeportes);
        checkArray[3]  = findViewById(R.id.ckViajar);




        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if( rdGroup.getCheckedRadioButtonId()!=0  && !checkBoxSelected()){


                    Toast.makeText(Activity3_1.this,"Falta seleccionar botones",Toast.LENGTH_LONG).show();
                }else{

                    Intent intent = new Intent(Activity3_1.this,Activity3_2.class);

                    intent.putExtra("nombre",edNombre.getText().toString());
                    intent.putExtra("apellidos",edApellidos.getText().toString());

                    RadioButton radio = findViewById(rdGroup.getCheckedRadioButtonId());

                    intent.putExtra("radio",radio.getText().toString());

                    intent.putExtra("check",getCheckString());

                    startActivity(intent);
                    finish();

                }

            }
        });
    }

    private boolean checkBoxSelected(){
        for(int i=0;i<checkArray.length;i++){
            if(checkArray[i].isChecked()){
                return true;
            }
        }
        return false;

    }

    private String getCheckString(){

        String strCheck ="";

        for(CheckBox check : checkArray){

            if(check.isChecked())
                strCheck += (check.getText().toString() + ", ");

        }


        return strCheck;

    }
}
