package com.example.android.listacompraandroid;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

    public class Adapter extends BaseAdapter {

        Context context;
        List<RowItem> rowItems;

        Adapter (Context context, List<RowItem> rowItems){
            this.context = context;
            this.rowItems = rowItems;
        }

        public int getCount() { return rowItems.size(); }

        public Object getItem(int position) { return rowItems.get(position); }

        public long getItemId(int position) { return rowItems.indexOf(getItem(position)); }

        private class ViewHolder {
            ImageView img_articulo;
            TextView nombre_articulo;
        }

        public View getView(int position, View convertView, ViewGroup parent){

            ViewHolder holder = null;

            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null){
                convertView = mInflater.inflate(R.layout.row_image_list, null);
                holder = new ViewHolder();

                holder.nombre_articulo = (TextView) convertView
                        .findViewById(R.id.nombre_articulo);
                holder.img_articulo = (ImageView) convertView
                        .findViewById(R.id.articulo);

                RowItem row_pos = rowItems.get(position);

                holder.img_articulo.setImageResource(row_pos.getFoto_articulo());
                holder.nombre_articulo.setText(row_pos.getArticulo());

                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            return convertView;
        }
    }
