package com.example.myapplicationgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myapplicationgit.databinding.ActivitySteperBinding
import com.shuhart.stepview.StepView

class SteperActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySteperBinding

    private var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySteperBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding. stepView.done(false)

        binding. button.setOnClickListener {
            when (position) {
                0 -> {
                    binding.personalDetails.visibility = View.GONE
                    binding.address.visibility = View.VISIBLE
                    position = 1
                    binding.stepView.done(false)
                    binding.stepView.go(position, true)
                    binding.button.text = "Next"
                }
                1 -> {
                    binding.address.visibility = View.GONE
                    binding.email.visibility = View.VISIBLE
                    position = 2
                    binding.stepView.done(false)
                    binding.stepView.go(position, true)
                    binding.button.text = "submit"
                }


                else -> {
//                    position = 0
                   // binding.stepView.go(st, true)

                }
            }
        }
    }
    override fun onBackPressed() {
        when (position) {
            0 -> {
                // exit the app
                super.onBackPressed()
            }

            1 -> {
                binding.address.visibility = View.GONE
                binding.personalDetails.visibility = View.VISIBLE
                position = 0
                binding.stepView.done(false)
                binding.stepView.go(position, true)
                binding.button.text = "Next"
            }
            2 -> {
                binding.email.visibility = View.GONE
                binding.address.visibility = View.VISIBLE
                position = 1
                binding.stepView.done(false)
                binding.stepView.go(position, true)
            }

            else -> {
                binding.personalDetails.visibility = View.GONE
                binding.address.visibility = View.VISIBLE
                position = 3
                binding.stepView.done(false)
                binding.stepView.go(position, true)
                binding.button.text = "Next"
            }
        }
    }
}