package com.eltigueeere.myfriends.apiSepoMex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.eltigueeere.myfriends.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSepoMex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_sepo_mex);
        final TextView verCp = (TextView) findViewById(R.id.mostrarCP);
        verCp.setVisibility(View.INVISIBLE);
        final EditText inputCp = (EditText) findViewById(R.id.inputCP);
        final Button btnCp = (Button) findViewById(R.id.buscarCP);
        btnCp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputCp.getText().toString().isEmpty()){
                    Toast.makeText(ApiSepoMex.this, "Introduce un CP", Toast.LENGTH_SHORT).show();
                } else {
                    final String url = "https://api-sepomex.hckdrk.mx/query/info_cp/" + inputCp.getText().toString();
                    // Instantiate the RequestQueue.
                    RequestQueue queue;
                    queue = Volley.newRequestQueue(getApplicationContext());

                    // Request a string response from the provided URL.
                    /*StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() */

                    final JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                            (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    // Display the first 500 characters of the response string.
                                    //Toast.makeText(ApiSepoMex.this, response.toString(), Toast.LENGTH_SHORT).show();
                                    verCp.setVisibility(View.VISIBLE);
                                    verCp.setText(response.toString());

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(ApiSepoMex.this, "No lo encontre!" + url, Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Add the request to the RequestQueue.
                    queue.add(jsonObjectRequest);
                }
            }
        });
    }
}