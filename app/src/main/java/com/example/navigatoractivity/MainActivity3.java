package com.example.navigatoractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private Button btnProductInfo;
    private TextView textProductTitle, textProductInfo;
    private ImageView imgProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnProductInfo=(Button) findViewById(R.id.btnProductInfo);
        textProductTitle=(TextView) findViewById(R.id.textProductTitle);
        textProductInfo=(TextView) findViewById(R.id.textProductInfo);
        imgProduct=(ImageView) findViewById(R.id.imgProduct);

        Intent intentIn= getIntent();
        textProductTitle.setText(intentIn.getStringExtra("title"));
        textProductInfo.setText(intentIn.getStringExtra("description"));
        int codeImage= intentIn.getIntExtra("imageCode", 0);
        imgProduct.setImageResource(codeImage);

        btnProductInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}