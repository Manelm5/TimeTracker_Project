package com.example.joans.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;


public class AdaptadorInterval extends ArrayAdapter{

    private Activity context;
    private List<DadesInterval> datos;
    private final String tag = this.getClass().getCanonicalName();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    public AdaptadorInterval(Activity context, List<DadesInterval> datos) {
        super(context, R.layout.textview_llista_intervals, datos);
        this.datos = datos;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        TextView fechaInicial;
        TextView fechaFinal;
        TextView duracion;

        convertView = inflater.inflate(R.layout.textview_llista_intervals, null);

        fechaInicial = convertView.findViewById(R.id.fecha_inicial);
        fechaFinal = convertView.findViewById(R.id.fecha_final);
        duracion = convertView.findViewById(R.id.duracion);

        fechaInicial.setText(sdf.format(datos.get(position).getDataFinal()));
        fechaFinal.setText(sdf.format(datos.get(position).getDataInicial()));
        duracion.setText(datos.get(position).toString());


        return convertView;
    }
}
