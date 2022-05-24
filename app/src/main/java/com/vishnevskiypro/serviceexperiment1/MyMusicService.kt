package com.vishnevskiypro.serviceexperiment1

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyMusicService: Service() {

    lateinit var mediaPlayer: MediaPlayer


    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(applicationContext, Settings.System.DEFAULT_RINGTONE_URI)
            prepare()
            start()
        }

        return START_STICKY
    }


    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }
}