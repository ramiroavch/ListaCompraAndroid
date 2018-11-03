package com.example.android.listacompraandroid;

import java.security.PublicKey;

public class RowItem {

    private String articulo;
    private int foto_articulo;

    public RowItem(String articulo, int foto_articulo){

        this.articulo = articulo;
        this.foto_articulo = foto_articulo;
    }

    public String getArticulo() { return articulo; }

    public void setArticulo(String articulo) { this.articulo = articulo; }

    public int getFoto_articulo() { return foto_articulo; }

    public void setFoto_articulo(int foto_articulo) { this.foto_articulo = foto_articulo; }
}
