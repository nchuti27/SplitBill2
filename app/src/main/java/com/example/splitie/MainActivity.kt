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

        init()
    }
    private fun init() {
        // --- 1. Edit Profile (รูปโปรไฟล์) ---
        val imgUserProfile = findViewById<ImageView>(R.id.imgUserProfile)
        imgUserProfile.setOnClickListener {
            val intent = Intent(this, EditUser::class.java)
            startActivity(intent)
        }

        // --- 2. Notification (กระดิ่งแจ้งเตือน) ---
        val btnNotification = findViewById<ImageView>(R.id.btnNotification)
        btnNotification.setOnClickListener {
            val intent = Intent(this, notification::class.java) // เช็กชื่อไฟล์ Class ให้ตรง (ตัวเล็ก/ใหญ่)
            startActivity(intent)
        }

        // --- 3. Friends List ---
        // (แนะนำให้ใช้ tvSeeMoreFriend ถ้าอยากให้กดที่คำว่า See More)
        val tvSeeMoreFriend = findViewById<TextView>(R.id.tvFriendLabel) // หรือแก้เป็น R.id.tvSeeMoreFriend
        tvSeeMoreFriend.setOnClickListener {
            val intent = Intent(this, Friend_list::class.java)
            startActivity(intent)
        }

        // --- 4. Group List ---
        // (แนะนำให้ใช้ tvSeeMoreGroup ถ้าอยากให้กดที่คำว่า See More)
        val tvSeeMoreGroup = findViewById<TextView>(R.id.tvGroupLabel) // หรือแก้เป็น R.id.tvSeeMoreGroup
        tvSeeMoreGroup.setOnClickListener {
            val intent = Intent(this, Group_list::class.java)
            startActivity(intent)
        }

        // --- 5. ปุ่มเมนูด้านล่าง (3 ปุ่ม) ---
        val btnSplitBill = findViewById<LinearLayout>(R.id.btnSplitBill)
        val btnRecentBill = findViewById<LinearLayout>(R.id.btnRecentBill)
        val btnOwe = findViewById<LinearLayout>(R.id.btnOwe)

        // ปุ่ม Split Bill
        btnSplitBill.setOnClickListener {
            val intent = Intent(this, BillSplit::class.java)
            startActivity(intent)
        }

        // ปุ่ม Recent Bill
        btnRecentBill.setOnClickListener {
            val intent = Intent(this, RecentBill::class.java)
            startActivity(intent)
        }

        // ปุ่ม Owe (แก้ไขบั๊กตรงนี้ให้แล้ว: เปลี่ยนจาก btnSplitBill เป็น btnOwe)
        btnOwe.setOnClickListener {
            val intent = Intent(this, Owe::class.java)
            startActivity(intent)
        }
    }
}