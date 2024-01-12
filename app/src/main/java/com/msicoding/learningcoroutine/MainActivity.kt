package com.msicoding.learningcoroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking


class MainActivity : ComponentActivity() {
    private val tag = "kotlin_flows"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        runBlocking {

            flow().onEach {
                Log.d(tag, "We got: $it")
            }
                .collectLatest{
                    delay(2000)
                    Log.d(tag, "Result: $it")
                }
        }

    }

    private val list = listOf("Result of Kotlin", "Result of Java", "Result of Swift")

    private fun flow(): Flow<String> = flow {

        delay(1000)
        emit(list[0])
        delay(1000)
        emit(list[1])
        delay(1000)
        emit(list[2])

    }
}


















