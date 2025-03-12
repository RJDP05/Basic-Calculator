package com.kachi.jetpackcompose

//CalculatorAction is a sealed class that represents the actions that can be performed in the calculator.
sealed class CalculatorAction{

    //Number is a data class that represents the action of entering a number in the calculator.
    data class Number(val number: Int): CalculatorAction()

    //Clear is an object that represents the action of clearing the calculator.
    data object Clear: CalculatorAction()

    //Delete is an object that represents the action of deleting the last digit entered in the calculator.
    data object Delete: CalculatorAction()

    //ToogelSign is an object that represents the action of toggling the sign of the number in the calculator.
    data object ToogelSign: CalculatorAction()

    //Decimal is an object that represents the action of entering a decimal point in the calculator.
    data object Decimal: CalculatorAction()

    //Calculate is an object that represents the action of calculating the result in the calculator.
    data object Calculate: CalculatorAction()

    //CalculatorOperation is an enum class that represents the operations that can be performed in the calculator.
    //Operation is a data class that represents the action of entering an operation in the calculator.
    data class Operation(val operation: CalculatorOperation): CalculatorAction()

    //object vs data object
    //object is a singleton class that can be used to create a single instance of a class.
    //data object is a singleton class that can be used to create a single instance of a class that can hold data.
    //In this case, the object is used to create a single instance of the class,
    //while the data object is used to create a single instance of the class that can hold data.
}
