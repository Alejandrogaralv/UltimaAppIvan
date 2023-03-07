package com.afa.ultimaappivan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afa.ultimaappivan.helpers.Usuarios;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {
    static ArrayList<Usuarios> arrayUsuarios = new ArrayList<>();
    Usuarios usuario1 = new Usuarios("Paco", "111", "111");
    Usuarios usuario2 = new Usuarios("Pepe", "222", "222");
    Usuarios usuario3 = new Usuarios("Pepa", "333", "333");
    EditText dni_recogido;
    EditText password_recogida;
    Button btn_logIn;
    Button btn_help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dni_recogido = findViewById(R.id.input_dni_mainact);
        password_recogida = findViewById(R.id.input_password_mainact);
        btn_logIn = findViewById(R.id.btn_logIn_mainact);
        btn_help = findViewById(R.id.btn_help_mainact);
        arrayUsuarios.add(usuario1);
        arrayUsuarios.add(usuario2);
        arrayUsuarios.add(usuario3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse("https://stackoverflow.com");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
            }
        });
        btn_logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = dni_recogido.getText().toString();
                String password = password_recogida.getText().toString();

                if(dni.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "Por favor, rellena los campos", Toast.LENGTH_LONG).show();
                }else{
                    boolean datosCorrectos = false;
                    for (Usuarios usuario : arrayUsuarios) {
                        if(dni.equals(usuario.getDni())&&password.equals(usuario.getPassword())){
                            datosCorrectos = true;
                            Intent i = new Intent(getApplicationContext(), Pantalla2.class);
                            i.putExtra("passwordGuardada", usuario.getPassword());
                            i.putExtra("dniGuardado", usuario.getDni());
                            i.putExtra("nombreGuardado", usuario.getNombre());
                            i.putExtra("arrayusuarios", arrayUsuarios);
                            startActivity(i);
                        }
                    }
                    if (!datosCorrectos){
                        Toast.makeText(MainActivity.this, "Error, los datos introducidos no son correctos", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}