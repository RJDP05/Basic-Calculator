package com.kachi.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kachi.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                val viewModel = viewModel<CalculatorViewModel>() // This is the way to get the view model
                val state = viewModel.state // Get the state from the view model
                val buttonSpacing = 8.dp
                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp)
                )
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview(){
        JetpackComposeTheme{
            val viewModel = viewModel<CalculatorViewModel>()
            val state = viewModel.state
            val buttonSpacing = 8.dp
            Calculator(
                state = state,
                onAction = viewModel::onAction,
                buttonSpacing = buttonSpacing
            )
        }
    }
}
