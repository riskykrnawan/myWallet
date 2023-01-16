package com.mywallet.mywallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Register3Activity : AppCompatActivity() {
    private lateinit var registerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register3)

        registerButton = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            val i = Intent(this@Register3Activity, RegisterSuccessActivity::class.java)
            startActivity(i)
            finishAffinity()
        }
    }
}