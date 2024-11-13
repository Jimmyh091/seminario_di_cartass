package com.example.seminario_di_cartas

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ej6Objetivo : AppCompatActivity() {

    private lateinit var tv1 : TextView
    private lateinit var tv2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej6_objetivo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tv1 = findViewById(R.id.ej6Objetivo_tv1)
        tv2 = findViewById(R.id.ej6Objetivo_tv2)

        tv1.text = "Numero recibido " + intent.getIntExtra("num", 0)
        tv2.text = "Texto recibido: " + intent.getStringExtra("input")
    }
}