package com.example.seminario_di_cartas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ej5 : AppCompatActivity() {

    private lateinit var listaBotones : List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listaBotones = listOf(
            findViewById(R.id.ej5_b1),
            findViewById(R.id.ej5_b2),
            findViewById(R.id.ej5_b3),
            findViewById(R.id.ej5_b4),
            findViewById(R.id.ej5_b5),
            findViewById(R.id.ej5_b6),
            findViewById(R.id.ej5_b7),
            findViewById(R.id.ej5_b8),
            findViewById(R.id.ej5_b9)
        )

        for (it in 1..9){
            if (it != 5){
                listaBotones[it - 1].setOnClickListener {
                    startActivity(Intent(this, "ej$it"::class.java))
                }
            }else{
                listaBotones[4].setOnClickListener {
                    Toast.makeText(this, "El empanamiento es infinito", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}