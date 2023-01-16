package com.mywallet.mywallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Register2Activity : AppCompatActivity() {
    private lateinit var registerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        registerButton = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            val i = Intent(this@Register2Activity, Register3Activity::class.java)
            startActivity(i)
        }
    }
}