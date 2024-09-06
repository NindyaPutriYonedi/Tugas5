package com.nindy.tes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Belanja : AppCompatActivity() {

    private lateinit var tvInput: EditText
    private lateinit var button: Button
    private lateinit var txtHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_belanja)

        tvInput = findViewById(R.id.tvInput)
        button = findViewById(R.id.button)
        txtHasil = findViewById(R.id.txtHasil)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button.setOnClickListener {
            val totalBelanja = tvInput.text.toString().toIntOrNull()

            if (totalBelanja != null) {
                val diskon = when {
                    totalBelanja > 1_000_000 -> totalBelanja * 0.30
                    totalBelanja in 500_000..1_000_000 -> totalBelanja * 0.20
                    totalBelanja in 100_000..500_000 -> totalBelanja * 0.10
                    else -> 0.0
                }

                val totalSetelahDiskon = totalBelanja - diskon
                val diskonText = if (diskon > 0) {
                    "Diskon anda sebesar Rp. %.2f".format(diskon)
                } else {
                    "Anda tidak mendapatkan diskon"
                }

                txtHasil.text = "$diskonText\nTotal setelah diskon: Rp. %.2f".format(totalSetelahDiskon)
            } else {
                Toast.makeText(this, "Input tidak valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
