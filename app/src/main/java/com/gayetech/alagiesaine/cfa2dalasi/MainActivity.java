package com.gayetech.alagiesaine.cfa2dalasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cfaField = (EditText) findViewById(R.id.cfaField);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        buttonConvert = (Button) findViewById(R.id.buttonConvert);
        stringBuilder = new StringBuilder();

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String cfa = cfaField.getText().toString().trim();
                if (cfa.length() == 0 ){
                    Toast.makeText(MainActivity.this,"Please enter an amount to convert",Toast.LENGTH_SHORT).show();
                }else {
                    stringBuilder = new StringBuilder();
                    double cfaDouble = Double.parseDouble(cfa);
                    double dalasis = (cfaDouble * 400) / 5000;

                    stringBuilder.append(cfa);
                    stringBuilder.append("CFA = D");
                    stringBuilder.append(dalasis);
                    resultTextView.setText(stringBuilder);
                }


                cfaField.setText("");
            }
        });
    }
}
