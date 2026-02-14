package com.example.splitie

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //edit user
        val imgUserProfile = findViewById<ImageView>(R.id.imgUserProfile)
        imgUserProfile.setOnClickListener {
            val intent = Intent(this, EditUser::class.java)
            startActivity(intent)
        }

        //noti
        val btnNotification = findViewById<ImageView>(R.id.btnNotification)
        btnNotification.setOnClickListener {
            val intent = Intent(this, notification::class.java)
            startActivity(intent)
        }
        //เหลือหน้า logout

        // friend
        val tvSeeMoreFriend = findViewById<TextView>(R.id.tvFriendLabel)
        tvSeeMoreFriend.setOnClickListener {
            val intent = Intent(this, Friend_list::class.java)
            startActivity(intent)
        }
        // group
        val tvSeeMoreGroup = findViewById<TextView>(R.id.tvGroupLabel)
        tvSeeMoreGroup.setOnClickListener {
            val intent = Intent(this, Group_list::class.java)
            startActivity(intent)
        }


        //3 functions low
        val btnSplitBill = findViewById<LinearLayout>(R.id.btnSplitBill)
        val btnRecentBill = findViewById<LinearLayout>(R.id.btnRecentBill)
        val btnOwe = findViewById<LinearLayout>(R.id.btnOwe)

        btnSplitBill.setOnClickListener {
            val intent = Intent(this, BillSplit::class.java)
            startActivity(intent)
        }

        btnRecentBill.setOnClickListener {
            val intent = Intent(this, RecentBill::class.java)
            startActivity(intent)
        }
        btnSplitBill.setOnClickListener {
            val intent = Intent(this, Owe::class.java)
            startActivity(intent)
        }

    }
}