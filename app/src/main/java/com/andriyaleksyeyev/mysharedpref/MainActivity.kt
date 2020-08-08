package com.andriyaleksyeyev.mysharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showData()

        saveBtn.setOnClickListener {
            val insertedText = et_name.text.toString()
            val insertedAge = et_age.text.toString().toInt()

            tv_Text.text = "Your name is $insertedText and your age is $insertedAge"

            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("STRING_KEY",insertedText)
            editor.putInt("AGE_KEY",insertedAge)
            editor.putBoolean("BOOLEAN_KEY",sw_switch.isChecked)
            editor.apply()



        }

    }

    fun showData (){
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY",null)
        val savedAge = sharedPreferences.getInt("AGE_KEY",0)
        val savedBoolean = sharedPreferences.getBoolean("BOOLEAN_KEY",false)

        tv_Text.text = "Your name is $savedString and your age is $savedAge"
        sw_switch.isChecked = savedBoolean







    }
}