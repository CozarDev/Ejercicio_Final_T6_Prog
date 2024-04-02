package com.example.ejercicio_final_t6_prog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editText1 = findViewById(R.id.editTextLugar);
        editText2 = findViewById(R.id.editTextDescripcion);
    }

    //Reinicio los editText para que estén los campos vacíos
    protected void onStart() {
        super.onStart();
        editText1.setText("");
        editText2.setText("");
    }

    /*Listener del botón que se encarga de recoger los datos de los editText y enviarlos
    a la pantalla secundaria donde se visualiza la lista*/
    public void addDatos (View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Lugar", editText1.getText().toString());
        intent.putExtra("Descripcion", editText2.getText().toString());
        startActivity(intent);
    }

}