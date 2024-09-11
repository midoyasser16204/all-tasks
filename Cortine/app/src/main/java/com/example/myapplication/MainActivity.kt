package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private val job: Job = Job()
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Default + job)
    private val channel = Channel<Int>()
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        lifecycleScope.launch {
//            var string = ""
//            var string2 = ""
//
//            val job = launch {
//                string = getstring()
//            }
//
//            val job2 = launch {
//                string2 = getstring2()
//            }
//
//            job.join()
//            job2.join()
//
//            Log.i("test", string)
//            Log.i("test", string2)
//        }
//        val job3 = coroutineScope.async {
//            for (i in 1..1000) {
//                delay(1000)
//                Log.i("test", "job3: $i")
//            }
//        }
//        val job4 = coroutineScope.async {
//            for (i in 1..1000) {
//                delay(2000)
//                Log.i("test", "job4: $i")
//            }
//        }
//        runBlocking {
//            delay(5000)
//        }
//        job3.cancel()
//        job4.cancel()

//        lifecycleScope.launch {
//            launch {
//                for (i in 1..100){
//                    channel.send(i)
//                }
//            }
//            launch {
//                for (i in channel){
//                    delay(1000)
//                    Log.i("test","$i")
//                }
//            }
//        }

        lifecycleScope.launch {
            flow<Int>{
                for (i in 1..100){
                    emit(i)
                    delay(1000)
                }
            }.filter {
                it<=20
            }.buffer().collect{
                delay(1000)
                Log.i("test",it.toString())
            }
        }
    }

    suspend fun getstring(): String {
        delay(1000)
        return "ahmed"
    }

    suspend fun getstring2(): String {
        delay(2000)
        return "ahmed"
    }
}