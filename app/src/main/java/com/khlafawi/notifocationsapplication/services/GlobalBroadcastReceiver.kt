package com.khlafawi.notifocationsapplication.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.khlafawi.notifocationsapplication.R

class GlobalBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("onReceive", "onReceive")

        if (context != null && intent != null && intent.action != null) {
            if (intent.action!!.equals(
                    context.getString(R.string.custom_action),
                    ignoreCase = true
                )
            ) {
                val extras = intent.extras
                if (extras != null) {

                    val firsArg = extras.getString("first_arg")
                    val secondArg = extras.getString("second_arg")

                    Toast.makeText(
                        context,
                        "First arg is $firsArg and the second arg is $secondArg ",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}