package com.example.android.listacompraandroid;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    String[] nombre_articulos;
    TypedArray foto_articulos;

    List<RowItem> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowItems = new ArrayList<RowItem>();

        nombre_articulos = getResources().getStringArray(R.array.articulos);

        foto_articulos = getResources().obtainTypedArray(R.array.imagenes);


        for (int i = 0; i < nombre_articulos.length; i++) {
            RowItem item = new RowItem(nombre_articulos[i],
                    foto_articulos.getResourceId(i, -1));
            rowItems.add(item);
        }

        mylistview = (ListView) findViewById(R.id.listView1);
        Adapter adapter = new Adapter(this, rowItems);
        mylistview.setAdapter(adapter);

    }
}
