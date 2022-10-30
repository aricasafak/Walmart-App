package com.example.walmartapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        var intent = intent
        var email = intent.getStringExtra("email")
        userNameText.text = email;

        electronicsCard.setOnClickListener {
            Toast.makeText(this,"You have chosen the Electronics category of shopping!", Toast.LENGTH_SHORT).show()
        }
        beautyCard.setOnClickListener {
            Toast.makeText(this,"You have chosen the Beauty category of shopping!", Toast.LENGTH_SHORT).show()
        }
        clothingCard.setOnClickListener {
            Toast.makeText(this,"You have chosen the Clothings category of shopping!", Toast.LENGTH_SHORT).show()
        }
        foodCard.setOnClickListener {
            Toast.makeText(this,"You have chosen the Food category of shopping!", Toast.LENGTH_SHORT).show()
        }
    }
}