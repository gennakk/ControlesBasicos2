package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Activity4_1 extends AppCompatActivity {

    EditText edNombre,edMail;

    RatingBar ratingBar;

    Button btnPuntua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4_1);

        edNombre = findViewById(R.id.edNombre);
        edMail = findViewById(R.id.edMail);

        ratingBar = findViewById(R.id.raingBar);

        btnPuntua = findViewById(R.id.btnPuntuar);


        btnPuntua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity4_1.this,Activity4_2.class);

                intent.putExtra("nombre",edNombre.getText().toString());
                intent.putExtra("mail",edMail.getText().toString());

                intent.putExtra("puntuacion",ratingBar.getRating());

                startActivity(intent);
            }
        });
    }
}
