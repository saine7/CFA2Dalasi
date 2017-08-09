package com.gayetech.alagiesaine.cfa2dalasi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeRate extends Activity{

    EditText rate;
    Button rateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_rate_layout);
        rate = (EditText) findViewById(R.id.rateField);
        rateButton = (Button) findViewById(R.id.setRateButton);
        final String returnedRate = rate.getText().toString().trim();


            rateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String returnedRate = rate.getText().toString().trim();
                    if(returnedRate.length() == 0){
                        Toast.makeText(getApplicationContext(),"Please enter rate", Toast.LENGTH_SHORT).show();
                    }else {
                        int convertToInt = Integer.parseInt(returnedRate);
                        SharedPref pref = new SharedPref(getApplicationContext());
                        pref.setRate(convertToInt);
                        Toast.makeText(getApplicationContext(),"Rate set to D" + returnedRate, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                }
            });


    }
}
