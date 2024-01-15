package com.msicoding.learningcoroutine

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.msicoding.learningcoroutine.ui.theme.LearningCoroutineTheme

class MainActivity : ComponentActivity() {
    private val tag = "kotlin_flows"
    private val simpleViewModel: SimpleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LearningCoroutineTheme {
                val simpleViewModel1 = viewModel<SimpleViewModel>()
                val textState = simpleViewModel1.textState.collectAsState()

                val context = LocalContext.current
                LaunchedEffect(key1 = true) {

                    simpleViewModel1.sharedFlow.collect { show ->
                        if (show) {
                            Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).show()
                        }
                    }

                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = textState.value)

                    TextField(value = textState.value, onValueChange = {
                        simpleViewModel1.changeText(it)
                    })

                }

            }
        }

    }

}


















