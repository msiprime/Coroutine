package com.msicoding.learningcoroutine

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.runBlocking


class MainActivity : ComponentActivity() {
    private val tag = "kotlin_flows"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        runBlocking {

//            getDataFlow().collect { data ->
//                Log.d(tag, "received: $data")
//            }

            countdownTimer().collect { time ->
                Log.d(tag, "Counting: $time")
            }

        }
    }

    private fun getDataFlow(): Flow<String> {
        return flow {

            emit("start  loading...")
            delay(1000)

            emit("got the data...")
            delay(1000)

            emit("filtering the data...")
            delay(1000)

            emit("data is ready...")
            delay(1000)

            emit("stop loading...")

        }
    }

    private fun countdownTimer(): Flow<Int> = flow {
        var startTimer = 10
        while (startTimer >= 0) {
            delay(1000)
            emit(
                value = startTimer
            )
            startTimer--
        }
    }
}

























