package com.example.final3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.final3.databinding.ActivityMainBinding
import android.os.CountDownTimer
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.startButton.setOnClickListener {
            startTimer()
        }

        binding.restartButton.setOnClickListener {
            restartTimer()
        }
    }

    private fun startTimer() {
        val inputTime = binding.timeEditText.text.toString().split(":")
        if (inputTime.size == 2) {
            val minutes = inputTime[0].toLongOrNull()
            val seconds = inputTime[1].toLongOrNull()

            if (minutes != null && seconds != null) {
                val totalTimeInSeconds = (minutes * 60) + seconds
                timer?.cancel()
                timer = object : CountDownTimer(totalTimeInSeconds * 1000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        val minutesRemaining = millisUntilFinished / 1000 / 60
                        val secondsRemaining = (millisUntilFinished / 1000) % 60
                        binding.timerTextView.text = String.format(
                            "Осталось времени: %02d:%02d",
                            minutesRemaining,
                            secondsRemaining
                        )
                    }
                    override fun onFinish() {
                        binding.timerTextView.text = "Таймер завершен!"
                        binding.restartButton.visibility = View.VISIBLE
                    }
                }
                timer?.start()
                binding.restartButton.visibility = View.VISIBLE
            } else {
                binding.timerTextView.text = "Пожалуйста, введите корректное время (мм:сс)."
            }
        } else {
            binding.timerTextView.text = "Пожалуйста, введите время в формате (мм:сс)."
        }
    }

    private fun restartTimer() {
        timer?.cancel()
        binding.timerTextView.text = ""
        binding.timeEditText.text.clear()
        binding.restartButton.visibility = View.INVISIBLE
        startTimer()
    }
}