package com.example.joans.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;


public class CrearInformeActivity extends Activity {

    ImageButton cerrar;
    Button generar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_informe);

        cerrar = (ImageButton)findViewById(R.id.closebutton);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        generar = (Button)findViewById(R.id.generarinforme_button);

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent generar = new Intent(CrearInformeActivity.this, Informe.class);
                startActivity(generar);
            }
        });


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        //getWindow().setLayout((int)(width), (int)(height));
        getWindow().setElevation(100);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

    }



}
