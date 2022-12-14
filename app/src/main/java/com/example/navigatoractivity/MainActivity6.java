package com.example.navigatoractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigatoractivity.DB.DBHelper;
import com.example.navigatoractivity.Entidades.Producto;
import com.example.navigatoractivity.Servicios.ProductoService;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {
    private Button btnReturn;
    private DBHelper dbHelper;
    private ProductoService productoService;
    private ImageView imgDetail;
    private TextView tvNameDetail, tvDescriptionDetail, tvPriceDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        btnReturn=(Button) findViewById(R.id.btnReturn);
        imgDetail= (ImageView) findViewById(R.id.imgDetail);
        tvNameDetail=(TextView) findViewById(R.id.tvNameDetail);
        tvDescriptionDetail=(TextView) findViewById(R.id.tvDescriptionDetail);
        tvPriceDetail=(TextView) findViewById(R.id.tvPriceDetail);

        dbHelper=new DBHelper(this);
        productoService=new ProductoService();
        Intent intent= getIntent();
        String id= String.valueOf(intent.getIntExtra("id", 0));
        ArrayList<Producto> productBD= productoService.cursorToArray(dbHelper.getProductById(id));
        Producto producto = productBD.get(0);
        Bitmap bitmap = BitmapFactory.decodeByteArray(producto.getImagen(), 0, producto.getImagen().length);
        imgDetail.setImageBitmap(bitmap);



        //imgDetail.setImageResource(intent.getIntExtra("image", R.drawable.ic_launcher_background));
        tvNameDetail.setText(intent.getStringExtra("name"));
        tvDescriptionDetail.setText(intent.getStringExtra("description"));
        tvPriceDetail.setText(String.valueOf(intent.getIntExtra("price", 0)));

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 =new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent2);

            }
        });

    }
}