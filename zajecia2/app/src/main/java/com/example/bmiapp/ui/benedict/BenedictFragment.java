package com.example.bmiapp.ui.benedict;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bmiapp.databinding.FragmentBenedictBinding;
import com.example.bmiapp.R;

import java.text.NumberFormat;

public class BenedictFragment extends Fragment {

    private FragmentBenedictBinding binding;
    private TextView bmiTextView;

    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();

    private EditText weightEditText;
    private EditText heightEditText;

    private EditText AgeEditText;

    private Switch genderSwitch;
    private Spinner spinnerActivity;
    private Button btnCalculate;

    private Boolean isWoman = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BenedictViewModel dashboardViewModel =
                new ViewModelProvider(this).get(BenedictViewModel.class);

        binding = FragmentBenedictBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bmiTextView = (TextView) getView().findViewById(R.id.bmiTextView);
        bmiTextView = (TextView) getView().findViewById(R.id.bmiTextView);

        heightEditText =
                (EditText) getView().findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(valueChangedTextWatcher);

        weightEditText =
                (EditText) getView().findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(valueChangedTextWatcher);

        AgeEditText = (EditText) getView().findViewById(R.id.AgeEditText);
        AgeEditText.addTextChangedListener(valueChangedTextWatcher);

        genderSwitch = (Switch) getView().findViewById(R.id.switchGender);
        genderSwitch.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isWoman = isChecked;
                calculate();
            }
        }));
        spinnerActivity = (Spinner) getView().findViewById(R.id.spinnerActivity);
        btnCalculate = (Button) getView().findViewById(R.id.btnCalculate);

        ArrayAdapter<CharSequence> adapterActivity = ArrayAdapter.createFromResource(this.getContext(),
                R.array.activity_array, android.R.layout.simple_spinner_item);
        adapterActivity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivity.setAdapter(adapterActivity);

        btnCalculate.setOnClickListener(v -> calculate());
    }

    private void calculate() {
        String heightString = heightEditText.getText().toString();
        String weightString = weightEditText.getText().toString();
        String ageString = AgeEditText.getText().toString();
        if (!heightString.isEmpty() && !weightString.isEmpty() && !ageString.isEmpty())
        {
            double height = Double.parseDouble(heightString);
            double weight = Double.parseDouble(weightString);
            int age = Integer.parseInt(ageString);
            double activityMultiplier;
            double bmi = 0;
            switch (spinnerActivity.getSelectedItem().toString()) {
                case "Niska aktywność":
                    activityMultiplier = 1.375;
                    break;
                case "Średnia aktywność":
                    activityMultiplier = 1.55;
                    break;
                case "Wysoka aktywność":
                    activityMultiplier = 1.725;
                    break;
                case "Bardzo wysoka aktywność":
                    activityMultiplier = 1.9;
                    break;
                default:
                    activityMultiplier = 1.2;
            }
            if (isWoman) {
                //                bmi = weight / Math.pow(height, 2);
                bmi = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
            }
            else {
                bmi = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
            }

            bmi = bmi * activityMultiplier;
            bmiTextView.setText(numberFormat.format(bmi));
        }
    }

    private final TextWatcher valueChangedTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
//            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}