package com.msicoding.learningcoroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            val x = measureTimeMillis {

                val file1 = async {
                    getFile()
                }

                val file2 = async {
                    getFile2()
                }
                Log.d("tag_coroutine", "File 1: ${file1.await()}")
                Log.d("tag_coroutine", "File 1: ${file2.await()}")
            }
            Log.d("tag_coroutine", "Total time : $x")
        }
    }

    private suspend fun getFile(): String {
        delay(4000)
        return "File 1"
    }

    private suspend fun getFile2(): String {
        delay(4000)
        return "File 2"
    }

}