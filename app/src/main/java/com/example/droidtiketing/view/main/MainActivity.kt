package com.example.droidtiketing.view.main

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.droidtiketing.R
import com.example.droidtiketing.databinding.ActivityMainBinding
import com.example.droidtiketing.view.history.HistoryActivity
import com.example.droidtiketing.view.input.DataKapalActivity
import com.example.droidtiketing.view.input.DataKeretaActivity
import com.example.droidtiketing.view.input.DataPesawatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        setStatusBar()

        binding.imageProfile.setOnClickListener {
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            startActivity(intent)
        }

        binding.cvPesawat.setOnClickListener {
            val intent = Intent(this@MainActivity, DataPesawatActivity::class.java)
            startActivity(intent)
        }

        binding.cvKapal.setOnClickListener {
            val intent = Intent(this@MainActivity, DataKapalActivity::class.java)
            startActivity(intent)
        }

        binding.cvKereta.setOnClickListener {
            val intent = Intent(this@MainActivity, DataKeretaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setStatusBar() {
        if (Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    companion object {
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val window = activity.window
            val layoutParams = window.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            window.attributes = layoutParams
        }
    }

}