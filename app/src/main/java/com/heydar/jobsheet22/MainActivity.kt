package com.heydar.jobsheet22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var loginbtn: Button
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var sessionManager: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = Session(this)

        loginbtn = findViewById(R.id.login)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        if(sessionManager.isLoggedIn()) {
            intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginbtn.setOnClickListener{
            val session = sessionManager.validate(username.text.toString(), password.text.toString())
            if (session) {
                intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this,"Username dan password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}