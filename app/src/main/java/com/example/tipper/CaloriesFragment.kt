package com.example.tipper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.tipper.databinding.FragmentCaloriesBinding
import java.text.NumberFormat
import java.util.Locale

class CaloriesFragment : Fragment() {

    private lateinit var binding: FragmentCaloriesBinding

    // weight and height formatter objects
    private val numberFormat: NumberFormat =
        NumberFormat.getInstance(Locale.GERMAN)

    private var weight: Double = 0.0 // weight entered by the user
    private var height: Double = 0.0 // weight entered by the user
    private var age: Double = 0.0 // weight entered by the user
    private var weightTextView: TextView? = null // shows entered weight
    private var heightTextView: TextView? = null // shows entered height
    private var ageTextView: TextView? = null
    private var caloriesIndex: TextView? = null // shows calculated BMI

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                             savedInstanceState: Bundle?): View {

        binding = FragmentCaloriesBinding.inflate(layoutInflater)
        val root: View = binding.root

        // get references to programmatically manipulated TextViews
        weightTextView = root.findViewById(R.id.weightTextView) as TextView
        heightTextView = root.findViewById(R.id.heightTextView) as TextView
        ageTextView = root.findViewById(R.id.ageTextView) as TextView
        caloriesIndex = root.findViewById(R.id.caloriesTextView) as TextView
        caloriesIndex!!.text = numberFormat.format(0)

        // set amountEditText's TextWatcher
        val weightEditText = root.findViewById(R.id.weightEditText) as EditText
        weightEditText.addTextChangedListener(weightEditTextWatcher)

        val heightEditText = root.findViewById(R.id.heightEditText) as EditText
        heightEditText.addTextChangedListener(heightEditTextWatcher)

        val ageEditText = root.findViewById(R.id.ageEditText) as EditText
        ageEditText.addTextChangedListener(ageEditTextWatcher)

        return root
    }

    // calculate and display BMI amounts
    private fun calculate() {
        // format height and display in heightTextView
        heightTextView!!.text = numberFormat.format(height)

        // calculate BMI
        val total: Double = 66.47 + ( 13.7 * weight ) + ( 5.0 * height ) - ( 6.76 * age )

        // display BMI
        caloriesIndex!!.text = numberFormat.format(total)
    }

    // listener object for the EditText's text-changed events
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the weight
        override fun onTextChanged(s: CharSequence, start: Int,
                                  before: Int, count: Int) {

            try { // get weight and display formatted value
                weight = s.toString().toDouble() / 100.0
                weightTextView!!.text = numberFormat.format(weight)
            }
            catch (e: NumberFormatException) { // if s is empty or non-numeric
                weightTextView!!.text = ""
                weight = 0.0
            }

            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) { }

        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int) { }
    }

    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the height
        override fun onTextChanged(s: CharSequence, start: Int,
                                  before: Int, count: Int) {

            try { // get height and display formatted value
                height = s.toString().toDouble() / 100.0
                heightTextView!!.text = numberFormat.format(height)
            }
            catch (e: NumberFormatException) { // if s is empty or non-numeric
                heightTextView!!.text = ""
                height = 0.0
            }

            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) { }

        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int) { }
    }

    private val ageEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the height
        override fun onTextChanged(s: CharSequence, start: Int,
                                  before: Int, count: Int) {

            try { // get height and display formatted value
                age = s.toString().toDouble() / 100.0
                ageTextView!!.text = numberFormat.format(age)
            }
            catch (e: NumberFormatException) { // if s is empty or non-numeric
                ageTextView!!.text = ""
                age = 0.0
            }

            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) { }

        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int) { }
    }
}