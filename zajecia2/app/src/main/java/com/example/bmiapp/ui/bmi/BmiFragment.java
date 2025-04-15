package com.example.bmiapp.ui.bmi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.bmiapp.R;
import androidx.annotation.Nullable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bmiapp.databinding.FragmentBmiBinding;

import java.text.DecimalFormat;

public class BmiFragment extends Fragment {

    private FragmentBmiBinding binding;
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
        BmiViewModel homeViewModel =
                new ViewModelProvider(this).get(BmiViewModel.class);

        binding = FragmentBmiBinding.inflate(inflater, container, false);
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
                calculateBMI(heightValue, weightValue);
                bmiTextValue.setText("BMI: " + df.format(bmiValue));
                bmiTextStatus.setText(bmiStatus);
            }
        });
    }
    public String calculateBMI(double weight, double height) {
        bmiValue = (weight / Math.pow(height, 2));
        if(bmiValue < 18.5) {
            bmiStatus = "NIEDOWAGA";
        } else if (bmiValue >= 18.5 & bmiValue < 24.99) {
            bmiStatus = "optimum";
        } else if (bmiValue >= 25 & bmiValue < 29.99) {
            bmiStatus = "NADWAGA";
        } else if (bmiValue >= 30) {
            bmiStatus = "OTYŁOŚĆ";
        }
        return bmiStatus;
    }
}