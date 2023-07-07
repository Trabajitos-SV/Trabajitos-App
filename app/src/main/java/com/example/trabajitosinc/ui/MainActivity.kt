package com.example.trabajitosinc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabajitosinc.R
import com.example.trabajitosinc.util.PreferenceHelper
import com.example.trabajitosinc.util.PreferenceHelper.get
import com.example.trabajitosinc.util.PreferenceHelper.set

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val preferences = PreferenceHelper.defaultPrefs(this)
        if (preferences["session", false]) {
            goToLogIn()
        }
    }

    private fun goToLogIn() {
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }

    private fun goToHome() {
        val i = Intent(this@MainActivity, TrabajitosActivity::class.java)
        createSessionPreferences()
        startActivity(i)
        finish()
    }

    private fun createSessionPreferences() {
        val preferences = PreferenceHelper.defaultPrefs(this)
        preferences["session"] = true
    }
}