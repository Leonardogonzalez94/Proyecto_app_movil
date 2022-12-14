package com.example.navigatoractivity.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigatoractivity.Entidades.Producto;

import com.example.navigatoractivity.MainActivity6;
import com.example.navigatoractivity.R;

import java.util.ArrayList;


public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto>arrayProductos;



    public ProductoAdapter(Context context, ArrayList<Producto> arrayProductos) {
        this.context = context;
        this.arrayProductos = arrayProductos;

    }


    @Override
    public int getCount() {
        return this.arrayProductos.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProductos.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view ,ViewGroup viewGroup) {

        LayoutInflater inflater =LayoutInflater.from(this.context);
        view= inflater.inflate(R.layout.producto_template, null);



        Producto producto=arrayProductos.get(i);

        ImageView imgProduct= (ImageView) view.findViewById(R.id.imgProductTemplate);
        TextView tvNameProduct=(TextView) view.findViewById(R.id.tvNameProduct);
        TextView tvDescriptionProduct=(TextView) view.findViewById(R.id.tvDescriptionProduct);
        TextView tvPriceProduct=(TextView) view.findViewById(R.id.tvPriceProduct);



        Bitmap bitmap= BitmapFactory.decodeByteArray(producto.getImagen(), 0,producto.getImagen().length);
        imgProduct.setImageBitmap(bitmap);
        tvNameProduct.setText(producto.getNombre());
        tvDescriptionProduct.setText(producto.getDescripcion());
        tvPriceProduct.setText(String.valueOf(producto.getPrecio()));


        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context.getApplicationContext(), MainActivity6.class);
                intent.putExtra("name",producto.getNombre());
                intent.putExtra("description",producto.getDescripcion());
                intent.putExtra("price",producto.getPrecio());
             //   intent.putExtra("image", producto.getImagen());
                intent.putExtra("id",producto.getId());

                context.startActivity(intent);



            }
        });
        return view;
    }
}
