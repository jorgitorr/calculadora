package com.jorgearceruiz97.calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val botones = ArrayList<Button>()
    private var calculo = Calculo()
    private lateinit var pantalla : TextView
    private var hayOperacion = false

    /**
     * añade botones a la lista
     */
    private fun inicializarBotones(){
        botones.add(findViewById(R.id.button0))
        botones.add(findViewById(R.id.button1))
        botones.add(findViewById(R.id.button2))
        botones.add(findViewById(R.id.button3))
        botones.add(findViewById(R.id.button4))
        botones.add(findViewById(R.id.button5))
        botones.add(findViewById(R.id.button6))
        botones.add(findViewById(R.id.button7))
        botones.add(findViewById(R.id.button8))
        botones.add(findViewById(R.id.button9))
        botones.add(findViewById(R.id.CE))
        botones.add(findViewById(R.id.buttonSum))
        botones.add(findViewById(R.id.buttonRest))
        botones.add(findViewById(R.id.buttonMult))
        botones.add(findViewById(R.id.buttonDiv))
        botones.add(findViewById(R.id.buttonIgual))
    }

    /**
     * vacia la pantalla eliminando el contenido que tenga
     */
    private fun vaciarPantalla(){
        pantalla.text = ""
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pantalla = findViewById(R.id.screen)

        inicializarBotones()

        var operacionActual = -1 //operacion que va a hacer el usuario (suma, resta, multiplicacion, division)

        for(num in botones){
            num.setOnClickListener {
                when (num.id) {
                    in R.id.button0..R.id.button9 -> {//recorre del boton 0 al 9
                        val numero = num.id - R.id.button0
                        pantalla.text = pantalla.text.toString() + numero//añade a la cadena actual en pantalla el boton(numero) seleccionado
                    }

                    R.id.CE -> {//boton CE
                        vaciarPantalla()
                        calculo.resetear()
                        hayOperacion = false
                    }

                    R.id.buttonSum, R.id.buttonRest, R.id.buttonMult, R.id.buttonDiv -> {
                        // Recorre los botones de operaciones y actualiza la operación actual
                        when (num.id) {
                            R.id.buttonSum -> operacionActual = 0
                            R.id.buttonRest -> operacionActual = 1
                            R.id.buttonMult -> operacionActual = 2
                            R.id.buttonDiv -> operacionActual = 3
                        }

                        if(!hayOperacion){
                            calculo.establecerNumero(pantalla.text.toString().toInt())
                            vaciarPantalla()
                        }
                        calculo.establecerOperacion(operacionActual)
                        hayOperacion = true // true -> ha realizado una operacion / false -> no tiene operacion almacenada
                    }

                    R.id.buttonIgual -> {
                        if (calculo.num1Temp.isEmpty() && calculo.num2Temp.isEmpty())
                            Toast.makeText(
                                applicationContext,
                                "Debe introducir dos números y una operación",
                                Toast.LENGTH_SHORT
                            ).show()
                        else {
                            calculo.establecerNumero(pantalla.text.toString().toInt())
                            calculo.calcular()
                            pantalla.text = calculo.obtenerResultado().toString()
                            calculo.resetear()
                            hayOperacion = false // false -> no tiene ninguna operacion almacenada
                        }
                    }
                }
            }
        }

    }
}