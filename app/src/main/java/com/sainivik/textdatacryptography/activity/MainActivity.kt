package com.sainivik.textdatacryptography.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sainivik.textdatacryptography.R
import com.sainivik.textdatacryptography.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.btVar1.setOnClickListener { // Intent function to move to another activity
            val intent = Intent(applicationContext, EncoderActivity::class.java)
            startActivity(intent)
        }
        // onClick function for decryption

        // onClick function for decryption
        binding.btVar2.setOnClickListener(View.OnClickListener { // Intent function to move to another activity
            val intent = Intent(applicationContext, DecoderActivity::class.java)
            startActivity(intent)
        })
    }
}