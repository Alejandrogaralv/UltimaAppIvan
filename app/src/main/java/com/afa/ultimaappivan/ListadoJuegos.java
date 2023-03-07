package com.afa.ultimaappivan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.afa.ultimaappivan.helpers.CustomAdapter;
import com.afa.ultimaappivan.helpers.Juegos;

import java.util.ArrayList;

public class ListadoJuegos extends AppCompatActivity {
    ListView listaCustom;
    ArrayList<Juegos> arrayJuegos = new ArrayList<>();
    Juegos juego1 = new Juegos("League of Legeds", R.drawable.lol);
    Juegos juego2 = new Juegos("Valorant", R.drawable.valorant);
    Juegos juego3 = new Juegos("Pokémon", R.drawable.pokemon);
    Juegos juego4 = new Juegos("Minecraft", R.drawable.minecraft);
    ArrayList<String> nombreJuegos = new ArrayList<>();
    ArrayList<Integer> iconosJuegos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_juegos);
        nombreJuegos.add(juego1.getNombre());
        nombreJuegos.add(juego2.getNombre());
        nombreJuegos.add(juego3.getNombre());
        nombreJuegos.add(juego4.getNombre());
        iconosJuegos.add(juego1.getIcono());
        iconosJuegos.add(juego2.getIcono());
        iconosJuegos.add(juego3.getIcono());
        iconosJuegos.add(juego4.getIcono());
        listaCustom = (ListView)findViewById(R.id.listaCustomJuegos);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), nombreJuegos, iconosJuegos);
        listaCustom.setAdapter(customAdapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        listaCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), JuegoDetallado.class);
                i.putExtra("NombreJuegoDetallado", nombreJuegos.get(position));
                i.putExtra("IconoJuegoDetallado", iconosJuegos.get(position));
                startActivity(i);
            }
        });
    }
}