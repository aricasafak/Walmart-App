package com.example.walmartapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_accoun.*
import kotlinx.android.synthetic.main.activity_main.*

class CreateAccounActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_accoun)

        createAccount.setOnClickListener() {
            val firstName = personName.text.toString()
            val lastName = personLastName.text.toString()
            val email = personEmail.text.toString()
            val password = personPassword.text.toString()

            if(firstName == "" || lastName == "" || email == "" || password == "") {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()
            } else {
                val newUser = User(firstName, lastName, email, password);
                val intent = intent
                intent.putExtra("newUser", newUser)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}