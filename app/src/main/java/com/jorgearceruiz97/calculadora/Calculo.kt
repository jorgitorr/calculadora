package com.jorgearceruiz97.calculadora

import android.widget.Button

class Calculo {
    companion object{
        fun suma(num1: Int, num2: Int): Int {
            var resultado = num1 + num2
            return resultado
        }

        fun resta(num1: Int, num2: Int): Int{
            var resultado = num1 - num2
            return resultado
        }

        fun div(num1: Int, num2: Int): Int{
            var resultado = num1 / num2
            return resultado
        }

        fun mult(num1: Int, num2: Int): Int{
            var resultado = num1 * num2
            return resultado
        }
    }


}