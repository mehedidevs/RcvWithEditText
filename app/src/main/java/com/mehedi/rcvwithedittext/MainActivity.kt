package com.mehedi.rcvwithedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mehedi.rcvwithedittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), InputAdapter.OnTextChangeWithPosition {
    lateinit var binding: ActivityMainBinding
    val list =
        listOf<String>("what is your age ?", "What is Your dad Age ?", " What uis your moms Age?")

    val map = mutableMapOf<Int, String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mAdapter = InputAdapter(list, this)
        binding.rcv.adapter = mAdapter

        binding.btnSubmit.setOnClickListener {

            Log.d("TAG", "input data : $map")


        }


    }

    override fun inputText(title: String, inputText: String, position: Int) {
        map[position] = inputText

    }
}