package com.vishnevskiypro.serviceexperiment1

import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var start: Button
    lateinit var stop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        start = findViewById(R.id.start)
        stop = findViewById(R.id.stop)


        start.setOnClickListener {
            startService(Intent(this, MyMusicService::class.java))
        }

        stop.setOnClickListener {
            stopService(Intent(this, MyMusicService::class.java))
        }






    }
}