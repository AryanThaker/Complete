package com.example.complete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var flage=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login.setOnClickListener {
            var username=txtuname.text.toString()
            var pss=txtpass.text.toString()
            if(TextUtils.isEmpty(username) || TextUtils.isEmpty(pss))
            {
                Toast.makeText(applicationContext,
                    "Please Enter UserName/Password",
                    Toast.LENGTH_LONG).show()
            }
            else{
                var db = DBHelper(this)
                var arr=db.retriveall()
                for (arr1 in arr) {
                    if (username.equals("${arr1.s_username}") && pss.equals("${arr1.s_password}")) {

                        var preference = getSharedPreferences("MyPref", MODE_PRIVATE)
                        var editor = preference.edit()
                        editor.putString("UserName", "")
                        editor.commit()
                        var intent = Intent(applicationContext, Welcome::class.java)
                        startActivity(intent)
                        finish()
                        flage=true
                        break

                    }


                }
                if (flage==false)
                {
                    Toast.makeText(this,"invalid username password",Toast.LENGTH_SHORT).show()
                }

            }
        }



        signup.setOnClickListener {
            var intant=Intent(this,Signup::class.java)
            startActivity(intant)
        }
        viewData.setOnClickListener {
            var intent = Intent(this,ViewAll::class.java)
            startActivity(intent)
        }

    }
}