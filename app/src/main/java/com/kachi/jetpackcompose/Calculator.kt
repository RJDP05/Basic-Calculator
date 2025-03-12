package com.kachi.jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kachi.jetpackcompose.ui.theme.JetpackComposeTheme

//Composable function to display the calculator
@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp,
    onAction: (CalculatorAction) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //SpaceAround is used to distribute the children evenly with space around them
        verticalArrangement = Arrangement.SpaceAround
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Black)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                //Display the text in the center of the screen
                //(state.num1 + (state.operation?.symbol?: "") + state.num2) is used to display the numbers and the operation symbol
                //(state.operation?.symbol?: "") is used to display the operation symbol if it is not null
                text = state.num1 + (state.operation?.symbol?: "") + state.num2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp, horizontal = 10.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            Column(modifier = modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CalculatorOperationButton(
                        symbol = "AC",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Clear)
                        }
                    )
                    CalculatorOperationButton(
                        symbol = "D",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Delete)
                        }
                    )
                    CalculatorOperationButton(
                        symbol = "+/-",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.ToogelSign)
                        }
                    )
                    CalculatorOperationButton(
                        symbol = "/",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                        }
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CalculatorButton(
                        symbol = "7",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(7))
                        }
                    )
                    CalculatorButton(
                        symbol = "8",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(8))
                        }
                    )
                    CalculatorButton(
                        symbol = "9",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(9))
                        }
                    )
                    CalculatorOperationButton(
                        symbol = "X",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                        }
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CalculatorButton(
                        symbol = "4",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(4))
                        }
                    )
                    CalculatorButton(
                        symbol = "5",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(5))
                        }
                    )
                    CalculatorButton(
                        symbol = "6",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(6))
                        }
                    )
                    CalculatorOperationButton(
                        symbol = "-",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                        }
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    CalculatorButton(
                        symbol = "1",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(1))
                        }
                    )
                    CalculatorButton(
                        symbol = "2",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(2))
                        }
                    )
                    CalculatorButton(
                        symbol = "3",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(3))
                        }
                    )
                    CalculatorOperationButton(
                        symbol = "+",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                        }
                    )

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    CalculatorOperationButton(
                        symbol = "%",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Module))
                        }
                    )
                    CalculatorButton(
                        symbol = "0",
                        modifier = Modifier
                            .background(Color.Black)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Number(0))
                        }
                    )
                    CalculatorOperationButton(
                        symbol = ".",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Decimal)
                        }
                    )
                    CalculatorOperationButton(
                        symbol = "=",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .weight(1f)
                            .padding(16.dp),
                        onClick = {
                            onAction(CalculatorAction.Calculate)
                        }
                    )
                }


            }

        }
    }


}
