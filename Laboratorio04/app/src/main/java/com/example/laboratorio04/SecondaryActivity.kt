package com.example.laboratorio04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondaryActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var phone: String
    private lateinit var nameValue: TextView
    private lateinit var emailValue: TextView
    private lateinit var phoneValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        bind()
        getIntentData()
        setIntentData()
    }

    private fun getIntentData() {
        name = intent.getStringExtra("Name").toString()
        email = intent.getStringExtra("Email").toString()
        phone = intent.getStringExtra("Phone").toString()
    }

    private fun setIntentData() {
        nameValue.text = name
        emailValue.text = email
        phoneValue.text = phone
    }

    private fun bind() {
        nameValue = findViewById(R.id.nameValue_TextView)
        emailValue = findViewById(R.id.emailValue_TextView)
        phoneValue = findViewById(R.id.phoneValue_TextView)
    }
}