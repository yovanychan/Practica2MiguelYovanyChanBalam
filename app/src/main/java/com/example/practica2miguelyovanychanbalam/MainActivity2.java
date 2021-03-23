package com.example.practica2miguelyovanychanbalam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    Button bteditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //recibiendo intents con extra
        Bundle valores = getIntent().getExtras();
        String nombre = valores.getString("nombre");
        String telefono = valores.getString("telefono");
        String email = valores.getString("email");
        String twitter = valores.getString("twit");


        tv1 = findViewById(R.id.tvnombre); // vincular con la parte grafica y logica
        tv1.setText(nombre);

        tv2 = findViewById(R.id.tvtelefono);
        tv2.setText(telefono);

        tv3 = findViewById(R.id.tvemail);
        tv3.setText(email);

        tv4 = findViewById(R.id.tvTwit);
        tv4.setText(twitter);

        //METODO DE LA FUNCION DEL BOTON
        bteditar = findViewById(R.id.bt_editda);

        bteditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editardatos = new Intent(MainActivity2.this, MainActivity.class);// conectar a otra actividad
                editardatos.putExtra("name", tv1.getText().toString());
                editardatos.putExtra("tel", tv2.getText().toString());
                editardatos.putExtra("email", tv3.getText().toString());
                editardatos.putExtra("twit", tv4.getText().toString());
                startActivity(editardatos);
            }
        });
    }


}