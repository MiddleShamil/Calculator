package com.example.calculator

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.calculator.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    private var nightMode by Delegates.notNull<Int>()
    private lateinit var isCheckedCallback: ActivityResultLauncher<Intent>
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences = getSharedPreferences("SharedPref", MODE_PRIVATE)
        nightMode = sharedPreferences.getInt("NightModeInt", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        AppCompatDelegate.setDefaultNightMode(nightMode)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isNightMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED ||
                AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
        binding.switchThemeMain.isChecked = isNightMode

        isCheckedCallback = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ recreate() }

        binding.ivButtonNB.setOnClickListener{
            binding.drawer.openDrawer(GravityCompat.START)
        }

        // Menu buttons
        binding.apply {
            bCalculatorMenu.setOnClickListener{
                openFrag(Calculator.newInstance())
                linearLayout.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.background_activity))
                drawer.closeDrawer(GravityCompat.START)
            }
            bQuantitiesMenu.setOnClickListener {
                openFrag(MenuQuantities.newInstance())
                linearLayout.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.background_menu))
                drawer.closeDrawer(GravityCompat.START)
            }
            bSettingsMenu.setOnClickListener {
                isCheckedCallback.launch(Intent(this@MainActivity, SettingsActivity::class.java))
                drawer.closeDrawer(GravityCompat.START)
            }
            switchThemeMain.setOnCheckedChangeListener{ _, isChecked ->
                if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                recreate()
            }
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, Calculator.newInstance())
            .commit()

        dataModel.fragment.observe(this) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, it)
                .commit()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        nightMode = AppCompatDelegate.getDefaultNightMode()
        sharedPreferences = getSharedPreferences("SharedPref", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.putInt("NightModeInt", nightMode)
        editor.apply()
        Log.d("MyLog","Editor savedInstance")

        super.onSaveInstanceState(outState)
    }

    private fun openFrag(f: Fragment) {
        dataModel.fragment.value = f
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, f)
            .commit()
    }
}