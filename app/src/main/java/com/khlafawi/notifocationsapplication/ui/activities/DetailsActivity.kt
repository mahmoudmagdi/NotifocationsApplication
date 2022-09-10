package com.khlafawi.notifocationsapplication.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val firstArg = intent.extras?.getString("first_arg")
        val secondArg = intent.extras?.getString("second_arg")

        Toast.makeText(
            this,
            "First arg is $firstArg and the second arg is $secondArg ",
            Toast.LENGTH_LONG
        ).show()
    }
}