package com.example.android.listacompraandroid;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
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
 *  @autor Ramiro Vargas , Veronica Hevia
 */

public class MainActivity extends AppCompatActivity {

    /**Declaración de Variables*/

    /**Variable para la respuesta de la Segunda actividad*/
    public static final int TEXT_REQUEST = 1;

    /**Variable para instanciar la lista del diseño*/
    private ListView list;

    private ArrayAdapter<String> adapter;

    /**Variable para almacenar la lista de compra para evitar perder los datos al voltear la pantalla*/
    private ArrayList<String> arrayList;


    /**Metodo de creaión de la activity*/
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

        } else {
            arrayList = new ArrayList<String>();
        }
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        list.setAdapter(adapter);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("arrayL", arrayList);
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

    /**Metodo que captura la respueta de la segunda activity y almacena el nuevo artículo en la lista*/
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

    /**Método de compartir la lista con otras aplicaciones*/
    public void share(View view) {
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText("Lista de Compras: "+arrayList.toString())
                .startChooser();
    }
}
