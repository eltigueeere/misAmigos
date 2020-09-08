package com.eltigueeere.myfriends.getTodosMisAmigos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.eltigueeere.myfriends.R;
import com.eltigueeere.myfriends.addAmigos.AddAmigos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static com.eltigueeere.myfriends.R.*;

public class ListaDeAmigos extends AppCompatActivity {
    /* PRIMER LISTVIEW
    ListView listaAmigos;
    ArrayList<String> amigos = new ArrayList<String>();
    */
    String[] ListViewTitle = new String[]{
            "List view title 1","List view title 2","List view title 3","List view title 4",
    };
    String[] ListViewDescrpcion = new String[]{
            "List view descripcion  1","List view descripcion 2","List view title 3","List view descripcion 4",
    };
    int[] ListViewImages = new int[]{
            drawable.persona,drawable.persona,drawable.persona,drawable.persona
    };

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_lista_de_amigos);
        /*PRIMER LISTVIEW
        listaAmigos =  findViewById(id.miListView);
        amigos.add("Daniela");
        amigos.add("Nene");
        amigos.add("Eduardo");
        ArrayAdapter<String> paraLaLista = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, amigos);
        listaAmigos.setAdapter(paraLaLista);
         */
        /*final List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for(int i=0; i<ListViewTitle.length; i++){
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("ListTitle",ListViewTitle[i]);
            hm.put("ListDescription",ListViewDescrpcion[i]);
            hm.put("ListImages",Integer.toString(ListViewImages[i]));
            aList.add(hm);
        }
        String[] from = {
                "ListImages", "ListTitle", "ListDescription"
        };
        int[] to = {
                R.id.ListViewImge,R.id.title, id.description
        };
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(),aList, layout.lista_formato,from,to);
        ListView simpleListView = (ListView) findViewById(R.id.miListView);
        simpleListView.setAdapter(simpleAdapter);*/
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("misAmigos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                /*if(dataSnapshot.exists()){
                    String data = dataSnapshot.child("name").getValue().toString();
                    Toast.makeText(ListaDeAmigos.this, data, Toast.LENGTH_LONG).show();
                }*/
                if(dataSnapshot.exists()){
                    final List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
                    for(DataSnapshot ds: dataSnapshot.getChildren()){
                        String name = ds.child("name").getValue().toString();
                        String contacto = ds.child("contacto").getValue().toString();
                         HashMap<String, String> hm = new HashMap<String, String>();
                         hm.put("ListTitle",name);
                         hm.put("ListDescription",contacto);
                         hm.put("ListImages",Integer.toString(ListViewImages[0]));
                         aList.add(hm);
                    }
                    String[] from = {
                            "ListImages", "ListTitle", "ListDescription"
                    };
                    int[] to = {
                            R.id.ListViewImge,R.id.title, id.description
                    };
                    SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(),aList, layout.lista_formato,from,to);
                    ListView simpleListView = (ListView) findViewById(R.id.miListView);
                    simpleListView.setAdapter(simpleAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //BOTON ADD AMIGOS
        Button addAmigos = (Button) findViewById(id.addAmigos);
        addAmigos.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddAmigos.class);
                startActivityForResult(intent, 0);
            }
        }));
    }
}