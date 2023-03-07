package com.afa.ultimaappivan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afa.ultimaappivan.helpers.Juegos;
import com.afa.ultimaappivan.helpers.Usuarios;

import java.io.Serializable;
import java.util.ArrayList;


public class Pantalla2 extends AppCompatActivity implements Serializable {
    TextView saludo;
    Button mostrarJuegos;
    Button mensaje1;
    Button mensaje2;
    Button mensaje3;
    ArrayList<Usuarios> arrayUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        saludo = findViewById(R.id.txt_saludo_pantalla2);
        mostrarJuegos = findViewById(R.id.btn_mostrarJuegos_pantalla2);
        mensaje1 = findViewById(R.id.btn_mensaje1_pantalla2);
        mensaje2 = findViewById(R.id.btn_mensaje2_pantalla2);
        mensaje3 = findViewById(R.id.btn_mensaje3_pantalla2);
        String nombreRecogidoIntent = getIntent().getExtras().getString("nombreGuardado");
        saludo.setText("Hola " + nombreRecogidoIntent);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case R.id.ayudaJuegos:
                Uri link = Uri.parse("https://stackoverflow.com");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
                break;
            case R.id.juegosMenuJuegos:
                Intent juegos = new Intent(getApplicationContext(), ListadoJuegos.class);
                startActivity(juegos);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pantalla2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.usuariosMenu:
                Intent usuariosIntent = new Intent(getApplicationContext(), ListadoUsuarios.class);
                startActivity(usuariosIntent);
                break;
            case R.id.ayudaMenu:
                Uri link = Uri.parse("https://stackoverflow.com");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mensaje1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Pantalla2.this, "Mensaje 1", Toast.LENGTH_SHORT).show();
            }
        });
        mensaje2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Pantalla2.this, "Mensaje 2", Toast.LENGTH_SHORT).show();
            }
        });
        mensaje3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Pantalla2.this, "Mensaje 3", Toast.LENGTH_SHORT).show();
            }
        });
        mostrarJuegos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListadoJuegos.class);
                startActivity(i);
            }
        });
        mostrarJuegos.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_contextual_juegos, menu);
                menu.setHeaderTitle("Menu Contextual");
            }
        });
    }
}