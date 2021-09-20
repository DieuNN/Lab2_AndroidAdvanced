package com.example.lab2_andrroidadvanced.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.lab2_andrroidadvanced.activity.Bai3

class BroadcastBai3 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if (Bai3.MY_ACTION == intent.action) {
            val text = intent.getStringExtra("text")
            checkCoupon(context,text!!)
        }
    }

    private fun checkCoupon(context: Context, text:String) {
        val textUpperCase = text.uppercase()

        if(textUpperCase.length != 9) {
            Toast.makeText(context, "No coupon found!", Toast.LENGTH_SHORT).show()
            return
        } else {
            if (textUpperCase.substring(0, 3) == "MEM") {
                Toast.makeText(context, "Member detected!", Toast.LENGTH_SHORT).show()
                if(textUpperCase == "MEM537128") {
                    Toast.makeText(context, "10% sale off!", Toast.LENGTH_SHORT).show()
                    return
                }
                if (textUpperCase == "MEM537129") {
                    Toast.makeText(context, "20% sale off!", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            if (textUpperCase.substring(0, 3) == "VIP") {
                Toast.makeText(context, "VIP detected!", Toast.LENGTH_SHORT).show()
                if (textUpperCase == "VIP537128") {
                    Toast.makeText(context, "30% sale off!", Toast.LENGTH_SHORT).show()
                    return
                }
                if (textUpperCase == "VIP537129") {
                    Toast.makeText(context, "50% sale off!", Toast.LENGTH_SHORT).show()
                    return
                }
            }
        }
        Toast.makeText(context, "No coupon found! Check your coupon and try again!", Toast.LENGTH_SHORT).show()
    }

}