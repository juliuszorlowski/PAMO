package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.tipper.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText; // for bill amount input
import android.widget.SeekBar; // for changing the tip percentage
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text

import androidx.appcompat.app.AppCompatActivity;


import java.text.NumberFormat; // for currency formatting
import java.util.Locale;

// BMI Calculator
// Author: Juliusz Orłowski s19799 11c

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

//    // weight and height formatter objects
//    private static final NumberFormat numberFormat =
//            NumberFormat.getInstance(Locale.GERMAN);
//
//    private double weight = 0.0; // weight entered by the user
//    private double height = 0.0; // weight entered by the user
//    private TextView weightTextView; // shows entered weight
//    private TextView heightTextView; // shows entered height
//    private TextView bodyMassIndex; // shows calculated BMI

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_logo, R.id.navigation_bmi, R.id.navigation_calories, R.id.navigation_recipes)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

//        setContentView(R.layout.activity_main); // inflate the GUI

//        // get references to programmatically manipulated TextViews
//        weightTextView = (TextView) findViewById(R.id.weightTextView);
//        heightTextView = (TextView) findViewById(R.id.heightTextView);
//        bodyMassIndex = (TextView) findViewById(R.id.bmiTextView);
//        bodyMassIndex.setText(numberFormat.format(0));
//
//        // set amountEditText's TextWatcher
//        EditText weightEditText =
//                (EditText) findViewById(R.id.weightEditText);
//        weightEditText.addTextChangedListener(weightEditTextWatcher);
//
//        EditText heightEditText =
//                (EditText) findViewById(R.id.heightEditText);
//        heightEditText.addTextChangedListener(heightEditTextWatcher);

    }

    // calculate and display BMI amounts
//    private void calculate() {
//        // format height and display in heightTextView
//        heightTextView.setText(numberFormat.format(height));
//
//        // calculate BMI
//        double total = weight / (height * height);
//
//        // display BMI
//        bodyMassIndex.setText(numberFormat.format(total));
//    }
//
//    // listener object for the EditText's text-changed events
//    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
//        // called when the user modifies the weight
//        @Override
//        public void onTextChanged(CharSequence s, int start,
//                                  int before, int count) {
//
//            try { // get weight and display formatted value
//                weight = Double.parseDouble(s.toString()) / 100.0;
//                weightTextView.setText(numberFormat.format(weight));
//            }
//            catch (NumberFormatException e) { // if s is empty or non-numeric
//                weightTextView.setText("");
//                weight = 0.0;
//            }
//
//            calculate(); // update the tip and total TextViews
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) { }
//
//        @Override
//        public void beforeTextChanged(
//                CharSequence s, int start, int count, int after) { }
//    };
//
//    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
//        // called when the user modifies the height
//        @Override
//        public void onTextChanged(CharSequence s, int start,
//                                  int before, int count) {
//
//            try { // get height and display formatted value
//                height = Double.parseDouble(s.toString()) / 100.0;
//                heightTextView.setText(numberFormat.format(height));
//            }
//            catch (NumberFormatException e) { // if s is empty or non-numeric
//                heightTextView.setText("");
//                height = 0.0;
//            }
//
//            calculate(); // update the tip and total TextViews
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) { }
//
//        @Override
//        public void beforeTextChanged(
//                CharSequence s, int start, int count, int after) { }
//    };
}


/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
