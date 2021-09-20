package com.example.lab2_andrroidadvanced.listener

import android.content.Context
import android.telephony.PhoneStateListener
import android.widget.Toast

class MyPhoneStateListener(val mContext: Context) : PhoneStateListener() {
    override fun onCallStateChanged(state: Int, phoneNumber: String?) {

        super.onCallStateChanged(state, phoneNumber)

        if (state == 1) {
            Toast.makeText(mContext, "$phoneNumber is calling", Toast.LENGTH_SHORT).show()
        }
    }
}