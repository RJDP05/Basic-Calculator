package com.kachi.jetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// This is a Composable function that represents a button in the calculator.
@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
    ){
        Text(
            text = symbol,
            fontSize = 24.sp,
            color = Color.White
        )
    }
}

// This is a Composable function that represents an operation button in the calculator.
@Composable
fun CalculatorOperationButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
    ){
        Text(
            text = symbol,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
    }
}