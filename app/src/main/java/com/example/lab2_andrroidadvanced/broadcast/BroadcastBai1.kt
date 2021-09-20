package com.example.lab2_andrroidadvanced.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import com.example.lab2_andrroidadvanced.listener.MyPhoneStateListener

class BroadcastBai1 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val myPhoneStateListener = MyPhoneStateListener(context)
        telephonyManager.listen(myPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)

    }
}