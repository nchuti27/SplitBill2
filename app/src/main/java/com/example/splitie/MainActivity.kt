package com.example.splitie

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

    var btnLogout: ImageView? = null

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
        btnLogout!!.setOnClickListener {
            showLogoutDialog() // เรียกใช้ฟังก์ชันแสดง Popup
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
        btnLogout = findViewById(R.id.btnLogout)
    }
    private fun showLogoutDialog() {
        // 1. โหลดไฟล์ XML ของ Popup (dialog_logout.xml)
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_logout, null)

        // 2. สร้าง Dialog
        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        val dialog = builder.create()

        // 3. ทำให้พื้นหลังใส (เพื่อให้เห็นขอบโค้งของ CardView)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // 4. เชื่อมต่อปุ่มภายใน Popup
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)
        val btnConfirm = view.findViewById<Button>(R.id.btnConfirm)

        // 5. ปุ่ม No
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        // 6. ปุ่ม Yes
        btnConfirm.setOnClickListener {
            dialog.dismiss() // ปิด Popup
            Toast.makeText(this, "Logged Out Successfully", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, login::class.java)
            // เคลียร์หน้าเก่าทิ้งให้หมด (กด Back ไม่ได้)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
        // 7. แสดง Popup
        dialog.show()
    }
}