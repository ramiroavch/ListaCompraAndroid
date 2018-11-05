package com.example.android.listacompraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 *  Activity que muestra una lista de productos creada
 *   por el usuario
 *
 *  @autor Ramiro Vargas, Veronica Hevia
 */

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * creación de las variables
         */

        list=(ListView) findViewById(R.id.listarticles);
        if (savedInstanceState != null) {
            arrayList = savedInstanceState.getStringArrayList("arrayL");

        }
        else {
            arrayList = new ArrayList<String>();
        }
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        list.setAdapter(adapter);

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("arrayL",arrayList);
    }

    /**
     * Ver la lista de productos disponibles
     * @param view
     */
    public void agregar(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    /**
     * Limpiar la lista de productos existente
     * @param view
     */
    public void eliminar(View view) {

        arrayList.clear();
        adapter.notifyDataSetChanged();

    }

    public void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                arrayList.add(reply);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
