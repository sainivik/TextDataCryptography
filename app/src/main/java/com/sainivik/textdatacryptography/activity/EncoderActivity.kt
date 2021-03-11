package com.sainivik.textdatacryptography.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sainivik.textdatacryptography.R
import com.sainivik.textdatacryptography.databinding.ActivityEncoderBinding
import com.sainivik.textdatacryptography.utils.Encode

class EncoderActivity : AppCompatActivity() {
    lateinit var binding: ActivityEncoderBinding
    var cpb: ClipboardManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_encoder)


        // create a clipboard manager variable to copy text 
        cpb =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    // onClick function of encrypt button 
    fun enc(view: View?) {
        // get text from edittext 
        val temp = binding.etVar1!!.text.toString()

        // pass the string to the encryption 
        // algorithm and get the encrypted code 
        val rv = Encode.encode(temp)

        // set the code to the edit text 
        binding.tvVar1!!.text = rv
    }

    // onClick function of copy text button 
    fun cp2(view: View?) {
        // get the string from the textview and trim all spaces 
        val data = binding.tvVar1!!.text.toString().trim { it <= ' ' }

        // check if the textview is not empty 
        if (!data.isEmpty()) {

            // copy the text in the clip board 
            val temp = ClipData.newPlainText("text", data)
            cpb!!.setPrimaryClip(temp)

            // display message that the text has been copied 
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show()
        }
    }
}