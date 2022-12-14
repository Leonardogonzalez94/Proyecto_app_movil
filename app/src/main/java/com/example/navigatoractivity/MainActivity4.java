package com.example.navigatoractivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navigatoractivity.Adaptadores.ProductoAdapter;
import com.example.navigatoractivity.DB.DBHelper;
import com.example.navigatoractivity.Entidades.Producto;
import com.example.navigatoractivity.Servicios.ProductoService;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    private ProductoService productoService;
    private DBHelper dbHelper;
    private  ListView listViewProducts;
    private ProductoAdapter productoAdapter;
    private ArrayList<Producto>arrayProductos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        arrayProductos= new ArrayList<>();

        try {
            dbHelper = new DBHelper(this);
            //dbFirebase = new DBFirebase();
           productoService = new ProductoService();
           arrayProductos = productoService.cursorToArray(dbHelper.getProducts());
           // byte[] img= "".getBytes(StandardCharsets.UTF_8);
           // dbHelper.insertProduct("Producto1", "Descripcion 1", "1000", img);
           // dbHelper.insertProduct("Producto2", "Descripcion 2", "2000", img);
           // dbHelper.insertProduct("Producto3", "Descripcion 3", "3000", img);
           // dbHelper.insertProduct("Producto4", "Descripcion 4", "4000", img);
           // dbHelper.insertProduct("Producto5", "Descripcion 5", "5000", img);
           // dbHelper.insertProduct("Producto6", "Descripcion 6", "6000", img);

            Toast.makeText(this, "Insert OK", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.e("DB", e.toString());
        }

        listViewProducts=(ListView) findViewById(R.id.listViewProducts);
        productoAdapter= new ProductoAdapter(this, arrayProductos);
        listViewProducts.setAdapter(productoAdapter);
      //  Producto producto1= new Producto(R.drawable.meat, "Producto1","Descripcion 1", 1000);
       // Producto producto2= new Producto(R.drawable.chips, "Producto2","Descripcion 2", 2000);
      //  Producto producto3= new Producto(R.drawable.vegetables, "Producto3","Descripcion 3", 3000);
      //  Producto producto4= new Producto(R.drawable.meat, "Producto4","Descripcion 4", 4000);
      //  Producto producto5= new Producto(R.drawable.chips, "Producto5","Descripcion 5", 5000);
      //  Producto producto6= new Producto(R.drawable.vegetables, "Producto6","Descripcion 6", 6000);

      //  arrayProductos.add(producto1);
       // arrayProductos.add(producto2);
       // arrayProductos.add(producto3);
       // arrayProductos.add(producto4);
       // arrayProductos.add(producto5);
       // arrayProductos.add(producto6);



        //listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          //  @Override
            //public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              //  Toast.makeText(getApplicationContext(),"presionado: "+ arrayProductos.get(i).getNombre(), Toast.LENGTH_LONG).show();
            //}
        //});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
     //   return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent intent = new Intent(getApplicationContext(),FormProduct.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}