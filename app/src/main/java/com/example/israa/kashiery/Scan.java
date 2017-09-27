package com.example.israa.kashiery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.Serializable;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

public class Scan extends AppCompatActivity implements Serializable {

    private Button button;
    private Button Btn_Next;
    ArrayList<String> products= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan);
        /* multiple buttons with multiple activity*/
        button=(Button) this.findViewById(R.id.Scan);
        Btn_Next=(Button) this.findViewById(R.id.Next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {       //  action of buuton for scanner camera

                IntentIntegrator integrator= new IntentIntegrator(Scan.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);

                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

            }
        });

        Btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // action of button for move to another page checklist
              /* Intent i1 = new Intent(Scan.this, CheckList.class);
                startActivity(i1);*/
               Intent intent = new Intent(Scan.this, CheckList.class);
                intent.putExtra("ProductsExtra", products);
                startActivity(intent);

            }
        });


    }



    /*protected void MoveToCheckList(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan);
        Btn_Next=(Button) this.findViewById(R.id.Next);
       // final Activity activity=this;
        Btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(Scan.this,CheckList.class);
                startActivity(i1);
            }
        });

    }*/




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null)
        {
            if(result.getContents() == null)
            {
                Log.d("MainActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else
            {
                Log.d("MainActivity", "Scanned");
               // Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                products.add(result.getContents()+"\n");


                for(int i=0;i<products.size();i++)          //to show array of scanned products
                {
                    Toast.makeText(this, "Scanned: " + products.get(i), Toast.LENGTH_LONG).show();

                }
            }
        }
        else
        {
            super.onActivityResult(requestCode,resultCode,data);
        }

    }

 /*Intent I=new Intent(getApplicationContext(),CheckList.class);
    I.P*/




}

