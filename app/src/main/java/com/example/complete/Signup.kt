package com.example.complete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        save.setOnClickListener {
            var name=name.text.toString()
            var username=username.text.toString()
            var pass=password.text.toString()
            var email=email.text.toString()
            var no=phone.text.toString().toLong()
            var s1=register(name,username,pass,email,no)
            var db=DBHelper(this)
            var falg=db.insert(s1)
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
            if(falg)
            {
                Toast.makeText(this,"record inerted", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"record not inserted", Toast.LENGTH_LONG).show()
            }
        }
    }

}