package com.example.israa.kashiery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;

/**
 * Created by Israa on 13/09/2017.
 */

public class Visa extends AppCompatActivity {
   private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visa);
        done=(Button) this.findViewById(R.id.button4);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // action of button for move to another page receipt page (error---------)
                Intent intent = new Intent(Visa.this,Recepit.class);
                startActivity(intent);


            }
        });
        final CardForm cardForm=(CardForm) findViewById(R.id.cardform);
        TextView txtDes = (TextView) findViewById(R.id.payment_amount);
        Button btnPay = (Button) findViewById(R.id.btn_pay);


        txtDes.setText("$1999");
        btnPay.setText(String.format("Payer %s",txtDes.getText()));


        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {

                Toast.makeText(Visa.this,"Name : "+card.getName()+" | Last 4 digits : "+card.getLast4(),
                        Toast.LENGTH_SHORT).show();

            }

        });




    }
}


