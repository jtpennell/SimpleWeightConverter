package com.example.simpleweightconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Switch aswitch;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aswitch = (Switch) findViewById(R.id.switch1); // switch to toggle between metric and imperial system
        button = (Button) findViewById(R.id.button); // convert button

        aswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked == true){
                    Toast.makeText(getBaseContext(),"Imperial",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getBaseContext(),"Metric", Toast.LENGTH_SHORT).show();

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                TextView textView = (TextView) findViewById(R.id.textView);
                double valueInput = Float.parseFloat(editText.getText().toString());
                double weight = 0;

                if (aswitch.isChecked() == true){ // convert lb to kg
                    weight = valueInput / 2.20462;
                    weight = Math.round(weight * 100) / 100.00; // rounding the value to two decimal places
                    String result = Double.toString(weight);
                    textView.setText(result + " kg");

                } else {
                    weight = valueInput * 2.20462; // convert kg to lb
                    weight = Math.round(weight * 100) / 100.00; // rounding the value to two decimal places
                    String result = Double.toString(weight);
                    textView.setText(result + " lb");
                }

            }
        });




    }
}
