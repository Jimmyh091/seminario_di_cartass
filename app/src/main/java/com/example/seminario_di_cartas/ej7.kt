package com.example.seminario_di_cartas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ej7 : AppCompatActivity() {

    private lateinit var tiet : TextInputEditText
    private lateinit var botonPasarDatos : Button

    private lateinit var texto1 : TextView
    private var num = (1..10).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v("hola","sajfldask")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej7)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.v("asjdfkl", "jlasdk")
        texto1 = findViewById<TextView>(R.id.ej6_tv)
        texto1.text = "Numero que vamos a pasar: $num"

        tiet = findViewById<TextInputEditText>(R.id.ej6_tiet)
        botonPasarDatos = findViewById<Button>(R.id.ej6_b)

        botonPasarDatos.setOnClickListener {
            var intent = Intent(this, ej7Objetivo::class.java)
            intent.putExtra("num", num)
            intent.putExtra("input", tiet.text.toString())
            startActivity(intent)
        }
        Log.v("asjdfkl", "jlassadfasdfasdfasdfasdfdk")
    }
}