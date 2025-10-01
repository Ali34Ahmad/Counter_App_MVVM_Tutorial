package com.example.counterappmvvm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.counterappmvvm.presentation.counter.CounterScreen
import com.example.counterappmvvm.presentation.counter.CounterViewModel
import com.example.counterappmvvm.presentation.ui.theme.CounterAppMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = CounterViewModel()
            val count = viewModel.count.collectAsStateWithLifecycle()

            CounterAppMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface {
                        CounterScreen(
                            currentCount = count.value,
                            onIncrement = viewModel::onIncrementClicked
                        )
                    }
                }
            }
        }
    }
}
