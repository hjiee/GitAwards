package com.github.gitawards.ui

import android.content.Intent
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.github.gitawards.R
import com.github.gitawards.base.BaseActivity
import com.github.gitawards.databinding.ActivityLoginBinding
import com.github.gitawards.ui.main.MainActivity
import com.google.firebase.auth.OAuthProvider

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        AuthUI.IdpConfig.GitHubBuilder().build()
        OAuthProvider.newBuilder("github.com").apply {
            addCustomParameter("login","hjiee")
        }

        binding.apply {
            btnLoginBasic.setOnClickListener {
                startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                finish()
            }
            btnLoginGithub.setOnClickListener {

            }
        }

    }


}