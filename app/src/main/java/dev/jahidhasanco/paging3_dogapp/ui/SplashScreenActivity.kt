package dev.jahidhasanco.paging3_dogapp.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import dev.jahidhasanco.paging3_dogapp.MainActivity
import dev.jahidhasanco.paging3_dogapp.R
import dev.jahidhasanco.paging3_dogapp.databinding.ActivityMainBinding
import dev.jahidhasanco.paging3_dogapp.databinding.ActivitySplashScreenBinding


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        window.statusBarColor = ContextCompat.getColor(this,R.color.DarkBlue)

        Handler().postDelayed({

            startActivity(Intent(this,MainActivity::class.java))

        }, 1000)

    }
}