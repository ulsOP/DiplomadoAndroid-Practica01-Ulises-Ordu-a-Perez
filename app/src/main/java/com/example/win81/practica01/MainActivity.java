package com.example.win81.practica01;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="Cambio de estado";
    private Spinner spinner;
    private String colors[]= new String[0];
    private String a;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        startNewActivity();


        colors = new String[]{"FES Aragón", "FES Iztacala", "FES Acatlán","CU", "FES Zaragoza"};     spinner = (Spinner) findViewById(R.id.spinner);
        addColors(colors);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }     });
        Log.i(TAG, "onCreate");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public MainActivity() {
        super();
    }
    private void addColors(String[] colorsToAdd) {
        ArrayAdapter<String> spinnerArrayAdapter =new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,colorsToAdd);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"OnResume");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"OnRestoreInstanceState");

        final EditText textBox =(EditText) findViewById(R.id.editText);
        CharSequence userText = savedInstanceState.getCharSequence("savedText");
        textBox.setText(userText);

        if(savedInstanceState!=null){
            colors=savedInstanceState.getStringArray("spinnerData");
            spinner.setSelection(savedInstanceState.getInt("spinnerItem"));
        }
        spinner.setSelection(savedInstanceState.getInt("spinnerKey", 0));

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"OnRestart");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"OnSaveInstanceState");
        final EditText textBox = (EditText) findViewById(R.id.editText);
        CharSequence userText = textBox.getText();
        outState.putCharSequence("savedText", userText);
        outState.putStringArray("spinnerData", colors);
        outState.putInt("spinnerKey", spinner.getSelectedItemPosition());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void startNewActivity(){Button boton = (Button) findViewById(R.id.button);
    boton.setOnClickListener(new View.OnClickListener() {
        @Override         public void onClick(View view) {
            Intent intent = new       Intent(getApplicationContext(), Main2Activity.class);
            EditText editText = (EditText) findViewById(R.id.editText);
            String message = editText.getText().toString();
            intent.putExtra("MESSAGE", message);

            Spinner spinner =(Spinner) findViewById(R.id.spinner);
            String message2 = spinner.getSelectedItem().toString();
            intent.putExtra("message2",message2);


            startActivity(intent);         }     }); }
}
