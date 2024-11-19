package com.example.seminario_di_cartas

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible

class ej6 : AppCompatActivity() {

    private lateinit var casillas : MutableList<MutableList<ImageView>>
    private lateinit var tablero : MutableList<MutableList<Pair<Int, Int>>>

    private lateinit var botonReset : Button

    private lateinit var texto : TextView

    private var numTurnos = 0
    private var numX = 0
    private var numO = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tres_en_raya)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tablero = mutableListOf(
            mutableListOf(Pair(0, 0), Pair(0, 0), Pair(0, 0)),
            mutableListOf(Pair(0, 0), Pair(0, 0), Pair(0, 0)),
            mutableListOf(Pair(0, 0), Pair(0, 0), Pair(0, 0))
        )

        casillas = mutableListOf(
            mutableListOf(findViewById(R.id.tresEnRaya_00), findViewById(R.id.tresEnRaya_01), findViewById(R.id.tresEnRaya_02)),
            mutableListOf(findViewById(R.id.tresEnRaya_10), findViewById(R.id.tresEnRaya_11), findViewById(R.id.tresEnRaya_12)),
            mutableListOf(findViewById(R.id.tresEnRaya_20), findViewById(R.id.tresEnRaya_21), findViewById(R.id.tresEnRaya_22))
        )

        texto = findViewById(R.id.resultado)
        texto.isInvisible = true
        botonReset = findViewById(R.id.tresEnRaya_b)

        botonReset.setOnClickListener{
            recreate()
        }

        for (it1 in 0 until casillas.size){
            for (it2 in 0 until casillas[0].size){
                casillas[it1][it2].setOnClickListener{
                    Log.v("Casillas", "Boton $it1-$it2 pulsado")
                    jugar(it1, it2)
                }
            }
        }

    }

    fun jugar(x : Int, y : Int){
        tablero[x][y] = Pair(1, numX)
        when{
            numX == 0 -> casillas[x][y].setImageResource(R.drawable.equis_uno)
            numX == 1 -> casillas[x][y].setImageResource(R.drawable.equis_dos)
            numX == 2 -> casillas[x][y].setImageResource(R.drawable.equis_tres)
        }

        if (numX == 2) numX = 0
        else numX++

        casillas[x][y].isEnabled = false

        if (comprobarVictoria() == 0){
            if (numTurnos++ != 4){

                var x : Int
                var y : Int

                do {
                    x = (0..2).random()
                    y = (0..2).random()
                }while (tablero[x][y].first != 0)

                tablero[x][y] = Pair(2, numO)

                when{
                    numO == 0 -> casillas[x][y].setImageResource(R.drawable.circulo_uno)
                    numO == 1 -> casillas[x][y].setImageResource(R.drawable.circulo_dos)
                    numO == 2 -> casillas[x][y].setImageResource(R.drawable.circulo_tres)
                }

                if (numO == 2) numO = 0
                else numO++

                casillas[x][y].isEnabled = false

                if (comprobarVictoria() == 2){
                    mostrarResultado()
                }

            }else{
                mostrarResultado()
            }
        }else{
            mostrarResultado()
        }

    }

    fun mostrarResultado(){

        texto.isInvisible = false
        val resultado = comprobarVictoria()

        var titulo = ""

        if (resultado == 0) titulo = "Empate"
        else if (resultado == 1) titulo = "Has ganado :)"
        else titulo = "Has perdido :("

        for (it in 0 until tablero.size){
            for (it2 in 0 until tablero[0].size){
                casillas[it][it2].isEnabled = false
            }
        }

        texto.text = titulo
    }

    fun comprobarVictoria() : Int{

        for (it in 0 until tablero.size){

            if (tablero[it][0].first != 0){
                if (tablero[it][0].first == tablero[it][1].first && tablero[it][1].first == tablero[it][2].first){

                    for (it2 in 0 until tablero.size){
                        if (tablero[it][0].first == 1){

                            when{
                                tablero[it][it2].second == 0 -> casillas[it][it2].setImageResource(R.drawable.equis_azul_uno)
                                tablero[it][it2].second == 1 -> casillas[it][it2].setImageResource(R.drawable.equis_azul_dos)
                                tablero[it][it2].second == 2 -> casillas[it][it2].setImageResource(R.drawable.equis_azul_tres)
                            }

                        }else{

                            when{
                                tablero[it][it2].second == 0 -> casillas[it][it2].setImageResource(R.drawable.circulo_rojo_uno)
                                tablero[it][it2].second == 1 -> casillas[it][it2].setImageResource(R.drawable.circulo_rojo_dos)
                                tablero[it][it2].second == 2 -> casillas[it][it2].setImageResource(R.drawable.circulo_rojo_tres)
                            }

                        }
                    }

                    return tablero[it][0].first
                }
            }

        }

        for (it in 0 until tablero[0].size){

            if (tablero[0][it].first != 0){

                if (tablero[0][it].first == tablero[1][it].first && tablero[1][it].first == tablero[2][it].first){

                    for (it2 in 0 until tablero.size){

                        if (tablero[0][it].first == 1){

                            when{
                                tablero[it2][it].second == 0 -> casillas[it2][it].setImageResource(R.drawable.equis_azul_uno)
                                tablero[it2][it].second == 1 -> casillas[it2][it].setImageResource(R.drawable.equis_azul_dos)
                                tablero[it2][it].second == 2 -> casillas[it2][it].setImageResource(R.drawable.equis_azul_tres)
                            }

                        }else{

                            when{
                                tablero[it2][it].second == 0 -> casillas[it2][it].setImageResource(R.drawable.circulo_rojo_uno)
                                tablero[it2][it].second == 1 -> casillas[it2][it].setImageResource(R.drawable.circulo_rojo_dos)
                                tablero[it2][it].second == 2 -> casillas[it2][it].setImageResource(R.drawable.circulo_rojo_tres)
                            }

                        }
                    }

                    return tablero[0][it].first
                }
            }

        }

        if (tablero[0][0].first != 0){
            if (tablero[0][0].first == tablero[1][1].first && tablero[1][1].first == tablero[2][2].first){

                for (it in 0 until tablero.size){

                    if (tablero[0][0].first == 1){

                        when{
                            tablero[it][it].second == 0 -> casillas[it][it].setImageResource(R.drawable.equis_azul_uno)
                            tablero[it][it].second == 1 -> casillas[it][it].setImageResource(R.drawable.equis_azul_dos)
                            tablero[it][it].second == 2 -> casillas[it][it].setImageResource(R.drawable.equis_azul_tres)
                        }

                    }else{

                        when{
                            tablero[it][it].second == 0 -> casillas[it][it].setImageResource(R.drawable.circulo_rojo_uno)
                            tablero[it][it].second == 1 -> casillas[it][it].setImageResource(R.drawable.circulo_rojo_dos)
                            tablero[it][it].second == 2 -> casillas[it][it].setImageResource(R.drawable.circulo_rojo_tres)
                        }

                    }

                }

                return tablero[0][0].first
            }
        }

        if (tablero[0][2].first != 0){
            if (tablero[0][2].first == tablero[1][1].first && tablero[1][1].first == tablero[2][0].first){

                var it2 = 2

                for (it in 0 until tablero.size){

                    if (tablero[0][2].first == 1){

                        when{
                            tablero[it][it2].second == 0 -> casillas[it][it2].setImageResource(R.drawable.equis_azul_uno)
                            tablero[it][it2].second == 1 -> casillas[it][it2].setImageResource(R.drawable.equis_azul_dos)
                            tablero[it][it2].second == 2 -> casillas[it][it2].setImageResource(R.drawable.equis_azul_tres)
                        }

                    }else{

                        when{
                            tablero[it][it2].second == 0 -> casillas[it][it2].setImageResource(R.drawable.circulo_rojo_uno)
                            tablero[it][it2].second == 1 -> casillas[it][it2].setImageResource(R.drawable.circulo_rojo_dos)
                            tablero[it][it2].second == 2 -> casillas[it][it2].setImageResource(R.drawable.circulo_rojo_tres)
                        }

                    }

                    it2--
                }

                return tablero[2][0].first
            }
        }

        return 0
    }
}