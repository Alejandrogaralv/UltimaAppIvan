package com.afa.ultimaappivan.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.afa.ultimaappivan.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> arrayNombreJuegos;
    ArrayList<Integer> arrayBanderasJuegos;
    LayoutInflater inflater;

    public CustomAdapter(Context aplicationContext, ArrayList<String> arrayNombreJuegos, ArrayList<Integer> arrayBanderasJuegos) {
        this.context = context;
        this.arrayNombreJuegos = arrayNombreJuegos;
        this.arrayBanderasJuegos = arrayBanderasJuegos;
        this.inflater = (LayoutInflater.from(aplicationContext)) ;
    }

    @Override
    public int getCount() {
        return arrayNombreJuegos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.layoutlistajuegos, null);
        TextView nombre = (TextView) view.findViewById(R.id.tituloJuego);
        ImageView icono = (ImageView) view.findViewById(R.id.icono);
        nombre.setText(arrayNombreJuegos.get(i));
        icono.setImageResource(arrayBanderasJuegos.get(i));
        return view;
    }
}
