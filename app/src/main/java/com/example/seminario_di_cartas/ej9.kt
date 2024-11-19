package com.example.seminario_di_cartas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ej9 : AppCompatActivity() {

    private lateinit var botonEsp : Button
    private lateinit var botonFra : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej9)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        botonEsp = findViewById(R.id.ejPais_Esp)
        botonFra = findViewById(R.id.ejPais_Fra)

        var intent = Intent(this, ej9Objetivo::class.java)

        botonEsp.setOnClickListener{
            var esp = Pais("España", R.drawable.bandera_espana, 42000000)
            intent.putExtra("pais", esp)
            startActivity(intent)
        }

        botonFra.setOnClickListener {
            var fra = Pais("Francia", R.drawable.bandera_francia, 68000000)
            intent.putExtra("pais", fra)
            startActivity(intent)
        }
    }
}