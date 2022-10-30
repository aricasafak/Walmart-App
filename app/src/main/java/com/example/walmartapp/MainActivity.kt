package com.example.walmartapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var users: ArrayList<User> = arrayListOf(
        User("Safak", "Arica", "safakarica@gmail.com", "safakarica"),
        User("Zeynep", "Arica", "zeyneparica@gmail.com", "zeyneparica"),
        User("Eyup", "Birankar", "eyupbirankar@gmail.com", "eyupbirankar"),
        User("Cengizhan", "Dolak", "cengizhandolak@gmail.com", "cengizhandolak"),
        User("Shendra", "Meiners", "shendrameiners@gmail.com", "shendrameiners")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultCreateAccount = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val user = data?.getSerializableExtra("newUser") as User?
                if (user != null) {
                    users.add(user)
                    Toast.makeText(this, "New Account created for ${user.firstName} ${user.lastName}!", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "New Account cancelled", Toast.LENGTH_SHORT).show()
            }
        }

        createAccountBtn.setOnClickListener(){
            val createAccountIntent = Intent(this, CreateAccounActivity::class.java)
            resultCreateAccount.launch(createAccountIntent)
        }
    }

    fun signIn(view: View) {
        val userName = email.text.toString()
        val password = password.text.toString()

        if(userName == "" || password == "") {
            Toast.makeText(this, "Username and Password are required!", Toast.LENGTH_LONG).show();
            return;
        }

        val user = users.find { it.userName == userName && it.password == password }

        if(user != null){
            val shoppingCategoryIntent = Intent(this, ShoppingCategoryActivity::class.java)
            shoppingCategoryIntent.putExtra("email", user.userName)
            startActivity(shoppingCategoryIntent)
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }
}