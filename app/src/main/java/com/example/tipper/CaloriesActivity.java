package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class CaloriesActivity extends AppCompatActivity {

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

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_main); // inflate the GUI

        // get references to programmatically manipulated TextViews
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
        caloriesIndex = (TextView) findViewById(R.id.caloriesTextView);
        caloriesIndex.setText(numberFormat.format(0));

        // set amountEditText's TextWatcher
        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        EditText ageEditText =
                (EditText) findViewById(R.id.ageEditText);
        heightEditText.addTextChangedListener(ageEditTextWatcher);

    }

    public void launchLogo(View v){
        Intent i = new Intent(this, LogoActivity.class);
        startActivity(i);
    }

    public void launchMain(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void launchCalories(View v){
        Intent i = new Intent(this, CaloriesActivity.class);
        startActivity(i);
    }

    public void launchRecipes(View v){
        Intent i = new Intent(this, RecipesActivity.class);
        startActivity(i);
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