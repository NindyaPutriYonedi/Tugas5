package com.nindy.tes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Suhu : AppCompatActivity() {
    private lateinit var etNilai: EditText
    private lateinit var rbReamur: RadioButton
    private lateinit var rbKelvin: RadioButton
    private lateinit var rbFahrenheit: RadioButton
    private lateinit var btnKonversi: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suhu)

        // Sesuaikan dengan ID dari XML
        etNilai = findViewById(R.id.etNilai)
        rbReamur = findViewById(R.id.rbReamur)
        rbKelvin = findViewById(R.id.rbKelvin)
        rbFahrenheit = findViewById(R.id.rbFahrenheit)
        btnKonversi = findViewById(R.id.btnKonversi)
        tvHasil = findViewById(R.id.tvHasil)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Aksi pada button konversi
        btnKonversi.setOnClickListener {
            val celsius = etNilai.text.toString().toDoubleOrNull()

            if (celsius != null) {
                when {
                    rbFahrenheit.isChecked -> {
                        val hasil = (celsius * 9 / 5) + 32
                        tvHasil.text = "Hasil Konversinya = %.2f Fahrenheit".format(hasil)
                    }
                    rbKelvin.isChecked -> {
                        val hasil = celsius + 273.15
                        tvHasil.text = "Hasil Konversinya = %.2f Kelvin".format(hasil)
                    }
                    rbReamur.isChecked -> {
                        val hasil = celsius * 0.8
                        tvHasil.text = "Hasil Konversinya = %.2f Reamur".format(hasil)
                    }
                    else -> {
                        tvHasil.text = "Pilih skala suhu!"
                    }
                }
            } else {
                tvHasil.text = "Masukkan nilai yang valid!"
            }
        }
    }
}
