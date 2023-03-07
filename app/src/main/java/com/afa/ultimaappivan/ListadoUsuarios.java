package com.afa.ultimaappivan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.afa.ultimaappivan.helpers.Usuarios;

import java.util.ArrayList;

public class ListadoUsuarios extends AppCompatActivity {
    ListView simpleList;
    ArrayList<Usuarios> listaUsuarios = MainActivity.arrayUsuarios;
    ArrayList<String> listaNombreUsuarios = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuarios);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        for (Usuarios usuario:listaUsuarios) {
            String nombre = usuario.getNombre();
            listaNombreUsuarios.add(nombre);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaNombreUsuarios);
        simpleList.setAdapter(adapter);
    }
}