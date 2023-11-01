package com.example.momochargeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float percent = 0.005F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void checkCharges(View v) {
        try {
            Button b = (Button) v;
            EditText amount= (EditText)findViewById(R.id.amount);
            TextView charges = findViewById(R.id.charges);
            String stAmount = amount.getText().toString();
            int integerAmount = Integer.parseInt(stAmount);
            if( integerAmount >= 0 || integerAmount <= 9999){
                float finalAmount = (float) (integerAmount *  percent);
                charges.setText(Integer.toString((int) finalAmount));
            }
        }catch (Exception e){
            Log.d("Error", "failed");
        }
    }

    public void  whatsapp(View v){
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=673518539"));
            startActivity(intent);
        }catch (Exception e){
            Log.d("Error", "whatsapp failed");
        }

    }

}