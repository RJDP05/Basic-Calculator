package com.kachi.jetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

//CalculatorViewModel is a ViewModel class that holds the state of the calculator.
class CalculatorViewModel: ViewModel() {

    //state is a mutableStateOf that holds the CalculatorState.
    //The state is exposed as a read-only property.
    //The state is initialized with a new instance of CalculatorState.
    var state by mutableStateOf(CalculatorState())
        private set

    //onAction is a function that takes a CalculatorAction as a parameter and returns Unit.
    fun onAction(action: CalculatorAction){

        //The onAction function is called with a CalculatorAction.
        //The function checks the type of the CalculatorAction and updates the state of the calculator based on the action.
        //when expression is used to check the type of the CalculatorAction and perform the appropriate action.
        when(action){
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.ToogelSign -> performToggle()
        }
    }

    //The enterNumber function takes an Int as a parameter and returns Unit.
    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.num1.length >= MAX_NUM_LENGTH) return
            //state = state.copy creates a new instance of CalculatorState.
            //Copy the state and update the num1 with the new number
            //The new state is assigned to the state variable using the copy function then the function returns
            state = state.copy(num1 = state.num1 + number)
            return
        }

        if (state.num2.length >= MAX_NUM_LENGTH) return
        state = state.copy(num2 = state.num2 + number)
    }

    //The companion object contains a constant MAX_NUM_LENGTH that defines the maximum length of a number.
    companion object {
        private const val MAX_NUM_LENGTH = 10
    }

    private fun performDeletion() {
        when {
            //state.num2.isNotBlank() checks if num2 is not blank and drops the last character from num2.
            state.num2.isNotBlank() -> state = state.copy(
                num2 = state.num2.dropLast(1)
            )
            //state.operation != null checks if the operation is not null and sets the operation to null.
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.num1.isNotBlank() -> state = state.copy(
                num1 = state.num1.dropLast(1)
            )

        }
    }

    private fun performCalculation() {
        //Convert num1 and num2 to Double using toDoubleOrNull.
        val number1 = state.num1.toDoubleOrNull()
        val number2 = state.num2.toDoubleOrNull()

        if(number1 != null && number2 != null){
            //Check the operation and perform the appropriate calculation.
            val result = when(state.operation){
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Module -> number1  % number2
                null -> return
            }
            state = state.copy(
                //Update the num1 with the result of the calculation and reset the num2 and operation.
                //take(10) is used to limit the result to 10 characters.
                num1 = result.toString().take(10),
                num2 = "",
                operation = null
            )
        }

    }

    //CalculatorOperation is an enum class that defines the different calculator operations.
    private fun enterOperation(operation: CalculatorOperation) {
        if(state.num1.isNotBlank()){
            //operation = operation is used to update the operation in the state.
            //Where the first operation used is the operation that is selected.
            //and the second operation is the operation that is selected.
            state = state.copy(operation = operation)
        }

    }

    private fun enterDecimal() {
        if(state.operation == null && !state.num1.contains(".") && state.num1.isNotBlank()){
            state = state.copy(
                num1 = state.num1 + "."
            )
            return
        }

        if(!state.num2.contains(".") && state.num2.isNotBlank()){
            state = state.copy(
                num1 = state.num1 + "."
            )
        }
    }

    private fun performToggle() {
        state = if(state.operation == null){
            state.copy(
                //.unaryMinus() is used to toggle the sign of the number.
                num1 = (state.num1.toDoubleOrNull()?.unaryMinus() ?: 0.0).toString()
            )
        }else{
            state.copy(
                num2 = (state.num2.toDoubleOrNull()?.unaryMinus() ?: 0.0).toString()
            )
        }

    }
}
