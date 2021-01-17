package com.example.joans.timetracker;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

public class PopUpProyectoActivity extends Activity {

    public static final String CREAR_PROJECTE = "Crear_projecte";
    ImageButton btn_close;
    Button btn_añadir;
    EditText txt_nombre;
    EditText txt_descripcion;
    FloatingActionMenu actionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_proyecto);

        txt_nombre = (EditText) findViewById(R.id.et_nombre_proyecto);
        txt_descripcion = (EditText) findViewById(R.id.et_descripcion_proyecto);

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
                    Intent i = new Intent(PopUpProyectoActivity.CREAR_PROJECTE);
                    i.putExtra("nombre",nombre);
                    i.putExtra("descripcion", descripcion);
                    sendBroadcast(i);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Introduce un nombre válido", Toast.LENGTH_SHORT).show();
                }

            }
        });

        /*
         * Creamos y personalizamos el PopUp
         * */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width), (int)(height*.68));
        getWindow().setElevation(100);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


    }


}