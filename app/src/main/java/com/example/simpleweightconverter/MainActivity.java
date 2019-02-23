package com.example.simpleweightconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start Button on click listener
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                TextView textView = (TextView) findViewById(R.id.textView);
                double d = Float.parseFloat(editText.getText().toString());
                double weightLb = d * 2.20462;
                weightLb = Math.round(weightLb * 100) / 100.00; //rounding the value to two decimal places
                String result = Double.toString(weightLb);
                textView.setText(result + " lb");
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                TextView textView = (TextView) findViewById(R.id.textView);
                double d = Float.parseFloat(editText.getText().toString());
                double weightLb = d / 2.20462;
                weightLb = Math.round(weightLb * 100) / 100.00; //rounding the value to two decimal places
                String result = Double.toString(weightLb);
                textView.setText(result + " kg");
            }
        });

    }
}
