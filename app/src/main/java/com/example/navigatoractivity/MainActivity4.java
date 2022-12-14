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
        listViewProducts=(ListView) findViewById(R.id.listViewProducts);
        try {
            dbHelper = new DBHelper(this);
           productoService = new ProductoService();
           arrayProductos = productoService.cursorToArray(dbHelper.getProducts());


            //Toast.makeText(this, "Insert OK", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.e("DB", e.toString());
        }
        productoAdapter= new ProductoAdapter(this, arrayProductos);
        listViewProducts.setAdapter(productoAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

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