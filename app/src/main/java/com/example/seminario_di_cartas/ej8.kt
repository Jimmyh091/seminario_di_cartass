package com.example.seminario_di_cartas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ej8 : AppCompatActivity() {

    private lateinit var tiet : TextInputEditText

    private lateinit var texto : TextView

    private lateinit var botonAnadirDatos : Button
    private lateinit var botonPasarDatos : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej8)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tiet = findViewById(R.id.ej7_tiet)
        botonAnadirDatos = findViewById(R.id.ej7_b_aniadirDatos)
        botonPasarDatos = findViewById(R.id.ej7_b_pasarDatos)

        texto = findViewById(R.id.ej7_b_aniadirDatos_text)


        var lista : MutableList<String> = mutableListOf()

        botonAnadirDatos.setOnClickListener{
            lista.add(tiet.text.toString())
            texto.text = texto.text.toString() + tiet.text.toString()
            tiet.text!!.clear()
        }

        botonPasarDatos.setOnClickListener {
            var intento = Intent(this, ej8Objetivo::class.java)
            intento.putExtra("lista", lista.toString().replace("[", "").replace("]", ""))

            startActivity(intento)
        }
    }
}