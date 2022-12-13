package com.example.navigatoractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navigatoractivity.Adaptadores.ProductoAdapter;
import com.example.navigatoractivity.Entidades.Producto;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    ListView listViewProducts;
    ProductoAdapter productoAdapter;
    ArrayList<Producto>arrayProductos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        listViewProducts=(ListView) findViewById(R.id.listViewProducts);
        arrayProductos= new ArrayList<>();
        productoAdapter= new ProductoAdapter(this, arrayProductos);


        Producto producto1= new Producto(R.drawable.meat, "Producto1","Descripcion 1", 1000);
        Producto producto2= new Producto(R.drawable.chips, "Producto2","Descripcion 2", 2000);
        Producto producto3= new Producto(R.drawable.vegetables, "Producto3","Descripcion 3", 3000);
        Producto producto4= new Producto(R.drawable.meat, "Producto4","Descripcion 4", 4000);
        Producto producto5= new Producto(R.drawable.chips, "Producto5","Descripcion 5", 5000);
        Producto producto6= new Producto(R.drawable.vegetables, "Producto6","Descripcion 6", 6000);

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);




       // productoAdapter= new ProductoAdapter(getApplicationContext(), arrayProductos);
        listViewProducts.setAdapter(productoAdapter);
        //listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          //  @Override
            //public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              //  Toast.makeText(getApplicationContext(),"presionado: "+ arrayProductos.get(i).getNombre(), Toast.LENGTH_LONG).show();
            //}
        //});

    }
}