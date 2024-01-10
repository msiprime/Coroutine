package com.msicoding.learningcoroutine

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.msicoding.learningcoroutine.ui.theme.LearningCoroutineTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningCoroutineTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController()
                    NavHost(
                        navController = navHostController,
                        startDestination = "Home"
                    ) {
                        composable("home") {
                            HomeScreen {
                                navHostController.navigate("second")
                            }
                        }

                        composable("second") {
                            SecondScreen {
                                Intent(
                                    this@MainActivity, NewActivity::class.java
                                ).also {
                                    startActivity(it)
                                    finish()
                                }
                            }
                        }
                    }
                }
            }
        }
        lifecycleScope.launch {
            while (true) {
                delay(2000)
                Log.d("tag_coroutines", "LifeCycleScope")
            }
        }
    }
}

@Composable
fun HomeScreen(
    onGoClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { onGoClick() }) {
            Text(text = "Go")
        }
    }

}

@Composable
fun SecondScreen(
    onGoClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LaunchedEffect(key1 = true) {

        }
        Button(onClick = { onGoClick() }) {
            Text(text = "Go new activity")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LearningCoroutineTheme {
        HomeScreen(onGoClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview(

) {
    LearningCoroutineTheme {
        SecondScreen(onGoClick = {})
    }
}