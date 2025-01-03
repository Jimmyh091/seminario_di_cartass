package com.example.seminario_di_cartas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pais(var nombre : String, var bandera : Int, var habitantes : Int) : Parcelable{

}
