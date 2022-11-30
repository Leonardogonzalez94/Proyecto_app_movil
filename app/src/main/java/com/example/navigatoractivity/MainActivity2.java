package com.example.navigatoractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button btnProduct1,btnProduct2, btnProduct3, btnProduct4;
    private TextView textProduct1, textProduct2,textProduct3, textProduct4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnProduct1=(Button) findViewById(R.id.btnProduct1);
        btnProduct2=(Button) findViewById(R.id.btnProduct2);
        btnProduct3=(Button) findViewById(R.id.btnProduct3);
        btnProduct4=(Button) findViewById(R.id.btnProduct4);

        textProduct1=(TextView) findViewById(R.id.textProduct1);
        textProduct2=(TextView) findViewById(R.id.textProduct2);
        textProduct3=(TextView) findViewById(R.id.textProduct3);
        textProduct4=(TextView) findViewById(R.id.textProduct4);

        btnProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });

        btnProduct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });

        btnProduct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}