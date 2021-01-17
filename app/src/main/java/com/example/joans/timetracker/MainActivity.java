package com.example.joans.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

public class MainActivity extends AppCompatActivity {

    FloatingActionMenu actionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button butoPerComensar = (Button) findViewById(R.id.buttonStart);
        butoPerComensar.setOnClickListener(butoStartListener);

        actionMenu=(FloatingActionMenu)findViewById(R.id.menuPrincipal);
        actionMenu.setClosedOnTouchOutside(true);


    }

    private View.OnClickListener butoStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent);
        }
    };

    public void clickCrearProyecto(View view){
        Toast.makeText(this, "Crear un nuevo proyecto", Toast.LENGTH_SHORT).show();
    }


    public void clickCrearTarea(View view){
        Toast.makeText(this, "Crear una nueva tarea", Toast.LENGTH_SHORT).show();
    }


}
