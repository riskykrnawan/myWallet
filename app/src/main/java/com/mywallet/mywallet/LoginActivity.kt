package com.mywallet.mywallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var signupText: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signupText = findViewById(R.id.signupText)
        signupText.setOnClickListener {
            val i = Intent(this@LoginActivity, Register1Activity::class.java)
            startActivity(i)
        }
    }
}