package com.rsk.stopwatch

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.rsk.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var running = false
    var offset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)


        if(savedInstanceState != null){
            offset = savedInstanceState.getLong(OFFSET_KEY)
            running = savedInstanceState.getBoolean(RUNNING_KEY)

            if (running){
                binding.chronometer.base = savedInstanceState.getLong(BASE_KEY)
                binding.chronometer.start()
            }else{
                setBaseTime()
            }
        }


        binding.btnStart.setOnClickListener{
            if (!running){
                setBaseTime()
                binding.chronometer.start()
                running = true

                Toast.makeText(this, "Counting...", Toast.LENGTH_LONG ).show()
            }
        }


        binding.btnPause.setOnClickListener{
            if (running){
                saveOffset()
                binding.chronometer.stop()
                running = false

                Toast.makeText(this, "Paused", Toast.LENGTH_LONG ).show()

            }
        }

        binding.btnReset.setOnClickListener{
            offset = 0
            setBaseTime()
           Toast.makeText(this, "StopWatch Reset", Toast.LENGTH_LONG ).show()

        }
    }

    private fun saveOffset() {
        offset = SystemClock.elapsedRealtime() - binding.chronometer.base
    }

    private fun setBaseTime() {
        binding.chronometer.base = SystemClock.elapsedRealtime() - offset
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putLong(OFFSET_KEY, offset)
        savedInstanceState.putBoolean(RUNNING_KEY, running)
        savedInstanceState.putLong(BASE_KEY, binding.chronometer.base)
        super.onSaveInstanceState(savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
        if(running){
            saveOffset()
            binding.chronometer.stop()
        }
    }

    override fun onResume() {
        if(running){
            setBaseTime()
            binding.chronometer.start()
            offset = 0
        }
        super.onResume()
    }
}