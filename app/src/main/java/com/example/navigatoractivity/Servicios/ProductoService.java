package com.example.navigatoractivity.Servicios;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.example.navigatoractivity.Entidades.Producto;
import com.example.navigatoractivity.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ProductoService {
    public ArrayList<Producto> cursorToArray(Cursor cursor){
        ArrayList<Producto> list = new ArrayList<>();
        if(cursor.getCount() != 0){
            while (cursor.moveToNext()){
                Producto producto = new Producto(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4)

                );
                list.add(producto);
            }
        }
        return list;
    }
     public byte[] imageViewToByte(ImageView imageView){
       Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
       bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
       byte[] byteArray = stream.toByteArray();
          return byteArray;
    }
}
