package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivitySettingsBinding
import com.yariksoffice.lingver.Lingver

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        Log.d("MyLog", "Settings")
        setContentView(binding.root)



        binding.apply {
            ivButtonNB.setOnClickListener {
                finish()
            }
            bSettingsEn.setOnClickListener {
                changeLanguage("en")
                sendIntentOnClick()
            }
            bSettingsRu.setOnClickListener {
                changeLanguage("ru")
                sendIntentOnClick()
            }
        }
    }

    private fun changeLanguage(language: String) {
        Lingver.getInstance().setLocale(this, language)
        recreate()
    }

    private fun sendIntentOnClick() {
        val intent = Intent()
        intent.putExtra("isClicked", true)
        setResult(RESULT_OK, intent)
        Log.d("MyLog", "send intent and isClicked")
    }

    override fun recreate(){
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        Log.d("MyLog", "SettingsReq")
    }
}