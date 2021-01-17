package com.example.joans.timetracker;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

public class PopUpTareaActivity extends Activity {

    public static final String CREAR_TASCA = "Crear_tasca";
    ImageButton btn_close;
    Button btn_añadir;
    EditText txt_nombre;
    EditText txt_descripcion;
    Spinner lista;
    String basica = "Básica";
    String preprogramada = "Preprogramada";
    String t_limitado = "Tiempo limitado";
    String[] opciones = {basica, preprogramada, t_limitado};
    TextView tv_tiempo_limite, tv_preprogramada;
    EditText et_tiempo_limite;
    TimePicker et_preprogramada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_tarea);

        tv_tiempo_limite = (TextView) findViewById(R.id.tv_tiempo_limite);
        et_tiempo_limite = (EditText) findViewById(R.id.et_tiempo_limite);

        tv_preprogramada = (TextView) findViewById(R.id.tv_preprogramada);
        et_preprogramada = (TimePicker) findViewById(R.id.et_preprogramada);
        et_preprogramada.setIs24HourView(true);

        txt_nombre = (EditText) findViewById(R.id.et_nombre_tarea);
        txt_descripcion = (EditText) findViewById(R.id.et_descripcion_tarea);

        lista = (Spinner) findViewById(R.id.desplegable);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, opciones);
        lista.setAdapter(adaptador);

        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    tv_preprogramada.setVisibility(View.GONE);
                    et_preprogramada.setVisibility(View.GONE);
                    tv_tiempo_limite.setVisibility(View.GONE);
                    et_tiempo_limite.setVisibility(View.GONE);
                } else if (position == 1){
                    tv_preprogramada.setVisibility(View.VISIBLE);
                    et_preprogramada.setVisibility(View.VISIBLE);
                    tv_tiempo_limite.setVisibility(View.GONE);
                    et_tiempo_limite.setVisibility(View.GONE);
                } else if(position == 2){
                    tv_preprogramada.setVisibility(View.GONE);
                    et_preprogramada.setVisibility(View.GONE);
                    tv_tiempo_limite.setVisibility(View.VISIBLE);
                    et_tiempo_limite.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_close = (ImageButton) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_añadir = (Button) findViewById(R.id.btn_añadir);
        btn_añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre;
                String descripcion = "Sin descripcion";

                nombre = txt_nombre.getText().toString();
                descripcion = txt_descripcion.getText().toString();

                if(!nombre.equals("")){
                    Intent i = new Intent(PopUpTareaActivity.CREAR_TASCA);
                    i.putExtra("nombre",nombre);
                    i.putExtra("descripcion", descripcion);
                    sendBroadcast(i);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Introduce un nombre válido", Toast.LENGTH_SHORT).show();
                }

            }
        });
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width), (int)(height*.95));
        getWindow().setElevation(100);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


    }


}