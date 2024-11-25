package com.herdialfachri.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val recyclerView = findViewById<RecyclerView>(R.id.rvProduk)

        // Set GridLayoutManager dengan jumlah kolom 2
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Tambahkan OnClickListener untuk TextView dengan ID tvFavicon
        val tvFavicon: TextView = findViewById(R.id.tvFavicon)
        tvFavicon.setOnClickListener {
            val intent = Intent(this@MainActivity, ProductActivity::class.java)
            startActivity(intent)
        }
    }
}
