package com.afa.ultimaappivan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class JuegoDetallado extends AppCompatActivity {
    TextView tituloJuego;
    ImageView iconoJuego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_detallado);
        tituloJuego = findViewById(R.id.tituloJuegoDetalle);
        iconoJuego = findViewById(R.id.iconoJuegoDetalle);
        tituloJuego.setText(getIntent().getExtras().getString("NombreJuegoDetallado"));
        iconoJuego.setImageResource(getIntent().getExtras().getInt("IconoJuegoDetallado"));
    }
}