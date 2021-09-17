package com.example.lab2_andrroidadvanced

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab2_andrroidadvanced.activity.Bai1
import com.example.lab2_andrroidadvanced.activity.Bai2
import com.example.lab2_andrroidadvanced.activity.Bai3
import com.example.lab2_andrroidadvanced.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBai1.setOnClickListener {
            startActivity(Intent(this, Bai1::class.java))
        }

        binding.btnBai2.setOnClickListener {
            startActivity(Intent(this, Bai2::class.java))
        }

        binding.btnBai3.setOnClickListener {
            startActivity(Intent(this, Bai3::class.java))
        }
    }
}