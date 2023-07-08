package com.example.trabajitosinc.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trabajitosinc.databinding.ActivityLoginBinding
import com.example.trabajitosinc.util.PreferenceHelper
import com.example.trabajitosinc.util.PreferenceHelper.get
import com.example.trabajitosinc.util.PreferenceHelper.set


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val preferences = PreferenceHelper.defaultPrefs(this)
        if (preferences["session", false]) {
            goToHome()
        }

    }

    private fun goToHome() {
        val i = Intent(this, MainActivity::class.java)
        createSessionPreferences()
        startActivity(i)
        finish()
    }

    private fun createSessionPreferences() {
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
    }

}