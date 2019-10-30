package com.github.gitawards.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.gitawards.R
import com.github.gitawards.base.BaseApplication

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        firebaseRemoteConfig()

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 1000)

    }

    private fun firebaseRemoteConfig() {
        BaseApplication.getInstance().let {
            it.remoteConfig.fetchAndActivate()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val updated = task.getResult()
                        Log.d("", "Config params updated: $updated")
                        Toast.makeText(
                            this, "Fetch and activate succeeded",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this, "Fetch failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            it.remoteConfig.getString("app_version")
        }
    }
}
