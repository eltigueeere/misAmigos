package com.eltigueeere.myfriends.addAmigos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eltigueeere.myfriends.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddAmigos extends AppCompatActivity {
    //DECLARANDO VARIABLES
    private EditText inputNombreAmigo;
    private  EditText inputAmigoContacto;
    private Button guardarAmigoBtn;
    private DatabaseReference mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amigos);
        //INICIALIZANDO
        inputNombreAmigo = (EditText) findViewById(R.id.inputNombre);
        inputAmigoContacto = (EditText) findViewById(R.id.inputcontacto);
        guardarAmigoBtn = (Button) findViewById(R.id.guradarAmigosBtn);
        mDataBase = FirebaseDatabase.getInstance().getReference();

        guardarAmigoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ESTO CREA UN NUEVO NODO CON UN SOLO DATO NO AGREGA NI EDITA
                String name = inputNombreAmigo.getText().toString();
                String contacto = inputAmigoContacto.getText().toString();
                //mDataBase.child("nombreAmigos").setValue(mensaje);
                Map<String, Object> amigoMap = new HashMap<>();
                amigoMap.put("Pasatiempo","Pasatiempo");
                amigoMap.put("Profecion","Profecion");
                amigoMap.put("alias","alias");
                amigoMap.put("apellido","apellido");
                amigoMap.put("direccion","direccion");
                amigoMap.put("edad","edad");
                amigoMap.put("id","id");
                amigoMap.put("name",name);
                amigoMap.put("contacto",contacto);
                amigoMap.put("rsumen","resumen");
                mDataBase.child("misAmigos").push().setValue(amigoMap);
                Toast.makeText(AddAmigos.this, "Amigo Guardado", Toast.LENGTH_SHORT).show();
            }
        });


    }
}