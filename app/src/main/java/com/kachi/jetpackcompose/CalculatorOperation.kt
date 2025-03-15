package com.kachi.jetpackcompose

//CalculatorOperation is a sealed class that represents the operations that can be performed by the calculator.
sealed class CalculatorOperation(val symbol: String){

    //Add, Subtract, Multiply, Divide, and Module are the operations that can be performed by the calculator.
    data object Add: CalculatorOperation("+")
    data object Subtract: CalculatorOperation("-")
    data object Multiply: CalculatorOperation("x")
    data object Divide: CalculatorOperation("/")
    data object Module: CalculatorOperation("%")
}