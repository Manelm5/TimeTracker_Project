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

public class PopUpInformacionActivity extends Activity {

    ImageButton btn_close;
    TextView nombre_tv;
    TextView descripcio_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        /*Linkeamos cada variable a su botón correspondiente
         *  */

        btn_close = (ImageButton) findViewById(R.id.btn_close);
        nombre_tv = findViewById(R.id.project_name);
        descripcio_tv = findViewById(R.id.descripcion_name);


        /*
         * Al clicar este botón se cierra el PopUp
         * */
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent myIntent = getIntent();
        String nombre = myIntent.getStringExtra("nombre");
        String descripcio = myIntent.getStringExtra("descripcio");


        nombre_tv.setText(nombre);
        descripcio_tv.setText(descripcio);


        /*
         * Creamos y personalizamos el PopUp
         * */

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width), (int)(height*.65));
        getWindow().setElevation(100);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


    }

}