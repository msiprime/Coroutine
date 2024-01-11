package com.msicoding.learningcoroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
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

                var file1: String? = null
                var file2: String? = null

                val job1 = launch {
                    file1 = getFile()
                }
                val job2 = launch {
                    file2 = getFile2()
                }

                job1.join()
                job2.join()

                Log.d("tag_coroutine", "File 1: $file1")
                Log.d("tag_coroutine", "File 1: $file2")
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