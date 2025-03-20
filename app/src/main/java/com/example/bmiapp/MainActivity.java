package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double heightValue = 0.0;
    private double weightValue = 0.0;
    private double bmiValue = 0.0;

    private EditText haightInput;
    private EditText weightInput;
    private Button calculateButton;
    private TextView bmiTextValue;
    DecimalFormat df = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        haightInput = (EditText) findViewById(R.id.haightInput);
        weightInput = (EditText) findViewById(R.id.weightInput);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        bmiTextValue = (TextView) findViewById(R.id.bmiValue);

            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    heightValue = Double.parseDouble(haightInput.getText().toString());
                    weightValue = Double.parseDouble(weightInput.getText().toString());
                    calculateBMI();
                    bmiTextValue.setText("BMI: " + df.format(bmiValue));
                }
            });
    }
    private void calculateBMI() {
        bmiValue = (weightValue / Math.pow(heightValue, 2));
    }
}