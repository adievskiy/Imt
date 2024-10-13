package com.example.imt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var weightET: EditText
    private lateinit var heightET: EditText
    private lateinit var calculateBTN: Button
    private lateinit var testTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        weightET = findViewById(R.id.weightET)
        heightET = findViewById(R.id.heightET)
        calculateBTN = findViewById(R.id.calculateBTN)
        testTV = findViewById(R.id.testTV)

        calculateBTN.setOnClickListener {
            val weightInput = weightET.text.toString().toDouble()
            val heightInput = heightET.text.toString().toDouble()
            if (weightET.text.isEmpty() || heightET.text.isEmpty()){
                Toast.makeText(this, "Пожалуйста, введите корректные числовые значения.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val imt = weightInput / ((heightInput/100) * (heightInput/100))
            val intent = Intent(this, ResultIMT::class.java)
            intent.putExtra("data", imt.toString())
            startActivity(intent)
        }
    }
}