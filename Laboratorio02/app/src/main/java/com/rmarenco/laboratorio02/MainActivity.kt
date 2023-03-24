package com.rmarenco.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateBMIButton: Button
    private lateinit var bmiTextView: TextView
    private lateinit var weightClassTextView: TextView
    private lateinit var normalRangeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListener()
    }

    private fun addListener() {
        calculateBMIButton.setOnClickListener {
            var weight = weightEditText.text.toString()
            var height = heightEditText.text.toString()
            if (weight != "" && height != "") {
                var BMI = calculateBMI(weight.toDouble(), height.toDouble()/100)

                if (BMI < 18.5) {
                    weightClassTextView.text = "Under weight"
                    weightClassTextView.setTextColor(getResources().getColor(R.color.under_weight))
                } else if (BMI >= 18.5 && BMI <= 24.99) {
                    weightClassTextView.text = "Healthy"
                    weightClassTextView.setTextColor(getResources().getColor(R.color.normal_weight))
                } else if (BMI >= 25 && BMI <= 29.99) {
                    weightClassTextView.text = "Overweight"
                    weightClassTextView.setTextColor(getResources().getColor(R.color.over_weight))
                } else if (BMI > 30) {
                    weightClassTextView.text = "Obese"
                    weightClassTextView.setTextColor(getResources().getColor(R.color.obese))
                }
                bmiTextView.text = String.format("%.2f",BMI)
                normalRangeTextView.text = "(Normal range is 18.5 - 24.9)"
            }
        }
    }

    private fun calculateBMI(weight: Double, height: Double): Double =
        (weight / (height*height))

    private fun bind() {
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        calculateBMIButton = findViewById(R.id.calculate_bmi_button)
        bmiTextView = findViewById(R.id.bmi_text_view)
        weightClassTextView = findViewById(R.id.weight_class_text_view)
        normalRangeTextView = findViewById(R.id.normal_range_text_view)
    }
}