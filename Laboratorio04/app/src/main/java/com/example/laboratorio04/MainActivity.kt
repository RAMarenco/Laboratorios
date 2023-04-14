package com.example.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var GuardarButton: Button
    private lateinit var NombreEditText: TextInputLayout
    private lateinit var CorreoEditText: TextInputLayout
    private lateinit var TelefonoEditText: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addSetListeners()
    }

    private fun addSetListeners() {
        GuardarButton.setOnClickListener {
            var name = NombreEditText.editText?.text.toString()
            var email = CorreoEditText.editText?.text.toString()
            var phone = TelefonoEditText.editText?.text.toString()

            val intent = Intent(this, SecondaryActivity::class.java)

            if (name != "" && email != "" && phone != "") {
                intent.putExtra("Name", name)
                intent.putExtra("Email", email)
                intent.putExtra("Phone", phone)

                startActivity(intent)
            }
        }
    }

    private fun bind() {
        GuardarButton = findViewById(R.id.Guardar_Action)
        NombreEditText = findViewById(R.id.Name_EditText)
        CorreoEditText = findViewById(R.id.Email_EditText)
        TelefonoEditText = findViewById(R.id.Phone_EditText)
    }
}