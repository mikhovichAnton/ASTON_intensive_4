package com.android.aston_intensive_4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.aston_intensive_4.databinding.ActivityMainBinding
import com.android.aston_intensive_4.task_1.FragmentA

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonTask1.setOnClickListener {
                buttonTask1.visibility = View.GONE
                buttonTask2.visibility = View.GONE
                if (savedInstanceState == null) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,FragmentA())
                        .commit()
                }
            }


        }
    }
}