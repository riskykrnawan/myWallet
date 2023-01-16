package com.mywallet.mywallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class Register1Activity : AppCompatActivity() {
    private lateinit var registerButton: Button
    private lateinit var signinText: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)

        registerButton = findViewById(R.id.registerButton)
        signinText = findViewById(R.id.signinText)

        registerButton.setOnClickListener {
            val i = Intent(this@Register1Activity, Register2Activity::class.java)
            startActivity(i)
        }

        signinText.setOnClickListener {
            val i = Intent(this@Register1Activity, LoginActivity::class.java)
            startActivity(i)
        }
    }
}