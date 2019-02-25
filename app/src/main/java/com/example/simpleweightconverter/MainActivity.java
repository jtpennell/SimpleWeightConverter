package com.example.simpleweightconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
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
                TextView currentSystem = (TextView) findViewById(R.id.textView3);
                Toast toast;
                // displays whether the user is using the metric or imperial system of measuring
                if (isChecked == true){
                    toast = Toast.makeText(getBaseContext(),"Imperial",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100); // set the position of the error message to the middle of the screen
                    toast.show();
                    currentSystem.setText("Imperial to Metric");

                } else {
                    toast = Toast.makeText(getBaseContext(),"Metric",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100); // set the position of the error message to the middle of the screen
                    toast.show();
                    currentSystem.setText("Metric to Imperial");

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                TextView textView = (TextView) findViewById(R.id.textView);
                String valueInput = editText.getText().toString();
                double weight = 0;
                Toast errorMessage = Toast.makeText(getBaseContext(),"Please enter a value greater than zero", Toast.LENGTH_SHORT);
                errorMessage.setGravity(Gravity.CENTER_VERTICAL, 0, 100); // set the position of the error message to the middle of the screen

                if (TextUtils.isEmpty(valueInput)){ // displays an error message when input value is null
                    errorMessage.show();
                    return;

                } else { // parse the input value to a float
                    weight = Float.parseFloat(valueInput); //crash
                }

                if (weight <= 0) { // displays error message when input value is less than zero
                    errorMessage.show();
                    return;
                }

                if (aswitch.isChecked() == true){ // convert lb to kg
                    weight = weight / 2.20462;
                    weight = Math.round(weight * 100) / 100.00; // rounding the value to two decimal places
                    String result = Double.toString(weight);
                    textView.setText(result + " kg");

                } else {
                    weight = weight * 2.20462; // convert kg to lb
                    weight = Math.round(weight * 100) / 100.00; // rounding the value to two decimal places
                    String result = Double.toString(weight);
                    textView.setText(result + " lb");
                }

            }
        });




    }
}
