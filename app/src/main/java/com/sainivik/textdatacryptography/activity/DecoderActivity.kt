package com.sainivik.textdatacryptography.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sainivik.textdatacryptography.R
import com.sainivik.textdatacryptography.databinding.ActivityDecoderBinding
import com.sainivik.textdatacryptography.utils.Decode

class DecoderActivity : AppCompatActivity() {
lateinit var binding: ActivityDecoderBinding
    var cplboard: ClipboardManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.  setContentView(this,R.layout.activity_decoder)



        // create a clipboard manager variable to copy text
        cplboard =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    // onClick function of encrypt button 
    fun dec(view: View?) {
        // get code from edittext 
        val temp = binding.etVar1!!.text.toString()
        Log.e("dec", "text - $temp")

        // pass the string to the decryption algorithm 
        // and get the decrypted text 
        val rv = Decode.decode(temp)

        // set the text to the edit text for display 
        binding.tvVar2!!.text = rv
        Log.e("dec", "text - $rv")
    }

    // onClick function of copy text button 
    fun cpl(view: View?) {

        // get the string from the textview and trim all spaces 
        val data = binding.tvVar2!!.text.toString().trim { it <= ' ' }

        // check if the textview is not empty 
        if (!data.isEmpty()) {

            // copy the text in the clip board 
            val temp = ClipData.newPlainText("text", data)

            // display message that the text has been copied 
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show()
        }
    }
}