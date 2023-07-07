package com.example.trabajitosinc.ui

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
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

    private fun goToLogIn() {
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }

    private fun goToHome() {
        val i = Intent(this, TrabajitosActivity::class.java)
        createSessionPreferences()
        startActivity(i)
        finish()
    }

    private fun createSessionPreferences() {
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
    }

}