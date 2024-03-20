package com.example.ejercicio_final_t6_prog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class SecondActivity extends AppCompatActivity {
    private ArrayList<Lugar> lugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.segunda_pantalla);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cargarDatos();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        AdaptadorLugares adaptadorLugares = new AdaptadorLugares(lugares);
        recyclerView.setAdapter(adaptadorLugares);


        Intent intent = getIntent();
        String lugar = intent.getStringExtra("Lugar");
        String descripcion = intent.getStringExtra("Descripcion");

        if (Objects.equals(lugar, "") || Objects.equals(descripcion, "")){
            Toast.makeText(this, "No se han añadido datos nuevos", Toast.LENGTH_SHORT).show();
        } else {
            adaptadorLugares.aniadirLugar(new Lugar(lugar, descripcion));
        }

        guardarDatos();
    }

    private void guardarDatos() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();

        String json = gson.toJson(lugares);
        editor.putString("lugares", json);
        editor.apply();
    }

    private void cargarDatos() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();

        String json = sharedPreferences.getString("lugares", null);

        Type type = new TypeToken<ArrayList<Lugar>>() {}.getType();

        lugares = gson.fromJson(json, type);

        if (lugares == null){
            lugares = new ArrayList<>();
        }
    }
}