package com.example.win81.practica01;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            getActionBar().setDisplayHomeAsUpEnabled(true);

        }
        Intent intent = getIntent();
        String mensaje= intent.getStringExtra("MESSAGE");        //-------- le da el mensaje de la otra actividad al string "mensaje"

        TextView textView=(TextView) findViewById(R.id.textView2);    //------ estas 2 lineas llenan el textview de la actividad 2 con el mensaje anterior
        textView.setText(mensaje);


        Intent intent1 =getIntent();
        String mensaje1=intent1.getStringExtra("message2");

        TextView textView1=(TextView) findViewById(R.id.textView3);
        textView1.setText(mensaje1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
