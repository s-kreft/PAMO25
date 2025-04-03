package com.example.bmiapp.ui.bmi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.bmiapp.databinding.ActivityBmiBinding;
import com.example.bmiapp.R;


import java.text.DecimalFormat;

public class BMIFragment extends Fragment {

    private ActivityBmiBinding binding;
    private double heightValue = 0.0;
    private double weightValue = 0.0;
    private double bmiValue = 0.0;
    private String bmiStatus = "";

    private EditText haightInput;
    private EditText weightInput;
    private Button calculateButton;
    private TextView bmiTextValue;
    private TextView bmiTextStatus;
    DecimalFormat df = new DecimalFormat("#.##");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BMIViewModel homeViewModel =
                new ViewModelProvider(this).get(BMIViewModel.class);

        binding = ActivityBmiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        haightInput = (EditText) getView().findViewById(R.id.haightInput);
        weightInput = (EditText) getView().findViewById(R.id.weightInput);
        calculateButton = (Button) getView().findViewById(R.id.calculateButton);
        bmiTextValue = (TextView) getView().findViewById(R.id.bmiValue);
        bmiTextStatus = (TextView) getView().findViewById(R.id.bmiStatus);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heightValue = Double.parseDouble(haightInput.getText().toString());
                weightValue = Double.parseDouble(weightInput.getText().toString());
                calculateBMI();
                bmiTextValue.setText("BMI: " + df.format(bmiValue));
                bmiTextStatus.setText(bmiStatus);
            }
        });
    }
    private void calculateBMI() {
        bmiValue = (weightValue / Math.pow(heightValue, 2));
        if(bmiValue < 18.5) {
            bmiStatus = "NIEDOWAGA";
        } else if (bmiValue >= 18.5 & bmiValue < 24.99) {
            bmiStatus = "optimum";
        } else if (bmiValue >= 25 & bmiValue < 29.99) {
            bmiStatus = "NADWAGA";
        } else if (bmiValue >= 30) {
            bmiStatus = "OTYŁOŚĆ";
        }
    }
}