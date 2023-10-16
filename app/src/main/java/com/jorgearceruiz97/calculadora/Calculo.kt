package com.jorgearceruiz97.calculadora

class Calculo {
    private var num1 = 0
    private var num2 = 0
    private var resultado = 0
    private var operacion = 0

    private var primerNum = true // true -> esperando num1 / false -> esperando num2
    var num1Temp = ""
    var num2Temp = ""
    var numCalculos = 0


    /**
     * realiza la llamada al método adecuado para realizar el cálculo solicitado a una calculadora
     * si el num1Temp y el num2Temp no están vacios los cambia a enteros y realiza una operación
     * segun el número que tenga almacenado
     * si no el resultado es cero
     */
    fun calcular(){
        if (num1Temp.isNotEmpty() && num2Temp.isNotEmpty()) {
            num1 = num1Temp.toInt()
            num2 = num2Temp.toInt()

            when (operacion) {
                0 -> suma()
                1 -> resta()
                2 -> mult()
                3 -> div()
            }
            numCalculos++
        } else {
            resultado = 0
        }
    }

    /**
     * resetea el primerNum a true y los num1 y 2 y numeros temporales
     */
    fun resetear(){
        primerNum = true
        num1 = 0
        num2 = 0
        num1Temp = ""
        num2Temp = ""
    }

    /**
     * establece numero temporal
     */
    fun establecerNumero(numero: Int) {
        if (primerNum) {
            num1Temp += numero
        } else {
            num2Temp += numero
        }
    }

    /**
     * establece la operacion, cambia el primer num a false ya que se prevee que una vez
     * se introduzca una operación el siguiente num será el num2
     */
    fun establecerOperacion(op: Int) {
        operacion = op
        primerNum = false
    }

    private fun suma() {
        resultado = num1 + num2
    }

    private fun resta() {
        resultado = num1 - num2
    }

    private fun mult() {
        resultado = num1 * num2
    }

    private fun div() {
        resultado = if (num2 != 0) {
            num1 / num2
        } else {
            0
        }
    }

    /**
     * obtiene el resultado
     */
    fun obtenerResultado(): Int {
        return resultado
    }

}