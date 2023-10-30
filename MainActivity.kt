package com.example.ashoppingcartapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

   private val homeFragment =HomeFragment()
   private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.button);
        val button2:Button = findViewById(R.id.button3);

        button.setOnClickListener {
            loadHome()
        }
        button2.setOnClickListener{
            loadSettings()
        }
    }

    private fun loadHome(){
        val fragment = supportFragmentManager.findFragmentById(R.id.FragmentContainer)

        if(fragment==null){
            supportFragmentManager.beginTransaction().add(R.id.FragmentContainer,
                homeFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.FragmentContainer,
            homeFragment).commit()
        }
    }

    private fun loadSettings(){
        val fragment = supportFragmentManager.findFragmentById(R.id.FragmentContainer)

        if(fragment==null){
            supportFragmentManager.beginTransaction().add(R.id.FragmentContainer,
                settingsFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.FragmentContainer,
            settingsFragment).commit()
        }
    }


}