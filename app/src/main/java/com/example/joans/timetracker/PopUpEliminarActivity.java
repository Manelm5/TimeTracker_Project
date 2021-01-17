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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PopUpEliminarActivity extends Activity {

    public static final String ELIMINAR_ACTIVITY = "Eliminar_activity";
    ImageButton btn_close;
    Button btn_eliminar;
    TextView txt_comentario;
    TextView txt_titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_eliminar);

        /*Linkeamos cada variable a su botón correspondiente
         *  */
        txt_titulo = findViewById(R.id.titulo_eliminar_actividad);
        txt_comentario = findViewById(R.id.comentario);

        btn_close = (ImageButton) findViewById(R.id.btn_close);


        /*
         * Al clicar este botón se cierra el PopUp
         * */
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_eliminar = (Button) findViewById(R.id.btn_eliminar);
        /*
         * Al clickar eliminar se elimina la actividad al arbol de actividades y
         * se cierra el PopUp correspondiente
         * */

        Intent myIntent = getIntent();
        String tipo = myIntent.getStringExtra("tipo");


        if(tipo.equals("Proyecto")){
            txt_titulo.setText("Eliminar Proyecto");
            txt_comentario.setText("Se eliminarán los proyectos y tareas que contiene.");
        }else{
            txt_titulo.setText("Eliminar Tareas");
            txt_comentario.setText("Se eliminarán los intervalos de tiempo que contiene.");
        }

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(PopUpEliminarActivity.ELIMINAR_ACTIVITY);
                sendBroadcast(i);
                finish();
            }
        });

        /*
         * Creamos y personalizamos el PopUp
         * */

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width), (int)(height*.46));
        getWindow().setElevation(100);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


    }

}