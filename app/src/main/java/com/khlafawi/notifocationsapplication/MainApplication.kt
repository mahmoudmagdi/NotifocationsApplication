package com.khlafawi.notifocationsapplication

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //TODO: STEP[2] register the notification channel
        NotificationsHelper.createNotificationChannel(
            this,
            NotificationManagerCompat.IMPORTANCE_DEFAULT,
            false,
            getString(R.string.app_name),
            "App notification channel."
        )
        //TODO: STEP[2] register the notification channel


        if (checkGooglePlayServices()) {
            // [START retrieve_current_token]
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(
                        "MainApplication",
                        "Fetching FCM registration token failed",
                        task.exception
                    )
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token = task.result

                // Log and toast
                Log.d("MainApplication", token)
                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })
            // [END retrieve_current_token]
        } else {
            //You won't be able to send notifications to this device
            Log.w("MainApplication", "Device doesn't have google play services")
        }
    }


    private fun checkGooglePlayServices(): Boolean {
        // 1
        val status = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this)
        // 2
        return if (status != ConnectionResult.SUCCESS) {
            Log.e("MainApplication", "Error")
            // ask user to update google play services and manage the error.
            false
        } else {
            // 3
            Log.i("MainApplication", "Google play services updated")
            true
        }
    }
}