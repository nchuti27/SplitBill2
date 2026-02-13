package com.example.splitie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    var btnLogin: Button? = null
    var edt_Luser : EditText? = null
    var edt_Lpass : EditText? = null
    var jointxt : TextView? = null
    var forgotP : TextView? = null
    /*Login
    title_txt *
    user_pt*
    pass_pt*
    forgot_txt
    login_btn *
    join_txt*/
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnLogin!!.setOnClickListener {
            var uUsername = edt_Luser!!.text
            var uPass = edt_Lpass!!.text
            if(uUsername.isEmpty()){
                Toast.makeText(this,"Please input your username",Toast.LENGTH_LONG).show()
            }else if (uPass.isEmpty()){
                Toast.makeText(this,"Please input you Password",Toast.LENGTH_LONG).show()
            }else {
                forgotP!!.text = "Hello " + uUsername
                Toast.makeText(this,"Welcome + uUername",Toast.LENGTH_LONG).show()

            }

        }
        jointxt?.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        forgotP?.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)

        }
    }
    private fun init(){
        btnLogin = findViewById(R.id.login_btn)
        edt_Lpass = findViewById(R.id.pass_pt)
        edt_Luser = findViewById(R.id.user_pt)
        forgotP = findViewById(R.id.forgot_txt)
        jointxt = findViewById(R.id.join_txt)
    }
}