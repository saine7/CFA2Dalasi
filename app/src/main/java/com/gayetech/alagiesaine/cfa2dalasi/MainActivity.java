package com.gayetech.alagiesaine.cfa2dalasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cfaField;
    Button buttonConvert;
    TextView resultTextView;
    StringBuilder stringBuilder;
    int user_entered_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cfaField = (EditText) findViewById(R.id.cfaField);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        buttonConvert = (Button) findViewById(R.id.buttonConvert);
        stringBuilder = new StringBuilder();

        SharedPref pref = new SharedPref(getApplicationContext());
        int rate = pref.getRate();

        if (rate == 0){
            user_entered_rate = 400;
            Toast.makeText(getApplicationContext(),"Initial rate is set to D400. You can change it in the menu",Toast.LENGTH_LONG).show();
        }else {
            user_entered_rate = rate;
        }

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getConversion();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getConversion();
    }
    public void getConversion(){
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cfa = cfaField.getText().toString().trim();
                if (cfa.length() == 0 ){
                    Toast.makeText(MainActivity.this,"Please enter an amount to convert",Toast.LENGTH_SHORT).show();
                }else {
                    stringBuilder = new StringBuilder();
                    double cfaDouble = Double.parseDouble(cfa);
                    double dalasis = (cfaDouble * user_entered_rate) / 5000;

                    stringBuilder.append(cfa);
                    stringBuilder.append("CFA = D");
                    stringBuilder.append(dalasis);
                    resultTextView.setText(stringBuilder);
                }
                cfaField.setText("");
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemNo = item.getItemId();
        if (itemNo == R.id.changeRate){
            startActivity(new Intent(getApplicationContext(),ChangeRate.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
