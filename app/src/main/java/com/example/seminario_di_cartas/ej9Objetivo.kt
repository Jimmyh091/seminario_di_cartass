package com.example.seminario_di_cartas

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ej9Objetivo : AppCompatActivity() {

    private lateinit var nombre : TextView
    private lateinit var bandera : ImageView
    private lateinit var habitantes : TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.v("sdklafjh", "sfadlkj")

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej9_objetivo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nombre = findViewById(R.id.ejPaisObjetivo_nombre)
        bandera = findViewById(R.id.ejPaisObjetivo_bandera)
        habitantes = findViewById(R.id.ejPaisObjetivo_habitantes)

        var pais = intent.getParcelableExtra<Pais>("pais")!!

        nombre.text = pais.nombre
        bandera.setImageResource(pais.bandera)
        habitantes.text = habitantes.text.toString() + pais.habitantes
    }
}