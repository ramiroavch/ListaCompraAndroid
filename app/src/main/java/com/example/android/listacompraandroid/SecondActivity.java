package com.example.android.listacompraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.LinkedList;

/**
 *  Activity que muestra una lista de productos en venta
 *
 *  @autor Ramiro Vargas, Veronica Hevia
 */
public class SecondActivity extends AppCompatActivity {

    private final LinkedList<compraProducto> productsList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private Adapter_productos mAdapter;
    public static final String PRODUCT_REPLY = "com.example.android.listacompraandroid.extra.Product";
    public static final String PRICE_REPLY = "com.example.android.listacompraandroid.extra.Price";
    public static final String IMAGE_REPLY = "com.example.android.listacompraandroid.extra.Image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicializarData(productsList);
        setContentView(R.layout.activity_second);
        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_productos);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new Adapter_productos(this, productsList,this);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        int i = getResources().getConfiguration().orientation;
        GridLayoutManager glm = new GridLayoutManager(this,2*i);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(glm);
    }

    /**
     * Inizializador que carga todos los productos en la lista
     * @param productsList : Lista de productos a llenar
     */
    private void inicializarData(LinkedList productsList){
        productsList.add(new compraProducto("Harina","Precio: 30Bs",R.drawable.harina));
        productsList.add(new compraProducto("Nutella","Precio: 1900Bs",R.drawable.nutella));
        productsList.add(new compraProducto("Arroz","Precio: 200Bs",R.drawable.arroz));
        productsList.add(new compraProducto("Pan Bimbo","Precio: 250Bs",R.drawable.bimbo));
        productsList.add(new compraProducto("Pan de sandwich","Precio: 400Bs",R.drawable.bread));
        productsList.add(new compraProducto("Cheerios","Precio: 2000Bs",R.drawable.cheerios));
        productsList.add(new compraProducto("Coca-cola","Precio: 450Bs",R.drawable.coke));
        productsList.add(new compraProducto("Doritos","Precio: 400",R.drawable.doritos));
        productsList.add(new compraProducto("Jugo","Precio: 150Bs",R.drawable.jugo));
        productsList.add(new compraProducto("Salsa de tomate","Precio: 70Bs",R.drawable.ketchup));
        productsList.add(new compraProducto("Mayonesa","Precio: 80Bs",R.drawable.mayo));
        productsList.add(new compraProducto("Oreos","Precio: 200Bs",R.drawable.oreos));
        productsList.add(new compraProducto("Comida para perros 4kg","Precio: 1200Bs",R.drawable.perro));
        productsList.add(new compraProducto("Lata de Pirulin pequeña","Precio: 800Bs",R.drawable.pirulin));
        productsList.add(new compraProducto("Platanitos","Precio: 650Bs",R.drawable.platanitos));
        productsList.add(new compraProducto("Salchichas","Precio: 900Bs",R.drawable.salchichas));
        productsList.add(new compraProducto("Tequeños","Precio: 700Bs",R.drawable.tequenos));
        productsList.add(new compraProducto("Trululu","Precio: 150Bs",R.drawable.trululu));
        productsList.add(new compraProducto("Yogurt","Precio: 200Bs",R.drawable.yogurt));
        productsList.add(new compraProducto("Pasta","Precio: 45Bs",R.drawable.pasta));
    }


}