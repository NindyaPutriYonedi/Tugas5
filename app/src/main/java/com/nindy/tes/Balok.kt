package com.nindy.tes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Balok : AppCompatActivity() {
    private lateinit var txtP: EditText
    private lateinit var txtL: EditText
    private lateinit var txtT: EditText
    private lateinit var btnLuas: Button
    private lateinit var btnV: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_balok)

        txtP = findViewById(R.id.txtP)
        txtL = findViewById(R.id.txtL)
        txtT = findViewById(R.id.txtT)
        btnLuas = findViewById(R.id.btnLuas)
        btnV = findViewById(R.id.btnV)
        textViewResult = findViewById(R.id.textViewResult)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnLuas.setOnClickListener {
            val p = txtP.text.toString().toDoubleOrNull()
            val l = txtL.text.toString().toDoubleOrNull()
            val t = txtT.text.toString().toDoubleOrNull()

            if (p != null && l != null && t != null) {
                val luasPermukaan = 2 * (p * l + p * t + l * t)
                textViewResult.text = "Luas Permukaan: $luasPermukaan"
            } else {
                textViewResult.text = "Masukkan nilai yang valid"
            }
        }
        btnV.setOnClickListener {
            val p = txtP.text.toString().toDoubleOrNull()
            val l = txtL.text.toString().toDoubleOrNull()
            val t = txtT.text.toString().toDoubleOrNull()

            if (p != null && l != null && t != null) {
                val volume = p * l * t
                textViewResult.text = "Volume: $volume"
            } else {
                textViewResult.text = "Masukkan nilai yang valid"
            }
        }
    }
}