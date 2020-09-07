package com.eltigueeere.myfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eltigueeere.myfriends.getTodosMisAmigos.ListaDeAmigos;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnListaAmigos = (Button) findViewById(R.id.button1); //DECLARAR BOTON PARA SABER SI LO TOCAN
        /*TODO ESTE METODO ES PARA SABER SI SE TOCA SALE SOLO */
        btnListaAmigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Hola amigos", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), ListaDeAmigos.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}