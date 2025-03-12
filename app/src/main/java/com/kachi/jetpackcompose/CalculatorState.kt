package com.kachi.jetpackcompose

//CalculatorState is a data class that holds the state of the calculator.
data class CalculatorState(
    //num1 is the first number in the calculation.
    val num1: String = "",

    //num2 is the second number in the calculation.
    val num2: String = "",

    //It is set to null when the calculator is cleared.
    //It is set to the result of the calculation when the calculator is evaluated.
    //It is set to the result of the calculation when the calculator is in the middle of a calculation.
    val operation: CalculatorOperation? = null
)
