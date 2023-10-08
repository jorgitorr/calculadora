package com.jorgearceruiz97.calculadora

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val botones = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var pantalla : TextView = findViewById(R.id.screen)
        //agrega botones
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


        var valor1 = "";
        var valor2 = "";
        var tipo = "";
        for(num in botones){
            num.setOnClickListener(View.OnClickListener {
                when(num.id){
                    R.id.button0 ->{
                        pantalla.setText(pantalla.text.toString()+"0")
                    }
                    R.id.button1 ->{
                        pantalla.setText(pantalla.text.toString()+"1")
                    }
                    R.id.button2 ->{
                        pantalla.setText(pantalla.text.toString()+"2")
                    }
                    R.id.button3 ->{
                        pantalla.setText(pantalla.text.toString()+"3")
                    }
                    R.id.button4 ->{
                        pantalla.setText(pantalla.text.toString()+"4")
                    }
                    R.id.button5 ->{
                        pantalla.setText(pantalla.text.toString()+"5")
                    }
                    R.id.button6 ->{
                        pantalla.setText(pantalla.text.toString()+"6")
                    }
                    R.id.button7 ->{
                        pantalla.setText(pantalla.text.toString()+"7")
                    }
                    R.id.button8 ->{
                        pantalla.setText(pantalla.text.toString()+"8")
                    }
                    R.id.button9 ->{
                        pantalla.setText(pantalla.text.toString()+"9")
                    }
                    R.id.CE -> {
                        pantalla.text = "";
                    }
                    R.id.buttonSum ->{
                        if(valor1=="")
                            valor1 = pantalla.text.toString();
                        else {
                            valor2 = pantalla.text.toString();
                            R.id.buttonIgual
                        }

                        tipo = "+";
                        pantalla.text = "";
                    }
                    R.id.buttonRest ->{
                        valor1 = pantalla.text.toString();
                        tipo = "-";
                        pantalla.text = "";
                    }
                    R.id.buttonMult ->{
                        valor1 = pantalla.text.toString();
                        tipo = "*";
                        pantalla.text = "";
                    }
                    R.id.buttonDiv ->{
                        valor1 = pantalla.text.toString();
                        tipo = "/";
                        pantalla.text = "";
                    }
                    R.id.buttonIgual ->{
                        if(tipo!="" && valor1!=""){
                            var resultado = 0
                            valor2 = pantalla.text.toString()

                            when(tipo){
                                "+" ->{
                                    resultado = Calculo.suma(valor1.toInt(),valor2.toInt())
                                }
                                "-" ->{
                                    resultado = Calculo.resta(valor1.toInt(),valor2.toInt())
                                }
                                "*" ->{
                                    resultado = Calculo.mult(valor1.toInt(),valor2.toInt())
                                }
                                "/" ->{
                                    resultado = Calculo.div(valor1.toInt(),valor2.toInt())
                                }
                            }
                            valor1 = "";
                            valor2 = "";
                            pantalla.setText(resultado.toString())
                        }else{
                            Toast.makeText(applicationContext, "Introduce algún número", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

        //cambia el tamanio del texto de la pantalla cuando la longuitud es mayor
        if(pantalla.text.length>4){
            pantalla.textSize = 20F;
        }else{
            pantalla.textSize = 80F;
        }
    }
}