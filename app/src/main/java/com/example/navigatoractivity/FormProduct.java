package com.example.navigatoractivity;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.navigatoractivity.DB.DBFirebase;
import com.example.navigatoractivity.DB.DBHelper;
import com.example.navigatoractivity.Entidades.Producto;
import com.example.navigatoractivity.Servicios.ProductoService;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FormProduct extends AppCompatActivity {
   private Button btnFormProduct, btnGetFormProduct, btnDeleteFormProduct, btnUpdateFormProduct;
   private EditText editNameFormProduct, editDescriptionFormProduct, editPriceFormProduct, editIdFormProduct;
   private ImageView imgFormProduct;
   private DBHelper dbHelper;
   private ActivityResultLauncher<String> content;
   private ProductoService productoService;
   private DBFirebase dbFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_product);
        
        btnFormProduct=(Button) findViewById(R.id.btnFormProduct);
        btnGetFormProduct=(Button) findViewById(R.id.btnGetFormProduct);
        btnDeleteFormProduct=(Button) findViewById(R.id.btnDeleteFormProduct);
        btnUpdateFormProduct=(Button) findViewById(R.id.btnUpdateFormProduct);
        editIdFormProduct=(EditText) findViewById(R.id.editIdFormProduct);
        editNameFormProduct=(EditText) findViewById(R.id.editNameFormProduct);
        editDescriptionFormProduct=(EditText) findViewById(R.id.editDescriptionFormProduct);
        editPriceFormProduct=(EditText) findViewById(R.id.editPriceFormProduct);
        imgFormProduct=(ImageView) findViewById(R.id.imgFormProduct);

        //editPriceFormProduct.setOnKeyListener(new View.OnKeyListener() {
          //  public boolean onKey(View v, int keyCode, KeyEvent event){

            //    if((event.getAction()== KeyEvent.ACTION_DOWN) &&
                //        (keyCode== KeyEvent.KEYCODE_ENTER)){
              //      Toast.makeText(getApplicationContext(), "Hello Enter", Toast.LENGTH_SHORT).show();
                  //  return true;

               // }
               //return false;
           // }
        //});

        try{
            dbHelper= new DBHelper(this);
            //dbFirebase=  new DBFirebase();
            productoService = new ProductoService();
            content= registerForActivityResult(
                    new ActivityResultContracts.GetContent(),
                    new ActivityResultCallback<Uri>() {
                        @Override
                        public void onActivityResult(Uri result) {
                            try{
                                InputStream inputStream=getContentResolver().openInputStream(result);
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                imgFormProduct.setImageBitmap(bitmap);

                            }catch (FileNotFoundException e){
                                Log.e("File error", e.toString());

                            }
                        }
                    });

        }catch (Exception e){

            Log.e("DB", e.toString());
        }
        imgFormProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content.launch("image/*");
            }
        });

        btnFormProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // dbHelper.insertProduct(
                //
                 Producto producto= new Producto(
                        //editIdFormProduct.getText().toString(),
                        editNameFormProduct.getText().toString(),
                        editDescriptionFormProduct.getText().toString(),
                        Integer.parseInt(editPriceFormProduct.getText().toString()),
                         "");

                dbHelper.insertProduct(producto);
               // dbFirebase.insertProduct(producto);



                Intent intent =new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
            }
        });

        btnGetFormProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editIdFormProduct.getText().toString().trim();
                if(id.compareTo("") == 0){
                  Toast.makeText(getApplicationContext(),"Ingrese un ID", Toast.LENGTH_SHORT).show();
                }else{

                       ArrayList<Producto> productDB =productoService.cursorToArray(dbHelper.getProductById(id));
                       if(productDB.size() != 0){
                        Producto producto = productDB.get(0);
                        editNameFormProduct.setText(producto.getNombre());
                        editDescriptionFormProduct.setText(producto.getDescripcion());
                        editPriceFormProduct.setText(String.valueOf(producto.getPrecio()));
                       // Bitmap bitmap = BitmapFactory.decodeByteArray(producto.getImagen(), 0, producto.getImagen().length());
                        //imgFormProduct.setImageBitmap(bitmap);
                         }else {
                          Toast.makeText(getApplicationContext(),"No existe",Toast.LENGTH_SHORT).show();
                     }
                }
            }
        });

        btnDeleteFormProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editIdFormProduct.getText().toString().trim();
                dbHelper.deleteProductById(id);
                clean();
            }
        });

        btnUpdateFormProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editIdFormProduct.getText().toString().trim();
                if(id.compareTo("")!=0){
                    dbHelper.updateProduct(
                            id,
                            editNameFormProduct.getText().toString(),
                            editDescriptionFormProduct.getText().toString(),
                            editPriceFormProduct.getText().toString(),
                            productoService.imageViewToByte(imgFormProduct)
                    );
                    clean();
                }
            }
        });
    }

    public void clean(){
        editNameFormProduct.setText("");
        editDescriptionFormProduct.setText("");
        editPriceFormProduct.setText("");
        imgFormProduct.setImageResource(R.drawable.ic_launcher_background);
    }

}