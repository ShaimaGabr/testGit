package com.example.myapplicationgit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.chaos.view.PinView

class MainActivity : AppCompatActivity() {
    lateinit var pinView: PinView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pinView=findViewById(R.id.firstPinView)
        button=findViewById(R.id.button)
        pinView.requestFocus()
        val inputMethodManager:InputMethodManager= getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY)
        pinView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               if(p0.toString().length==4){
                 //  button.visibility=View.VISIBLE
                   button.isEnabled=true
                   Toast.makeText(this@MainActivity,"work",Toast.LENGTH_SHORT).show()
               }else{
                   button.isEnabled=false
               }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }
}