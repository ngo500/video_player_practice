package com.example.video_player

import android.net.Uri
import android.net.Uri.*
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import com.example.video_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get videoView
        val videoView = findViewById<VideoView>(binding.testView.id)

        //create mediaController, and set it to videoView
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        //specify the location of the video file
        val uri: Uri = parse(
            "android.resource://" + "com.example.video_player" + "/raw/test"
        )

        //set the mediaController and uri, and start the view
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}