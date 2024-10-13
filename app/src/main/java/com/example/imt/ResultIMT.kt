package com.example.imt

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultIMT : AppCompatActivity() {

    private lateinit var typeImtTV: TextView
    private lateinit var imageImtIMG: ImageView
    private lateinit var recommendationTV: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imt)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        typeImtTV = findViewById(R.id.typeImtTV)
        imageImtIMG = findViewById(R.id.imageImtIMG)
        recommendationTV = findViewById(R.id.recommendationTV)

        val imt = intent.getStringExtra("data")?.toDouble()
        when {
            imt!! < 18.5 -> {
                typeImtTV.text = TextFile().textTypeLow
                imageImtIMG.setImageResource(R.drawable.low_imt)
                recommendationTV.text = TextFile().textLow
            }
            imt in 18.5..24.9 -> {
                typeImtTV.text = TextFile().textTypeNorm
                imageImtIMG.setImageResource(R.drawable.norm_imt)
                recommendationTV.text = TextFile().textNorm
            }
            imt in 25.0..29.9 -> {
                typeImtTV.text = TextFile().textTypeHigh
                imageImtIMG.setImageResource(R.drawable.high_imt)
                recommendationTV.text = TextFile().textHigh
            }
            else -> {
                typeImtTV.text = TextFile().textTypeVHigh
                imageImtIMG.setImageResource(R.drawable.v_high_imt)
                recommendationTV.text = TextFile().textVHigh
            }
        }
    }
}