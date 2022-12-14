package com.example.navigatoractivity.Adaptadores;

import android.content.Context;
import android.content.Intent;
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
    private ArrayList<Producto>ListsProducts;



    public ProductoAdapter(Context context, ArrayList<Producto> listsProducts) {
        this.context = context;
        this.ListsProducts = listsProducts;

    }


    @Override
    public int getCount() {
        return this.ListsProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return ListsProducts.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View convertView ,ViewGroup viewGroup) {
       // if(inflater ==null){
           // inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // }
        LayoutInflater inflater =LayoutInflater.from(this.context);
        convertView= inflater.inflate(R.layout.producto_template, null);

        //if(convertView ==null){
          //  convertView=inflater.inflate(R.layout.producto_template,null);
        //}

        Producto producto=ListsProducts.get(i);

        ImageView imgProduct= (ImageView) convertView.findViewById(R.id.imgProductTemplate);
        TextView tvNameProduct=(TextView) convertView.findViewById(R.id.tvNameProduct);
        TextView tvDescriptionProduct=(TextView) convertView.findViewById(R.id.tvDescriptionProduct);
        TextView tvPriceProduct=(TextView) convertView.findViewById(R.id.tvPriceProduct);
        //Button btnProduct=(Button) convertView.findViewById(R.id.btnProduct);


        imgProduct.setImageResource(producto.getImagen());
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
                intent.putExtra("image", producto.getImagen());

                context.startActivity(intent);



            }
        });
        return convertView;
    }
}
