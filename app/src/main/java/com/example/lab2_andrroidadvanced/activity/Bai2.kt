package com.example.lab2_andrroidadvanced.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab2_andrroidadvanced.R
import com.example.lab2_andrroidadvanced.databinding.ActivityBai2Binding

class Bai2 : AppCompatActivity() {

    companion object {
        const val MY_ACTION = "com.myaction.FPOLY"
    }

    private lateinit var binding: ActivityBai2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBai2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBai2.setOnClickListener {
            if (binding.edtBai2.text.isBlank()) {
                Toast.makeText(this, "No input found!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                sendToBroadcast(binding.edtBai2.text.toString())
            }
        }

    }

    private fun sendToBroadcast(message: String) {
        val intent = Intent(MY_ACTION)
        intent.putExtra("text", message)
        sendBroadcast(intent)
    }

    private val mBroadcast:BroadcastReceiver = object: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (MY_ACTION == intent?.action) {
                val text = intent.getStringExtra("text")
                Toast.makeText(this@Bai2, text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(MY_ACTION)
        registerReceiver(mBroadcast, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(mBroadcast)
    }
}