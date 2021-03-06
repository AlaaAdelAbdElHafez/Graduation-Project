package com.example.israa.kashiery;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

/**
 * Created by Israa on 13/09/2017.
 */

public class Recepit extends AppCompatActivity {
    EditText text;
    Button gen_btn;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recepit);
        text= (EditText) findViewById(R.id.text);
        gen_btn = (Button) findViewById(R.id.gen_btn);
        image=(ImageView) findViewById(R.id.image);
        gen_btn.setOnClickListener(new View.OnClickListener()
                                   {
                                       public void onClick(View view)
                                       {

                                           MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                                           try{
                                               BitMatrix bitaMatrix = multiFormatWriter.encode("text2Qr", BarcodeFormat.QR_CODE,200,200);
                                               BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
                                               Bitmap bitmap= barcodeEncoder.createBitmap(bitaMatrix);
                                               image.setImageBitmap(bitmap);
                                           }
                                           catch (WriterException e) {
                                               e.printStackTrace();
                                           }
                                       }
                                   }



        );
    }
}

