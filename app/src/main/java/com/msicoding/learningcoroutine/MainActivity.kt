package com.msicoding.learningcoroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.runBlocking


class MainActivity : ComponentActivity() {
    private val tag = "kotlin_flows"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        runBlocking {

            flow()
                .filter { timer ->
                    timer.contains("This")
                }
                .map {
                    it + 2
                }
                .collect {
                    Log.d(tag, "Value: $it")
                }

        }

    }

    private fun flow(): Flow<Int> = flow {

        repeat(5) {
            emit(it)
        }

    }
}

/*

private var timer = 1
    private fun flow(): Flow<String> = flow {

        emit("This is $timer")
        delay(1000)
        timer++

        emit("That is $timer")
        delay(1000)
        timer++

        emit("This is $timer")
        delay(1000)
        timer++

        emit("That is $timer")
        delay(1000)
        timer++


    }

* */



















