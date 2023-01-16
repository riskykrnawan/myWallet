package com.mywallet.mywallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterSuccessActivity : AppCompatActivity() {
    private lateinit var registerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_success)
        registerButton = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val i = Intent(this@RegisterSuccessActivity, MainActivity::class.java)
            startActivity(i)
            finishAffinity()
        }
    }
}