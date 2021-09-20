package com.example.lab2_andrroidadvanced.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.lab2_andrroidadvanced.Constant
import com.example.lab2_andrroidadvanced.R
import com.example.lab2_andrroidadvanced.broadcast.BroadcastBai1
import com.example.lab2_andrroidadvanced.databinding.ActivityBai1Binding

class Bai1 : AppCompatActivity() {
    private lateinit var binding: ActivityBai1Binding
    private lateinit var mIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBai1Binding.inflate(layoutInflater)
        setContentView(binding.root)

         mIntent = Intent(this, BroadcastBai1::class.java)

        if (!isPermissionGranted()) {
            requestPermission()
        } else {
            readCallingNumber(mIntent)
        }

    }

    private fun isPermissionGranted():Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_PHONE_STATE), Constant.READ_PHONE_STATE)
    }


    private fun readCallingNumber(intent: Intent) {
        sendBroadcast(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == Constant.READ_PHONE_STATE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                readCallingNumber(mIntent)
            }
        }
    }
}