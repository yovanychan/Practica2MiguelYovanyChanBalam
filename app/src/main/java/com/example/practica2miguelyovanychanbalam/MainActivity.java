package com.example.practica2miguelyovanychanbalam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etTelefono;
    EditText etEmail;
    EditText etTwitter;
    Button miBoton;
    String nameUser;
    String phone;
    String mail;
    String twit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miBoton = findViewById(R.id.bt_boton); //conectar grafica con logica
        miBoton.setOnClickListener(clic); //establecer clic

        //recibiendo intents con extra
        etNombre = findViewById(R.id.et_nombre);
        etTelefono = findViewById(R.id.et_Telefono);
        etEmail = findViewById(R.id.et_email);
        etTwitter = findViewById(R.id.et_Twitter);

        Bundle bundle = getIntent().getExtras();
            etNombre.setText(bundle.getString("nombre"));
            etTelefono.setText(bundle.getString("telefono"));
            etEmail.setText(bundle.getString("email"));
            etTwitter.setText(bundle.getString("twit"));


    }

       View.OnClickListener clic = new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // instrucciones que se realiza al dar clic
               etNombre = findViewById(R.id.et_nombre);
               nameUser = String.valueOf(etNombre.getText()); // obtener datos

                etTelefono = findViewById(R.id.et_Telefono);
                 phone = String.valueOf(etTelefono.getText());

                etEmail = findViewById(R.id.et_email);
                 mail = String.valueOf(etEmail.getText());

                etTwitter = findViewById(R.id.et_Twitter);
                twit = String.valueOf(etTwitter.getText());

                //Codigo intent para conectar a otra actividad
               Intent intent = new Intent(MainActivity.this, MainActivity2.class); // conectar a otra actividad
               //los valores que se van a enviar
               intent.putExtra("nombre", nameUser);
                intent.putExtra("telefono", phone);
                intent.putExtra("email", mail);
                intent.putExtra("twit", twit);
               startActivity(intent);
           }
       };
}