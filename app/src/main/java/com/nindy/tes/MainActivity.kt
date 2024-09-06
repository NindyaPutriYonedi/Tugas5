package com.nindy.tes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnSuhu:Button
    private lateinit var btnDiskon : Button
    private lateinit var btnBalok: Button
    private lateinit var btnBilangan :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnSuhu = findViewById<Button>(R.id.btnSuhu)
        val btnDiskon = findViewById<Button>(R.id.btnDiskon)
        val btnBalok = findViewById<Button>(R.id.btnBalok)
        val btnBilangan = findViewById<Button>(R.id.btnBilangan)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnSuhu.setOnClickListener(){
            Toast.makeText(this,"Menghitung Suhu" , Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Suhu::class.java)
            startActivity(intent)
        }
        btnDiskon.setOnClickListener(){
            Toast.makeText(this,"Menghitung Belanja"  , Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Belanja::class.java)
            startActivity(intent)
        }
        btnBalok.setOnClickListener(){
            Toast.makeText(this,"Menghitung Bangun Ruang" , Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Balok::class.java)
            startActivity(intent)
        }
        btnBilangan.setOnClickListener(){
            Toast.makeText(this,"Menentukan Bilangan Ganjil atau genap" , Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Bilangan::class.java)
            startActivity(intent)
        }

    }
}