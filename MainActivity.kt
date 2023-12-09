package com.example.kisan_kalyan_foundation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun navigateToOtherPage(view: View) {
        // Handle navigation here
        val intent = Intent(this, Sign_up::class.java)
        startActivity(intent)
    }

}