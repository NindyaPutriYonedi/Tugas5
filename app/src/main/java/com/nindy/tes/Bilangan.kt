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

class Bilangan : AppCompatActivity() {

    private lateinit var inputNumber: EditText
    private lateinit var checkButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bilangan)

        inputNumber = findViewById(R.id.inputNumber)
        checkButton = findViewById(R.id.checkButton)
        resultTextView = findViewById(R.id.resultTextView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        checkButton.setOnClickListener {
            val numberInput = inputNumber.text.toString().toIntOrNull()
            // Mengecek apakah input valid atau tidak
            if (numberInput == null) {
                resultTextView.text = "Masukkan bilangan yang valid"
                return@setOnClickListener
            }

            // Mengecek apakah bilangan ganjil atau genap
            val result = if (numberInput % 2 == 0) {
                "Bilangan Genap"
            } else {
                "Bilangan Ganjil"
            }

            // Menampilkan hasil di TextView
            resultTextView.text = "Hasil: $result"
        }
    }
}
