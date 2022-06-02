package com.example.tipper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tipper.databinding.FragmentBmiBinding;
import com.example.tipper.databinding.FragmentCaloriesBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class CaloriesFragment extends Fragment {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentCaloriesBinding binding;

    // weight and height formatter objects
    private static final NumberFormat numberFormat =
            NumberFormat.getInstance(Locale.GERMAN);

    private double weight = 0.0; // weight entered by the user
    private double height = 0.0; // weight entered by the user
    private double age = 0.0;
    private TextView weightTextView; // shows entered weight
    private TextView heightTextView; // shows entered height
    private TextView ageTextView;
    private TextView caloriesIndex; // shows calculated BMI

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCaloriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // get references to programmatically manipulated TextViews
        weightTextView = (TextView) root.findViewById(R.id.weightTextView);
        heightTextView = (TextView) root.findViewById(R.id.heightTextView);
        ageTextView = (TextView) root.findViewById(R.id.ageTextView);
        caloriesIndex = (TextView) root.findViewById(R.id.caloriesTextView);
        caloriesIndex.setText(numberFormat.format(0));

        // set amountEditText's TextWatcher
        EditText weightEditText =
                (EditText) root.findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        EditText heightEditText =
                (EditText) root.findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        EditText ageEditText =
                (EditText) root.findViewById(R.id.ageEditText);
        ageEditText.addTextChangedListener(ageEditTextWatcher);

        return root;
    }

    // calculate and display BMI amounts
    private void calculate() {
        // format height and display in heightTextView
        heightTextView.setText(numberFormat.format(height));

        // calculate BMI
        double total = 66.47 + ( 13.7 * weight ) + ( 5.0 * height ) - ( 6.76 * age );

        // display BMI
        caloriesIndex.setText(numberFormat.format(total));
    }

    // listener object for the EditText's text-changed events
    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        // called when the user modifies the weight
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get weight and display formatted value
                weight = Double.parseDouble(s.toString()) / 100.0;
                weightTextView.setText(numberFormat.format(weight));
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                weightTextView.setText("");
                weight = 0.0;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        // called when the user modifies the height
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get height and display formatted value
                height = Double.parseDouble(s.toString()) / 100.0;
                heightTextView.setText(numberFormat.format(height));
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                heightTextView.setText("");
                height = 0.0;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher ageEditTextWatcher = new TextWatcher() {
        // called when the user modifies the height
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get height and display formatted value
                age = Double.parseDouble(s.toString()) / 100.0;
                ageTextView.setText(numberFormat.format(age));
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                ageTextView.setText("");
                age = 0.0;
            }

            calculate(); // update the tip and total TextViews
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };
}