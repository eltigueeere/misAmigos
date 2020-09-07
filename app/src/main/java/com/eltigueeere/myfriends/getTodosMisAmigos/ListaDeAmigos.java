package com.eltigueeere.myfriends.getTodosMisAmigos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.eltigueeere.myfriends.R;
import java.util.ArrayList;
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
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
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
        simpleListView.setAdapter(simpleAdapter);
    }
}