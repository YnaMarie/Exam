package com.example.tuazonmidterms

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.tuazonmidterms.databinding.ActivitySplashScreenBinding as ActivitySplashScreenBinding1

class SplashScreen : AppCompatActivity() {
    private lateinit var binding :ActivitySplashScreenBinding1
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding1.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        sharedPreferences = getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE)

        val username = sharedPreferences.getString(USERNAME,"").toString()

        if (username == ""){
            binding.txtWelcomeText.text = "WELCOME TO MY APPLICATION!"
        } else{
            binding.txtWelcomeText.text = "WELCOME TO MY APPLICATION, \n $username";
        }

        object : CountDownTimer(5000,1000){
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                    val intent = Intent(this@SplashScreen,MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
            }
        }.start()
    }
}