package com.example.android.listacompraandroid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

/**
 *  Adaptador que agrega los productos al RecyclerView
 *
 *  @autor Ramiro Vargas, Veronica Hevia
 */
public class Adapter_productos
        extends RecyclerView.Adapter<Adapter_productos.WordViewHolder>
        {
    private LinkedList<compraProducto> productsList;
    private LayoutInflater mInflater;
    private SecondActivity productosActivity;
    private Context context;

    public Adapter_productos(Context context, LinkedList<compraProducto> wordList,SecondActivity productosActivity) {
        mInflater = LayoutInflater.from(context);
        this.productsList = wordList;
        this.productosActivity = productosActivity;
        this.context=context;
    }



    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView wordItemView;
        public TextView priceItemView;
        public ImageView photoItemView;
        public CardView card;
        Adapter_productos mAdapter;

        public WordViewHolder(View itemView) {
            super(itemView);
        }

        public WordViewHolder(View itemView, Adapter_productos adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.nombre_articulo);
            priceItemView = (TextView) itemView.findViewById(R.id.precio_articulo);
            photoItemView = (ImageView) itemView.findViewById(R.id.articulo);
            card = (CardView) itemView.findViewById(R.id.card_articulo);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = productsList.get(mPosition).nombre;
            // Change the word in the mWordList.
            /*Toast toast1 =
                    Toast.makeText(context,
                            element, Toast.LENGTH_SHORT);
            toast1.show();*/
            productosActivity.Return(element);
        }
    }




    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.image_card, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, final int position) {
        compraProducto mCurrent = productsList.get(position);
        holder.wordItemView.setText(productsList.get(position).nombre);
        holder.priceItemView.setText(productsList.get(position).precio);
        holder.photoItemView.setImageResource(productsList.get(position).foto);

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


}