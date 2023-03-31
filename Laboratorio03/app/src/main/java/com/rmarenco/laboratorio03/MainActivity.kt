package com.rmarenco.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var money: TextView
    private lateinit var fiveCents: ImageView
    private lateinit var tenCents: ImageView
    private lateinit var twentyFiveCents: ImageView
    private lateinit var dollar: ImageView

    private var moneyValue:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListener()
    }

    private fun addListener() {
        fiveCents.setOnClickListener {
            moneyValue += 0.05
            money.text = String.format("%.2f",moneyValue)
        }
        tenCents.setOnClickListener {
            moneyValue += 0.10
            money.text = String.format("%.2f",moneyValue)
        }
        twentyFiveCents.setOnClickListener {
            moneyValue += 0.25
            money.text = String.format("%.2f",moneyValue)
        }
        dollar.setOnClickListener {
            moneyValue += 1
            money.text = String.format("%.2f",moneyValue)
        }
    }

    private fun bind() {
        money = findViewById(R.id.money_textView)
        fiveCents = findViewById(R.id.fiveCents_imageView)
        tenCents = findViewById(R.id.tenCents_imageView)
        twentyFiveCents = findViewById(R.id.twentyFiveCents_imageView)
        dollar = findViewById(R.id.dollar_imageView)

    }
}