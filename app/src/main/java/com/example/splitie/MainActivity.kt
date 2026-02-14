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
    var imgUserProfile: ImageView? = null
    var btnNotification: ImageView? = null
    var tvSeeMoreFriend: TextView? = null
    var tvSeeMoreGroup: TextView? = null
    var btnSplitBill: LinearLayout? = null
    var btnRecentBill: LinearLayout? = null
    var btnOwe: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
        imgUserProfile!!.setOnClickListener {
            val intent = Intent(this, EditUser::class.java)
            startActivity(intent)
        }
        btnNotification!!.setOnClickListener {
            val intent = Intent(this, notification::class.java)
            startActivity(intent)
        }
        tvSeeMoreFriend!!.setOnClickListener {
            val intent = Intent(this, Friend_list::class.java)
            startActivity(intent)
        }

        tvSeeMoreGroup!!.setOnClickListener {
            val intent = Intent(this, Group_list::class.java)
            startActivity(intent)
        }
        btnSplitBill!!.setOnClickListener {
            val intent = Intent(this, BillSplit::class.java)
            startActivity(intent)
        }

        btnRecentBill!!.setOnClickListener {
            val intent = Intent(this, RecentBill::class.java)
            startActivity(intent)
        }

        btnOwe!!.setOnClickListener {
            val intent = Intent(this, Owe::class.java)
            startActivity(intent)
        }
    }
    private fun init() {
        imgUserProfile = findViewById(R.id.imgUserProfile)
        btnNotification = findViewById(R.id.btnNotification)

        tvSeeMoreFriend = findViewById(R.id.tvFriendLabel)
        tvSeeMoreGroup = findViewById(R.id.tvGroupLabel)

        btnSplitBill = findViewById(R.id.btnSplitBill)
        btnRecentBill = findViewById(R.id.btnRecentBill)
        btnOwe = findViewById(R.id.btnOwe)
    }
}