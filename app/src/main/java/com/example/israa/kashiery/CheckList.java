package com.example.israa.kashiery;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.Intent;
import android.hardware.camera2.CaptureResult;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.security.Key;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Israa on 13/09/2017.
 */

public class CheckList extends AppCompatActivity implements Serializable {
    ArrayList<String> products2;
    private  Button Btn_Finish;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.checklist);
        Btn_Finish=(Button) this.findViewById(R.id.btn);
        Btn_Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // action of button for move to another page visa

                Intent intent = new Intent(CheckList.this, Visa.class);
                startActivity(intent);

            }
        });
        /*to get products*/
        final TextView[] stringTextView = {(TextView) findViewById(R.id.textView)};
        Intent intent = getIntent();
        products2 = intent.getStringArrayListExtra("ProductsExtra");
        /*to define set of radio button*/
        final RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);
         RadioButton button;
        /*for(int i = 0; i <products2.size() ; i++) {
            button = new RadioButton(this);
            button.setText("Button " + i);
            group.addView(button);
        }*/
        /*-------------------------------------*/
        for(int i=0; i < products2.size(); i++){         // to show array list of string of products
            button = new RadioButton(this);
            button.setId(i);
            button.setText("Delete " + i);
            group.addView(button);
            stringTextView[0].setText(stringTextView[0].getText() + products2.get(i)+"\n");
           /* button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {    // action of  radio button
                    RadioButton selected=(RadioButton)findViewById()

                    //group.removeViewAt(i);
                   //
                    // Toast.makeText(this,"i button",Toast.LENGTH_LONG).show();
                }
            });*/
            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {    // fun to get changes on radio butt
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i)
                {
                 RadioButton selected=(RadioButton)findViewById(i);
                   // selected
                    group.removeViewAt(i);
                    for(int i1=0; i1 < products2.size(); i1++){         // to show array list of string of products

                       if(i1==i)
                       {

                           products2.remove(i1);

                         // CheckList.this.notifyAll();
                           //CheckList.this.notifyDataSetChanged();
                           for(int i11=0;i11<products2.size();i11++)
                           {
                               Toast.makeText(getApplicationContext(), "After remove the arraylist " + products2.get(i11), Toast.LENGTH_SHORT).show();
                           }

                       }


                    }


                    //Toast.makeText(getApplicationContext(), "Selected button number " + i, Toast.LENGTH_SHORT).show();
                }

            });



        }




    }
}
