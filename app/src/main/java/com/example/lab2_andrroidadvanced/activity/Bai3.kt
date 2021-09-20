package com.example.lab2_andrroidadvanced.activity

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab2_andrroidadvanced.R
import com.example.lab2_andrroidadvanced.broadcast.BroadcastBai3
import com.example.lab2_andrroidadvanced.databinding.ActivityBai3Binding

class Bai3 : AppCompatActivity() {

    companion object {
        const val MY_ACTION = "com.myaction.CHECK_COUPON"
    }

    private lateinit var binding: ActivityBai3Binding
    private lateinit var broadcastReceiver:BroadcastBai3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBai3Binding . inflate (layoutInflater)
        setContentView(binding.root)

        broadcastReceiver = BroadcastBai3()

        binding.btnBai3.setOnClickListener {
            if(binding.edtBai3.text.isBlank()) {
                Toast.makeText(this, "No input found!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                sendToBroadcast(binding.edtBai3.text.toString())
            }
        }
    }

    private fun sendToBroadcast(message:String) {
        val intent = Intent(MY_ACTION)
        intent.putExtra("text", message)
        sendBroadcast(intent)
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(MY_ACTION)
        registerReceiver(broadcastReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}